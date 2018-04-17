package com.great.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import com.great.util.Util;

public class FoeTank {
	
	private int TankX;
	private int TankY;
	private Image image;
	private Image imageUP;
	private Image imageDOWN;
	private Image imageLEFT;
	private Image imageRIGTH;
	private int hp;
	private String name;
	private int speed;
	private int wide;
	private int high;

	private int dir;
	private boolean touchUp;
	private boolean touchDown;
	private boolean touchLeft;
	private boolean touchRigth;
	private int site;
	private Random ran;
	
	public FoeTank(int hp,int speed,Image imageUP,Image imageDOWN,Image imageLEFT,Image imageRIGTH,String name,int site) {

		this.name = name;
		this.hp = hp;
		this.speed = speed;
		this.image = imageDOWN;
		this.imageUP = imageUP;
		this.imageDOWN = imageDOWN;
		this.imageLEFT = imageLEFT;
		this.imageRIGTH = imageRIGTH;
		this.site = site;
		init();
		
		
	}
	
	public void init() {
		ran = new Random();
		//site = ran.nextInt(100)%3+1;
		wide = Util.FOE_COM_WIDE;
		high = Util.FOE_COM_HIGH;
		dir = 1;
		switch (site) {
		case 1:
			TankX = Util.SITE1_X;
			TankY = Util.SITE1_Y;
			break;
		case 2:
			TankX = Util.SITE2_X;
			TankY = Util.SITE2_Y;
			break;
		case 3:
			TankX = Util.SITE3_X;
			TankY = Util.SITE3_Y;
			break;
		}
		
	}
	
	public void getMove(int [][]map,MyTank myTank,ArrayList<FoeTank> foeTankList) {
		if(touchUp&&touchDown&&touchLeft&&touchRigth) {
			
			getTouch(map,myTank,foeTankList);
			
		}
		
		switch (dir) {
		case 1:
			if(touchUp&TankY>0) {
				image = imageUP;
				TankY-=speed;	
			}
			break;
		case 2:
			if(touchDown&TankY<730) {
				image = imageDOWN;
				TankY+=speed;
			}
			break;
		case 3:
			if(touchLeft&TankX>0) {
				image = imageLEFT;
				TankX-=speed;
			}
			break;
		case 4:
			if(touchRigth&TankX<730) {
				image = imageRIGTH;
				TankX+=speed;
			}
			break;
		}
		
		switch (dir) {
		case 1:
			if(TankY<=0) {
				dir = ran.nextInt(4)+1;
			}
			break;
		case 2:
			if(TankY>=730) {
				dir = ran.nextInt(4)+1;
			}
			break;
		case 3:
			if(TankX<=0) {
				dir = ran.nextInt(4)+1;
			}
			break;
		case 4:
			if(TankX>=730) {
				dir = ran.nextInt(4)+1;
			}
			break;
		}
		
		if(touchUp&&touchDown&&touchLeft&&touchRigth) {
			
			getTouch(map,myTank,foeTankList);
			
		}
		
		touchUp  = true;
		touchDown = true;
		touchLeft = true;
		touchRigth = true;
		
	}

	
	public void getTouch(int [][]map,MyTank myTank,ArrayList<FoeTank> foeTankList) {
		
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				if(map[i][j]!=0&map[i][j]!=3) {
					Rectangle recBarrier = new Rectangle(j*20, i*20, 20, 20);
					Rectangle recFoeTank = new Rectangle(TankX, TankY, wide, high);
					if(recFoeTank.intersects(recBarrier)) {
						
						switch (dir) {
						case 1:
							TankY+=speed;
							touchUp  = false;
							touchDown = true;
							touchLeft = true;
							touchRigth = true;
							dir = ran.nextInt(2)+3;
							break;
						case 2:
							TankY-=speed;
							touchUp  = true;
							touchDown = false;
							touchLeft = true;
							touchRigth = true;
							dir = ran.nextInt(2)+3;
							break;
						case 3:
							TankX+=speed;
							touchUp  = true;
							touchDown = true;
							touchLeft = false;
							touchRigth = true;
							dir = ran.nextInt(2)+1;
							break;
						case 4:
							TankX-=speed;
							touchUp  = true;
							touchDown = true;
							touchLeft = true;
							touchRigth = false;
							dir = ran.nextInt(2)+1;
							break;
						}

					}
				}
			}
		}
		
		Rectangle recMyTank = new Rectangle(myTank.getTankX(), myTank.getTankY(), myTank.getWide(), myTank.getHigh());
		Rectangle recFoeTank = new Rectangle(TankX, TankY, wide, high);
		if(recFoeTank.intersects(recMyTank)) {
			
			switch (dir) {
			case 1:
				TankY+=speed;
				touchUp  = false;
				touchDown = true;
				touchLeft = true;
				touchRigth = true;
				dir = ran.nextInt(2)+3;
				break;
			case 2:
				TankY-=speed;
				touchUp  = true;
				touchDown = false;
				touchLeft = true;
				touchRigth = true;
				dir = ran.nextInt(2)+3;
				break;
			case 3:
				TankX+=speed;
				touchUp  = true;
				touchDown = true;
				touchLeft = false;
				touchRigth = true;
				dir = ran.nextInt(2)+1;
				break;
			case 4:
				TankX-=speed;
				touchUp  = true;
				touchDown = true;
				touchLeft = true;
				touchRigth = false;
				dir = ran.nextInt(2)+1;
				break;
			}
			
		}
		
		for(int i=0;i<foeTankList.size();i++) {
			for(int j=0;j<foeTankList.size();j++) {
				Rectangle recFoeTank1  = new Rectangle(foeTankList.get(i).getTankX(), foeTankList.get(i).getTankY(), foeTankList.get(i).getWide(), foeTankList.get(i).getHigh());
				Rectangle recFoeTank2 = new Rectangle(foeTankList.get(j).getTankX(), foeTankList.get(j).getTankY(), foeTankList.get(j).getWide(), foeTankList.get(j).getHigh());
				if(i!=j) {
					if(recFoeTank1.intersects(recFoeTank2)) {
						switch (dir) {
						case 1:
							TankY+=speed;
							touchUp  = false;
							touchDown = true;
							touchLeft = true;
							touchRigth = true;
							dir = ran.nextInt(2)+3;
							break;
						case 2:
							TankY-=speed;
							touchUp  = true;
							touchDown = false;
							touchLeft = true;
							touchRigth = true;
							dir = ran.nextInt(2)+3;
							break;
						case 3:
							TankX+=speed;
							touchUp  = true;
							touchDown = true;
							touchLeft = false;
							touchRigth = true;
							dir = ran.nextInt(2)+1;
							break;
						case 4:
							TankX-=speed;
							touchUp  = true;
							touchDown = true;
							touchLeft = true;
							touchRigth = false;
							dir = ran.nextInt(2)+1;
							break;
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * -----------------------get&set---------------------
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSite() {
		return site;
	}

	public void setSite(int site) {
		this.site = site;
	}
	
	
	
	

}
