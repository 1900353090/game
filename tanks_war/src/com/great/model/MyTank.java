package com.great.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import com.great.ctrl.MyKeyListener;
import com.great.util.Util;

public class MyTank {
	
	private int TankX;
	private int TankY;
	private Image Image;
	private int hp;
	private int life;
	private int wide;
	private int high;
	private boolean eat;
	private String eatKind;
	private int dir;
	private boolean touchUp;
	private boolean touchDown;
	private boolean touchLeft;
	private boolean touchRigth;
	private int smash;
	private int score;
	private int sumSmash;
	private int sumScore;
	private String name;
	private int speed;
	
	public MyTank() {
		
		init();
		
	}
	
	public void init() {
		
		TankX = Util.TANK_X;
		TankY = Util.TANK_Y;
		Image = new ImageIcon(Util.PLAYER1_TANK_UP).getImage();
		hp = Util.TANK_HP;
		wide = Util.TANK_WIDE;
		high = Util.TANK_HIGH;
		touchUp  = true;
		touchDown = true;
		touchLeft = true;
		touchRigth = true;
		smash = 0;
		score = 0;
		sumSmash = 0;
		sumScore = 0;
		life = 3;
		eat = false;
		speed = Util.My_TANK_SPEED;
		
	}
	
	public void getMove(int [][]map,ArrayList<FoeTank> foeTankList,ArrayList<Scene> sceneList,AppearSceneThread AppScene,MyKeyListener myKeyListener) {
		if(touchUp&&touchDown&&touchLeft&&touchRigth) {
			
			getTouch(map,foeTankList,sceneList,AppScene,myKeyListener);
			
		}

		
		switch (dir) {
		case 1:
			if(touchUp&&TankY>0) {
				TankY-=speed;
			}
			break;
		case 2:
			if(touchDown&&TankY<Util.GAME_HIGH-Util.TANK_HIGH) {
				TankY+=speed;
			}
			break;
		case 3:
			if(touchLeft&&TankX>0) {
				TankX-=speed;
			}
			break;
		case 4:
			if(touchRigth&&TankX<Util.GAME_WIDE-200-Util.TANK_WIDE) {
				TankX+=speed;
			}
			break;

		}
		
		if(touchUp&&touchDown&&touchLeft&&touchRigth) {
			getTouch(map,foeTankList,sceneList,AppScene,myKeyListener);
		}
		
		touchUp  = true;
		touchDown = true;
		touchLeft = true;
		touchRigth = true;
		
	}
	
	public void getTouch(int [][]map,ArrayList<FoeTank> foeTankList,ArrayList<Scene> sceneList,AppearSceneThread AppScene,MyKeyListener myKeyListener) {
		
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				if(map[i][j]!=0&map[i][j]!=3) {
					Rectangle recBarrier = new Rectangle(j*20, i*20, 20, 20);
					Rectangle recMyTank = new Rectangle(TankX, TankY, wide, high);
					if(recMyTank.intersects(recBarrier)) {
						
						switch (dir) {
						case 1:
							TankY+=speed;
							touchUp  = false;
							touchDown = true;
							touchLeft = true;
							touchRigth = true;
							break;
						case 2:
							TankY-=speed;
							touchUp  = true;
							touchDown = false;
							touchLeft = true;
							touchRigth = true;
							break;
						case 3:
							TankX+=speed;
							touchUp  = true;
							touchDown = true;
							touchLeft = false;
							touchRigth = true;
							break;
						case 4:
							TankX-=speed;
							touchUp  = true;
							touchDown = true;
							touchLeft = true;
							touchRigth = false;
							break;
						}

					}
				}
			}
		}
		
		for(int i=0;i<foeTankList.size();i++) {
			
			Rectangle recFoeTank= new Rectangle(foeTankList.get(i).getTankX(), foeTankList.get(i).getTankY(), foeTankList.get(i).getWide(), foeTankList.get(i).getHigh());
			Rectangle recMyTank = new Rectangle(TankX, TankY, wide, high);
			if(recMyTank.intersects(recFoeTank)) {
				switch (dir) {
				case 1:
					TankY+=speed;
					touchUp  = false;
					touchDown = true;
					touchLeft = true;
					touchRigth = true;
					break;
				case 2:
					TankY-=speed;
					touchUp  = true;
					touchDown = false;
					touchLeft = true;
					touchRigth = true;
					break;
				case 3:
					TankX+=speed;
					touchUp  = true;
					touchDown = true;
					touchLeft = false;
					touchRigth = true;
					break;
				case 4:
					TankX-=speed;
					touchUp  = true;
					touchDown = true;
					touchLeft = true;
					touchRigth = false;
					break;
				}
			}
			
		}
		
		for(int i=0;i<sceneList.size();i++) {
			Rectangle recScene = new Rectangle(sceneList.get(i).getSceneX(),sceneList.get(i).getSceneY(),60,60);
			Rectangle recMyTank = new Rectangle(TankX, TankY, wide, high);
			if(recMyTank.intersects(recScene)) {
				if(sceneList.get(i).getName().equals("血包")&hp<3) {
					hp+=1;
					eatKind="血包";
				}
				if(sceneList.get(i).getName().equals("打铁包")) {
					myKeyListener.setForgeIron(true);
					eatKind="打铁包";
				}
				if(sceneList.get(i).getName().equals("防御包")) {
					for(int j=34;j<map.length;j++) {
						map[j][16] = 2;
						map[j][17] = 2;
						map[j][22] = 2;
						map[j][23] = 2;
					}
					for(int j=34;j<=35;j++) {
						map[j][18] = 2;
						map[j][19] = 2;
						map[j][20] = 2;
						map[j][21] = 2;
					}
					eatKind="防御包";
				}
				eat = true;
				sceneList.get(i).setFlag(false);
				sceneList.remove(i);
				
			}
		}
		
	}

	
	/**
	 * ------------------get&set------------------------------
	 * @return
	 */
	public int getTankX() {
		return TankX;
	}

	public void setTankX(int tankX) {
		TankX = tankX;
	}

	public int getTankY() {
		return TankY;
	}

	public void setTankY(int tankY) {
		TankY = tankY;
	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
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

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getSmash() {
		return smash;
	}

	public void setSmash(int smash) {
		this.smash = smash;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSumSmash() {
		return sumSmash;
	}

	public void setSumSmash(int sumSmash) {
		this.sumSmash = sumSmash;
	}

	public int getSumScore() {
		return sumScore;
	}

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEat() {
		return eat;
	}

	public void setEat(boolean eat) {
		this.eat = eat;
	}

	public String getEatKind() {
		return eatKind;
	}

	public void setEatKind(String eatKind) {
		this.eatKind = eatKind;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}



	
	
}
