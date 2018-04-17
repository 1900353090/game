package com.great.model;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.great.ctrl.Ctrl;
import com.great.util.Util;

public class MyBullet {
	
	private int bulletX;
	private int bulletY;
	private int dir;
	private int speed;
	private int wide;
	private int high;
	private boolean forgeIron;
	
	public MyBullet(int TankX,int TankY,int dir,boolean forgeIron) {
		this.dir = dir;
		init(TankX,TankY,forgeIron);
		
	}
	
	public void init(int TankX,int TankY,boolean forgeIron) {
		
		speed = Util.MY_BULLET_SPEED;
		wide = Util.BULLET_WIDE;
		high = Util.BULLET_HIGH;
		this.forgeIron = forgeIron;
		
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

	public void getMove(ArrayList<MyBullet> myBList,int [][]map,ArrayList<FoeTank> foeTankList,ArrayList<FoeBullet> foeBList,Ctrl ctrl) {
		
		switch (dir) {
		case 1:
			getTouch(myBList,map,foeTankList,foeBList,ctrl);
			bulletY -= speed;
			break;
		case 2:
			getTouch(myBList,map,foeTankList,foeBList,ctrl);
			bulletY += speed;
			break;
		case 3:
			getTouch(myBList,map,foeTankList,foeBList,ctrl);
			bulletX -= speed;
			break;
		case 4:
			getTouch(myBList,map,foeTankList,foeBList,ctrl);
			bulletX += speed;
			break;
		default:
			bulletY -= speed;
			break;
		
		}
		
	}
	
	
	public void getTouch(ArrayList<MyBullet> myBList,int [][]map,ArrayList<FoeTank> foeTankList,ArrayList<FoeBullet> foeBList,Ctrl ctrl) {
		
		for(int i=0;i<myBList.size();i++) {
			for(int j=0;j<map.length;j++){
				for(int x=0;x<map[j].length;x++){
					if(map[j][x]!=0&map[j][x]!=3&map[j][x]!=4) {
						Rectangle recBarrier = new Rectangle(x*20, j*20, 20, 20);
						Rectangle recMyBullet = new Rectangle(myBList.get(i).getBulletX(), myBList.get(i).getBulletY(), myBList.get(i).getWide(), myBList.get(i).getHigh());
						if(recMyBullet.intersects(recBarrier)) {
							if(map[j][x]==1) {
								map[j][x]=0;
							}
							if(map[j][x]==2&forgeIron) {
								map[j][x]=0;
							}
							myBList.remove(i);
							return;
						}
						if(bulletX<0||bulletX>790||bulletY<0||bulletY>790) {
							myBList.remove(i);
							return;
						}
					}
				}
			}
			
			for(int j=0;j<foeTankList.size();j++) {
				Rectangle recFoeTank = new Rectangle(foeTankList.get(j).getTankX(), foeTankList.get(j).getTankY(), foeTankList.get(j).getWide(), foeTankList.get(j).getHigh());
				Rectangle recMyBullet = new Rectangle(myBList.get(i).getBulletX(), myBList.get(i).getBulletY(), myBList.get(i).getWide(), myBList.get(i).getHigh());
				if(recMyBullet.intersects(recFoeTank)) {
					foeTankList.get(j).setHp(foeTankList.get(j).getHp()-1);
					if(foeTankList.get(j).getHp()==0) {
						if(foeTankList.get(j).getName()=="white") {
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getScore()+100);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore()+100);
						}
						if(foeTankList.get(j).getName()=="yellow") {
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getScore()+200);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore()+200);
						}
						if(foeTankList.get(j).getName()=="green") {
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getScore()+200);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore()+200);
						}
						if(foeTankList.get(j).getName()=="blue") {
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getScore()+300);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore()+300);
						}
						if(foeTankList.get(j).getName()=="red") {
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getScore()+500);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumSmash(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash()+1);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSumScore(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore()+500);
						}
						
						Bomb foeTankBomb = new Bomb(foeTankList.get(j).getTankX(),foeTankList.get(j).getTankY(),Util.FOE_COM_WIDE,Util.FOE_COM_HIGH);
						ctrl.getTanksWarFrame().getGamePanel().getBombList().add(foeTankBomb);
						
						myBList.remove(i);
						foeTankList.remove(j);
						
						if(foeTankList.size()==0) {
//							ctrl.getAppFoeBullet().setFlag(false);
							ctrl.getAppFoeTank().setFlag(true);
						}
						
						switch (ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash()) {
						case 20:
							ctrl.getTanksWarFrame().getGamePanel().setMap(Util.MAP_TWO);
							break;
						case 40:
							ctrl.getTanksWarFrame().getGamePanel().setMap(Util.MAP_THREE);
							break;
						case 60:
							ctrl.getTanksWarFrame().getGamePanel().setMap(Util.MAP_FOUR);
							break;
						case 80:
							ctrl.getTanksWarFrame().getGamePanel().setMap(Util.MAP_FIVE);
							break;
						case 100:
							ctrl.getTanksWarFrame().getGamePanel().setMap(Util.MAP_SIX);
							break;
						case 120:
							ctrl.getTanksWarFrame().getGamePanel().setMap(Util.MAP_SEVEN);
							break;
						case 140:
							ctrl.getTanksWarFrame().getGamePanel().setMap(Util.MAP_EIGHT);
							break;
						case 160:
							Util.getWrite(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getName(), ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore(), ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash());
							//初始化一个标签用来显示游戏结束和得分
							JLabel jl=new JLabel("Game Over 得分:"+ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumScore());
							jl.setBounds(105, 60, 380, 65);	//设置标签大小和位置
							ctrl.getOverDialog().add(jl);	//添加标签到对话窗上
							ctrl.getOverDialog().setModal(true);	//设置父窗不可获取焦点
							ctrl.getOverDialog().setVisible(true);	//显示对话窗
							break;
						}
						
						int killFoe = ctrl.getTanksWarFrame().getGamePanel().getMyTank().getSumSmash();
						
						if(killFoe==20||killFoe==40||killFoe==60||killFoe==80||killFoe==100||killFoe==120||killFoe==140) {
							ctrl.getAppFoeTank().setNum(0);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setTankX(Util.TANK_X);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setTankY(Util.TANK_Y);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setImage(new ImageIcon(Util.PLAYER1_TANK_UP).getImage());
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setScore(0);
							ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSmash(0);
							ctrl.getAppFoeTank().setBlueNum(0);
							ctrl.getAppFoeTank().setWhiteNum(0);
							ctrl.getAppFoeTank().setRedNum(0);
							ctrl.getAppFoeTank().setYellowNum(0);
							ctrl.getAppFoeTank().setGreenNum(0);
							ctrl.getAppFoeTank().setFlag(true);
						}
						
					}else {
						
						Bomb foeTankBomb = new Bomb(myBList.get(i).getBulletX(),myBList.get(i).getBulletY(),Util.BULLET_WIDE*4,Util.BULLET_HIGH*4);
						ctrl.getTanksWarFrame().getGamePanel().getBombList().add(foeTankBomb);
						myBList.remove(i);
						
					}

					return;
					
				}
			}
			
			try {
				for(int j=0;j<foeBList.size();j++) {
					Rectangle recFoeBullet = new Rectangle(foeBList.get(j).getBulletX(),foeBList.get(j).getBulletY(),foeBList.get(j).getWide(),foeBList.get(j).getHigh());
					Rectangle recMyBullet = new Rectangle(myBList.get(i).getBulletX(), myBList.get(i).getBulletY(), myBList.get(i).getWide(), myBList.get(i).getHigh());
					if(recMyBullet.intersects(recFoeBullet)) {
						myBList.remove(i);
						foeBList.remove(j);
						return;
						
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	
	/**
	 * -----------------------get&set--------------------------
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

	public boolean isForgeIron() {
		return forgeIron;
	}

	public void setForgeIron(boolean forgeIron) {
		this.forgeIron = forgeIron;
	}
	
	

}
