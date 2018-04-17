package com.great.model;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import com.great.ctrl.Ctrl;
import com.great.util.Util;

public class AppearFoeTankThread extends Thread{
	
	private Ctrl ctrl;
	private boolean flag;
	private int num;
	private Random ran;
	private int whiteNum;
	private int yellowNum;
	private int greenNum;
	private int blueNum;
	private int redNum;
	private int white;
	private int yellow;
	private int green;
	private int blue;
	private int red;
	private int whiteTankNum;
	private int yellowTankNum;
	private int greenTankNum;
	private int blueTankNum;
	private int redTankNum;
	private boolean onOFF;
	
	public AppearFoeTankThread(Ctrl ctrl) {
		
		this.ctrl = ctrl;
		flag = true;
		num = 0;
		ran = new Random();
		whiteNum = 0;
		yellowNum = 0;
		greenNum = 0;
		blueNum = 0;
		redNum = 0;
		onOFF = true;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			if(onOFF) {

			//	if(flag&num<2) {
					for(int i=0;i<20;i++) {
						if(ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().size()<10) {
							switch (ran.nextInt(5)+1) {
							case 1:
								if(white>whiteNum) {
									
									int judge = getCoincide();
									
									if(judge!=4) {
										FoeTank foeTankWhite = new FoeTank(Util.FOE_WHITE_HP,Util.FOE_WHITE_SPEED,new ImageIcon(Util.FOE_WHITE_UP).getImage(),new ImageIcon(Util.FOE_WHITE_DOWN).getImage(),new ImageIcon(Util.FOE_WHITE_LEFT).getImage(),new ImageIcon(Util.FOE_WHITE_RIGTH).getImage(),"white",judge);
										ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().add(foeTankWhite);
										whiteNum++;
									}else {i--;}
								}else {i--;}
								break;
							case 2:
								if(yellow>yellowNum) {
									
									int judge = getCoincide();
								
									if(judge!=4) {
										FoeTank foeTankYellow= new FoeTank(Util.FOE_YELLOW_HP,Util.FOE_YELLOW_SPEED,new ImageIcon(Util.FOE_YELLOW_UP).getImage(),new ImageIcon(Util.FOE_YELLOW_DOWN).getImage(),new ImageIcon(Util.FOE_YELLOW_LEFT).getImage(),new ImageIcon(Util.FOE_YELLOW_RIGTH).getImage(),"yellow",judge);
										ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().add(foeTankYellow);
										yellowNum++;
									}else {i--;}
								}else {i--;}
								break;
							case 3:
								if(green>greenNum) {
									
									int judge = getCoincide();
									
									if(judge!=4) {
										FoeTank foeTankGreen = new FoeTank(Util.FOE_GREEN_HP,Util.FOE_GREEN_SPEED,new ImageIcon(Util.FOE_GREEN_UP).getImage(),new ImageIcon(Util.FOE_GREEN_DOWN).getImage(),new ImageIcon(Util.FOE_GREEN_LEFT).getImage(),new ImageIcon(Util.FOE_GREEN_RIGTH).getImage(),"green",judge);
										ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().add(foeTankGreen);
										greenNum++;
									}else {i--;}
								}else {i--;}
								break;
							case 4:
								if(blue>blueNum) {
									
									int judge = getCoincide();
									
									if(judge!=4) {
										FoeTank foeTankBlue = new FoeTank(Util.FOE_BLUE_HP,Util.FOE_BLUE_SPEED,new ImageIcon(Util.FOE_BLUE_UP).getImage(),new ImageIcon(Util.FOE_BLUE_DOWN).getImage(),new ImageIcon(Util.FOE_BLUE_LEFT).getImage(),new ImageIcon(Util.FOE_BLUE_RIGTH).getImage(),"blue",judge);
										ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().add(foeTankBlue);
										blueNum++;
									}else {i--;}
								}else {i--;}
								break;
							case 5:
								if(red>redNum) {
									
									int judge = getCoincide();
									
									if(judge!=4) {
										FoeTank foeTankRed = new FoeTank(Util.FOE_RED_HP,Util.FOE_RED_SPEED,new ImageIcon(Util.FOE_RED_UP).getImage(),new ImageIcon(Util.FOE_RED_DOWN).getImage(),new ImageIcon(Util.FOE_RED_LEFT).getImage(),new ImageIcon(Util.FOE_RED_RIGTH).getImage(),"red",judge);
										ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().add(foeTankRed);
										redNum++;
									}else {i--;}
								}else {i--;}
								break;
								
							}
						}
						
						
						if(!onOFF) {
							return;
						}
						

						try {
							getCount();
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						try {
							sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
					
					
					num++;
					flag = false;
					
			//	}
				
				getCount();
				
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
	}
	
	public void getCount() {
		whiteTankNum = 0;
		yellowTankNum = 0;
		greenTankNum = 0;
		blueTankNum = 0;
		redTankNum = 0;
		for(int q=0;q<ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().size();q++) {
			if(ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(q).getName()=="white") {
				whiteTankNum++;
			}
			if(ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(q).getName()=="red") {
				redTankNum++;
			}
			if(ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(q).getName()=="blue") {
				blueTankNum++;
			}
			if(ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(q).getName()=="green") {
				greenTankNum++;
			}
			if(ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(q).getName()=="yellow") {
				yellowTankNum++;
			}
		}
	}
	
	
	public int getCoincide() {
		
		int judge = 0;
		boolean site1 = true;
		boolean site2 = true;
		boolean site3 = true;
		int site = 1;
		while(true) {
			
			try {
				for(int i=0;i<ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().size();i++) {
					Rectangle recFoeTank  = new Rectangle(ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).getTankX(),ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).getTankY(),ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).getWide(),ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).getHigh());
					switch (site) {
					case 1:
						Rectangle recSite1 = new Rectangle(250,0,70,70);
						if(recFoeTank.intersects(recSite1)) {
							site1 = false;
						}
						break;
					case 2:
						Rectangle recSite2 = new Rectangle(365,120,70,70);
						if(recFoeTank.intersects(recSite2)) {
							site2 = false;
						}
						break;
					case 3:
						Rectangle recSite3 = new Rectangle(480,0,70,70);
						if(recFoeTank.intersects(recSite3)) {
							site3 = false;
						}
						break;
					}
					judge++;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			Rectangle recMyTank  = new Rectangle(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getTankX(),ctrl.getTanksWarFrame().getGamePanel().getMyTank().getTankY(),ctrl.getTanksWarFrame().getGamePanel().getMyTank().getWide(),ctrl.getTanksWarFrame().getGamePanel().getMyTank().getHigh());
			switch (site) {
			case 1:
				Rectangle recSite1 = new Rectangle(250,0,70,70);
				if(recMyTank.intersects(recSite1)) {
					site1 = false;
				}
				break;
			case 2:
				Rectangle recSite2 = new Rectangle(365,120,70,70);
				if(recMyTank.intersects(recSite2)) {
					site2 = false;
				}
				break;
			case 3:
				Rectangle recSite3 = new Rectangle(480,0,70,70);
				if(recMyTank.intersects(recSite3)) {
					site3 = false;
				}
				break;
			}
			if(site==3) {
				if(site1){return 1;}
				if(site2){return 2;}
				if(site3){return 3;}
				site = 1;
				return 4;
			}
			site++;
			if(judge==0) {
				return 2;
			}
			
		}
		
	}

	
	/**
	 * 
	 * ----------------get&set-------------------
	 * @return
	 */
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getWhite() {
		return white;
	}

	public void setWhite(int white) {
		this.white = white;
	}

	public int getYellow() {
		return yellow;
	}

	public void setYellow(int yellow) {
		this.yellow = yellow;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getWhiteNum() {
		return whiteNum;
	}

	public void setWhiteNum(int whiteNum) {
		this.whiteNum = whiteNum;
	}

	public int getYellowNum() {
		return yellowNum;
	}

	public void setYellowNum(int yellowNum) {
		this.yellowNum = yellowNum;
	}

	public int getGreenNum() {
		return greenNum;
	}

	public void setGreenNum(int greenNum) {
		this.greenNum = greenNum;
	}

	public int getBlueNum() {
		return blueNum;
	}

	public void setBlueNum(int blueNum) {
		this.blueNum = blueNum;
	}

	public int getRedNum() {
		return redNum;
	}

	public void setRedNum(int redNum) {
		this.redNum = redNum;
	}

	public int getWhiteTankNum() {
		return whiteTankNum;
	}

	public void setWhiteTankNum(int whiteTankNum) {
		this.whiteTankNum = whiteTankNum;
	}

	public int getYellowTankNum() {
		return yellowTankNum;
	}

	public void setYellowTankNum(int yellowTankNum) {
		this.yellowTankNum = yellowTankNum;
	}

	public int getGreenTankNum() {
		return greenTankNum;
	}

	public void setGreenTankNum(int greenTankNum) {
		this.greenTankNum = greenTankNum;
	}

	public int getBlueTankNum() {
		return blueTankNum;
	}

	public void setBlueTankNum(int blueTankNum) {
		this.blueTankNum = blueTankNum;
	}

	public int getRedTankNum() {
		return redTankNum;
	}

	public void setRedTankNum(int redTankNum) {
		this.redTankNum = redTankNum;
	}

	public boolean isOnOFF() {
		return onOFF;
	}

	public void setOnOFF(boolean onOFF) {
		this.onOFF = onOFF;
	}
	
	
	
	
}
