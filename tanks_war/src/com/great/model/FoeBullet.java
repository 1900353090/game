package com.great.model;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.great.ctrl.Ctrl;
import com.great.util.Util;

public class FoeBullet {
	
	private int bulletX;
	private int bulletY;
	private int dir;
	private int speed;
	private int wide;
	private int high;
	
	public FoeBullet(int TankX,int TankY,int dir) {
		this.dir = dir;
		init(TankX,TankY);
		
	}
	
	public void init(int TankX,int TankY) {
		
		speed = Util.FOE_BULLET_SPEED;
		wide = Util.BULLET_WIDE;
		high = Util.BULLET_HIGH;
		
		switch (dir) {
		case 1:
			bulletX = TankX+Util.TANK_WIDE/2-5;
			bulletY = TankY;
			break;
		case 2:
			bulletX = TankX+Util.TANK_WIDE/2-5;
			bulletY = TankY+Util.TANK_HIGH;
			break;
		case 3:
			bulletX = TankX;
			bulletY = TankY+Util.TANK_HIGH/2-5;
			break;
		case 4:
			bulletX = TankX+Util.TANK_WIDE;
			bulletY = TankY+Util.TANK_HIGH/2-5;
			break;
		}
		
	}
	
	public void getMove(ArrayList<FoeBullet> foeBList,int [][]map,MyTank myTank,ArrayList<MyBullet> myBList,Ctrl ctrl) {
		
		switch (dir) {
		case 1:
			getTouch(foeBList,map,myTank,myBList,ctrl);
			bulletY -= speed;
			break;
		case 2:
			getTouch(foeBList,map,myTank,myBList,ctrl);
			bulletY += speed;
			break;
		case 3:
			getTouch(foeBList,map,myTank,myBList,ctrl);
			bulletX -= speed;
			break;
		case 4:
			getTouch(foeBList,map,myTank,myBList,ctrl);
			bulletX += speed;
			break;
			
		}
		
	}
	
	public void getTouch(ArrayList<FoeBullet> foeBList,int [][]map,MyTank myTank,ArrayList<MyBullet> myBList,Ctrl ctrl) {
		
		try {
			for(int i=0;i<foeBList.size();i++) {
				for(int j=0;j<map.length;j++){
					for(int x=0;x<map[j].length;x++){
						if(map[j][x]!=0&map[j][x]!=3&map[j][x]!=4) {
							Rectangle recBarrier = new Rectangle(x*20, j*20, 20, 20);
							Rectangle recFoeBullet = new Rectangle(foeBList.get(i).getBulletX(), foeBList.get(i).getBulletY(), foeBList.get(i).getWide(), foeBList.get(i).getHigh());
							if(recFoeBullet.intersects(recBarrier)) {
								if(map[j][x]==1) {
									map[j][x]=0;
								}
								foeBList.remove(i);
								return;
							}
							if(foeBList.get(i).getBulletX()<0||foeBList.get(i).getBulletX()>790||foeBList.get(i).getBulletY()<0||foeBList.get(i).getBulletY()>790) {
								foeBList.remove(i);
								return;
							}
						}
					}
				}
				
					Rectangle recMyTank = new Rectangle(myTank.getTankX(), myTank.getTankY(), myTank.getWide(), myTank.getHigh());
					Rectangle recFoeBullet = new Rectangle(foeBList.get(i).getBulletX(), foeBList.get(i).getBulletY(), foeBList.get(i).getWide(), foeBList.get(i).getHigh());
					if(recFoeBullet.intersects(recMyTank)) {
						myTank.setHp(myTank.getHp()-1);
						if(myTank.getHp()==0) {
							Bomb MyTankBomb2 = new Bomb(myTank.getTankX(), myTank.getTankY(),myTank.getWide(),myTank.getHigh());
							ctrl.getTanksWarFrame().getGamePanel().getBombList().add(MyTankBomb2);
							myTank.setTankX(Util.TANK_X);
							myTank.setTankY(Util.TANK_Y);
							myTank.setLife(myTank.getLife()-1);
							myTank.setHp(3);
						}else {
							Bomb MyTankBomb1 = new Bomb(foeBList.get(i).getBulletX(), foeBList.get(i).getBulletY(), foeBList.get(i).getWide()*3, foeBList.get(i).getHigh()*3);
							ctrl.getTanksWarFrame().getGamePanel().getBombList().add(MyTankBomb1);
							foeBList.remove(i);
						}
						if(myTank.getLife()==0) {
							Util.getWrite(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getName(), ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore(), ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash());
							//初始化一个标签用来显示游戏结束和得分
							JLabel jl=new JLabel("Game Over 得分:"+ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore());
							jl.setBounds(105, 60, 380, 65);	//设置标签大小和位置
							ctrl.getOverDialog().add(jl);	//添加标签到对话窗上
							ctrl.getOverDialog().setModal(true);	//设置父窗不可获取焦点
							ctrl.getOverDialog().setVisible(true);	//显示对话窗
						}
						return;
						
					}
				
					//Rectangle recFoeBullet1 = new Rectangle(foeBList.get(i).getBulletX(), foeBList.get(i).getBulletY(), foeBList.get(i).getWide(), foeBList.get(i).getHigh());
					Rectangle recMybase = new Rectangle(360,720,80,80);
					if(recMybase.intersects(recFoeBullet)) {
						Util.getWrite(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getName(), ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore(), ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash());
						//初始化一个标签用来显示游戏结束和得分
						JLabel jl=new JLabel("Game Over 得分:"+ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore());
						jl.setBounds(105, 60, 380, 65);	//设置标签大小和位置
						ctrl.getOverDialog().add(jl);	//添加标签到对话窗上
						ctrl.getOverDialog().setModal(true);	//设置父窗不可获取焦点
						ctrl.getOverDialog().setVisible(true);	//显示对话窗
					}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	/**
	 * ------------------------get&set-----------------------
	 * @return
	 */
	public int getBulletX() {
		return bulletX;
	}

	public void setBulletX(int bulletX) {
		this.bulletX = bulletX;
	}

	public int getBulletY() {
		return bulletY;
	}

	public void setBulletY(int bulletY) {
		this.bulletY = bulletY;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getWide() {
		return wide;
	}

	public void setWide(int wide) {
		this.wide = wide;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}
	
	
	
	
	

}
