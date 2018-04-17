package com.great.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.great.ctrl.Ctrl;
import com.great.ctrl.MyFocusListener;
import com.great.ctrl.MyKeyListener;
import com.great.model.Bomb;
import com.great.model.FoeBullet;
import com.great.model.FoeTank;
import com.great.model.MyBullet;
import com.great.model.MyTank;
import com.great.model.Scene;
import com.great.util.Util;

public class GamePanel extends JPanel{
	
	private MyTank myTank;
	private MyKeyListener keyListener;
	private int [][] map;
	private ArrayList<MyBullet> myBList;
	private ArrayList<FoeTank> foeTankList;
	private ArrayList<FoeBullet> foeBList;
	private ArrayList<Bomb> bombList;
	private ArrayList<Scene> sceneList;
	private Ctrl ctrl;
	private MyFocusListener myFocusListener;
	
	
	public GamePanel(Ctrl ctrl) {
		this.ctrl = ctrl;
		init();

		this.addFocusListener(myFocusListener);
		this.addKeyListener(keyListener);
		this.setFocusable(true);
		this.requestFocus();
		this.setPreferredSize(new Dimension(Util.GAME_WIDE,Util.GAME_HIGH));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon(Util.MAP_IMG).getImage(), 0, 0, 800, 800, this);
		
		for(int i=0;i<foeTankList.size();i++) {
			g.drawImage(foeTankList.get(i).getImage(), foeTankList.get(i).getTankX(), foeTankList.get(i).getTankY(), foeTankList.get(i).getWide(), foeTankList.get(i).getHigh(), this);
		}
		
		g.drawImage(myTank.getImage(), myTank.getTankX(), myTank.getTankY(), myTank.getWide(), myTank.getHigh(), this);
		
		g.setColor(Color.YELLOW);
		for(int i=0;i<myBList.size();i++) {
			g.fillOval(myBList.get(i).getBulletX(), myBList.get(i).getBulletY(), myBList.get(i).getWide(), myBList.get(i).getHigh());
		}
		g.setColor(Color.BLUE);
		for(int i=0;i<foeBList.size();i++) {
			g.fillOval(foeBList.get(i).getBulletX(), foeBList.get(i).getBulletY(), foeBList.get(i).getWide(), foeBList.get(i).getHigh());
		}
		
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				
				switch (map[i][j]) {
				case 1:
					g.drawImage(new ImageIcon(Util.BRICK_IMG).getImage(), j*20, i*20, 20, 20, this);
					break;
				case 2:
					g.drawImage(new ImageIcon(Util.IRON_IMG).getImage(), j*20, i*20, 20, 20, this);
					break;
				case 3:
					g.drawImage(new ImageIcon(Util.LAWN_IMG).getImage(), j*20, i*20, 20, 20, this);
					break;
				case 4:
					g.drawImage(new ImageIcon(Util.RIVER_IMG).getImage(), j*20, i*20, 20, 20, this);
					break;
				}
				
			}
		}
		
		for(int i=0;i<sceneList.size();i++) {
			try {
				g.drawImage(sceneList.get(i).getImage(), sceneList.get(i).getSceneX(), sceneList.get(i).getSceneY(), 60, 60, this);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		int TankX = ctrl.getTanksWarFrame().getGamePanel().getMyTank().getTankX();
		int TankY = ctrl.getTanksWarFrame().getGamePanel().getMyTank().getTankY();
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("����",Font.BOLD,200));
		if(map==Util.MAP_ONE) {
			ctrl.getAppFoeTank().setYellow(7);
			ctrl.getAppFoeTank().setWhite(10);
			ctrl.getAppFoeTank().setBlue(1);
			ctrl.getAppFoeTank().setGreen(2);
			ctrl.getAppFoeTank().setRed(0);
			if(TankX==Util.TANK_X&TankY==Util.TANK_Y) {
				g.drawString("��һ��!", 60, 500);
			}
			g.setFont(new Font("����",Font.BOLD,40));
			g.drawString("һ", 940, 590);
		}
		if(map==Util.MAP_TWO) {
			ctrl.getAppFoeTank().setYellow(6);
			ctrl.getAppFoeTank().setWhite(8);
			ctrl.getAppFoeTank().setBlue(2);
			ctrl.getAppFoeTank().setGreen(4);
			ctrl.getAppFoeTank().setRed(0);
			if(TankX==Util.TANK_X&TankY==Util.TANK_Y) {
				g.drawString("�ڶ���!", 60, 500);
			}
			g.setFont(new Font("����",Font.BOLD,40));
			g.drawString("��", 940, 590);
		}
		if(map==Util.MAP_THREE) {
			ctrl.getAppFoeTank().setYellow(5);
			ctrl.getAppFoeTank().setWhite(6);
			ctrl.getAppFoeTank().setBlue(2);
			ctrl.getAppFoeTank().setGreen(6);
			ctrl.getAppFoeTank().setRed(1);
			if(TankX==Util.TANK_X&TankY==Util.TANK_Y) {
				g.drawString("������!", 60, 500);
			}
			g.setFont(new Font("����",Font.BOLD,40));
			g.drawString("��", 940, 590);
		}
		if(map==Util.MAP_FOUR) {
			ctrl.getAppFoeTank().setYellow(4);
			ctrl.getAppFoeTank().setWhite(4);
			ctrl.getAppFoeTank().setBlue(4);
			ctrl.getAppFoeTank().setGreen(6);
			ctrl.getAppFoeTank().setRed(2);
			if(TankX==Util.TANK_X&TankY==Util.TANK_Y) {
				g.drawString("���Ĺ�!", 60, 500);
			}
			g.setFont(new Font("����",Font.BOLD,40));
			g.drawString("��", 940, 590);
		}
		if(map==Util.MAP_FIVE) {
			ctrl.getAppFoeTank().setYellow(3);
			ctrl.getAppFoeTank().setWhite(2);
			ctrl.getAppFoeTank().setBlue(6);
			ctrl.getAppFoeTank().setGreen(5);
			ctrl.getAppFoeTank().setRed(4);
			if(TankX==Util.TANK_X&TankY==Util.TANK_Y) {
				g.drawString("�����!", 60, 500);
			}
			g.setFont(new Font("����",Font.BOLD,40));
			g.drawString("��", 940, 590);
		}
		if(map==Util.MAP_SIX) {
			ctrl.getAppFoeTank().setYellow(2);
			ctrl.getAppFoeTank().setWhite(1);
			ctrl.getAppFoeTank().setBlue(7);
			ctrl.getAppFoeTank().setGreen(4);
			ctrl.getAppFoeTank().setRed(6);
			if(TankX==Util.TANK_X&TankY==Util.TANK_Y) {
				g.drawString("������!", 60, 500);
			}
			g.setFont(new Font("����",Font.BOLD,40));
			g.drawString("��", 940, 590);
		}
		if(map==Util.MAP_SEVEN) {
			ctrl.getAppFoeTank().setYellow(1);
			ctrl.getAppFoeTank().setWhite(0);
			ctrl.getAppFoeTank().setBlue(8);
			ctrl.getAppFoeTank().setGreen(4);
			ctrl.getAppFoeTank().setRed(7);
			if(TankX==Util.TANK_X&TankY==Util.TANK_Y) {
				g.drawString("���߹�!", 60, 500);
			}
			g.setFont(new Font("����",Font.BOLD,40));
			g.drawString("��", 940, 590);
		}
		if(map==Util.MAP_EIGHT) {
			ctrl.getAppFoeTank().setYellow(0);
			ctrl.getAppFoeTank().setWhite(0);
			ctrl.getAppFoeTank().setBlue(6);
			ctrl.getAppFoeTank().setGreen(4);
			ctrl.getAppFoeTank().setRed(10);
			if(TankX==Util.TANK_X&TankY==Util.TANK_Y) {
				g.drawString("�ڰ˹�!", 60, 500);
			}
			g.setFont(new Font("����",Font.BOLD,40));
			g.drawString("��", 940, 590);
		}
		
		g.drawImage(new ImageIcon(Util.PLAYER_BASE).getImage(), 360, 720, 80, 80, this);
		g.drawImage(new ImageIcon(Util.FOE_BASE).getImage(), 360, 0, 80, 80, this);
		
		if(myTank.getHp()==3) {
			g.drawImage(new ImageIcon(Util.MY_HP_3).getImage(), myTank.getTankX(), myTank.getTankY()-20, myTank.getWide(), 20, this);
		}
		
		if(myTank.getHp()==2) {
			g.drawImage(new ImageIcon(Util.MY_HP_2).getImage(), myTank.getTankX(), myTank.getTankY()-20, myTank.getWide(), 20, this);
		}

		if(myTank.getHp()==1) {
			g.drawImage(new ImageIcon(Util.MY_HP_1).getImage(), myTank.getTankX(), myTank.getTankY()-20, myTank.getWide(), 20, this);
		}
		
		for(int i=0;i<foeTankList.size();i++) {
			g.setColor(Color.YELLOW);
			g.drawRect(foeTankList.get(i).getTankX(), foeTankList.get(i).getTankY()-10, 15*foeTankList.get(i).getHp(), 10);
			g.fillRect(foeTankList.get(i).getTankX(),foeTankList.get(i).getTankY()-10,15*foeTankList.get(i).getHp(),10);
			g.setColor(Color.BLACK);
			for(int j=0;j<foeTankList.get(i).getHp();j++) {
				g.drawLine(foeTankList.get(i).getTankX()+15*j, foeTankList.get(i).getTankY(), foeTankList.get(i).getTankX()+15*j, foeTankList.get(i).getTankY()-10);
			}
			
		}
		
		for(int i=0;i<bombList.size();i++) {
			g.drawImage(bombList.get(i).getBombimage(), bombList.get(i).getBombX(), bombList.get(i).getBombY(), bombList.get(i).getWide(), bombList.get(i).getHigh(), this);
		}
		
		if(myTank.getLife()==0) {
			g.drawImage(new ImageIcon(Util.GAME_OVER).getImage(), 0, 0, 800, 800, this);
		}
		
		if("������".equals(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getEatKind())) {
			g.drawString(""+(30-ctrl.getAppScene().getTime2()), 930, 750);
		}
		if("������".equals(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getEatKind())) {
			g.drawString(""+(30-ctrl.getAppScene().getTime2()), 930, 775);
		}

		g.setColor(Color.BLACK);
		g.drawLine(800, 0, 800, 800);
		g.setFont(new Font("����",Font.BOLD,15));
		int yellowNum = ctrl.getAppFoeTank().getYellowTankNum();
		int blueNum = ctrl.getAppFoeTank().getBlueTankNum();
		int redNum = ctrl.getAppFoeTank().getRedTankNum();
		int whiteNum = ctrl.getAppFoeTank().getWhiteTankNum();
		int greenNum = ctrl.getAppFoeTank().getGreenTankNum();
		g.drawString("�з�̹������:"+(20-myTank.getSmash())+"/"+(yellowNum+blueNum+redNum+whiteNum+greenNum), 825, 25);
		g.drawImage(new ImageIcon(Util.FOE_YELLOW_UP).getImage(), 825, 40, 25, 40, this);
		g.drawImage(new ImageIcon(Util.FOE_BLUE_UP).getImage(), 825, 90, 25, 40, this);
		g.drawImage(new ImageIcon(Util.FOE_RED_UP).getImage(), 825, 140, 25, 40, this);
		g.drawImage(new ImageIcon(Util.FOE_WHITE_UP).getImage(), 825, 190, 25, 40, this);
		g.drawImage(new ImageIcon(Util.FOE_GREEN_UP).getImage(), 825, 240, 25, 40, this);
		g.drawString(" X "+yellowNum, 870, 70);
		g.drawString(" X "+blueNum, 870, 120);
		g.drawString(" X "+redNum, 870, 170);
		g.drawString(" X "+whiteNum, 870, 220);
		g.drawString(" X "+greenNum, 870, 270);
		g.drawLine(800, 300, 1200, 300);
		g.setFont(new Font("����",Font.BOLD,25));
		g.drawString("��Ϸ�淨:", 825, 325);
		g.drawString("����: W", 825, 360);
		g.drawString("����: S", 825, 390);
		g.drawString("����: A", 825, 420);
		g.drawString("����: D", 825, 450);
		g.drawString("����: J", 825, 480);
		g.drawString("��ͣ: P", 825, 510);
		g.drawString("����: C", 825, 540);
		g.setFont(new Font("����",Font.BOLD,40));
		g.drawString("�ؿ�:", 830, 590);
		g.drawLine(800, 600, 1200, 600);
		g.setFont(new Font("����",Font.BOLD,15));
		g.drawString("�������:"+myTank.getName(), 825, 625);
		g.drawString("�ùػ���̹��:"+myTank.getSmash(), 825, 650);
		g.drawString("�ùص÷�:"+myTank.getScore(), 825, 675);
		g.drawString("�ܹ�����̹��:"+myTank.getSumSmash(), 825, 700);
		g.drawString("�ܹ��÷�:"+myTank.getSumScore(), 825, 725);
		g.drawString("����ʣ��ʱ��:", 825, 750);
		g.drawString("����ʣ��ʱ��:", 825, 775);
		g.setColor(Color.RED);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString("��:"+myTank.getLife(), 825, 800);
		
		this.repaint();
	}
	
	public void init() {
		
		myTank = new MyTank();
		keyListener = new MyKeyListener(this,ctrl);
		map = Util.MAP_ONE;
		myBList = new ArrayList<MyBullet>();
		foeTankList = new ArrayList<FoeTank>();
		foeBList = new ArrayList<FoeBullet>();
		bombList = new ArrayList<Bomb>();
		myFocusListener = new MyFocusListener(ctrl);
		sceneList = new ArrayList<Scene>();
		
	}

	public MyTank getMyTank() {
		return myTank;
	}

	public void setMyTank(MyTank myTank) {
		this.myTank = myTank;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public ArrayList<MyBullet> getMyBList() {
		return myBList;
	}

	public void setMyBList(ArrayList<MyBullet> myBList) {
		this.myBList = myBList;
	}

	public ArrayList<FoeTank> getFoeTankList() {
		return foeTankList;
	}

	public void setFoeTankList(ArrayList<FoeTank> foeTankList) {
		this.foeTankList = foeTankList;
	}

	public ArrayList<FoeBullet> getFoeBList() {
		return foeBList;
	}

	public void setFoeBList(ArrayList<FoeBullet> foeBList) {
		this.foeBList = foeBList;
	}

	public ArrayList<Bomb> getBombList() {
		return bombList;
	}

	public void setBombList(ArrayList<Bomb> bombList) {
		this.bombList = bombList;
	}

	public ArrayList<Scene> getSceneList() {
		return sceneList;
	}

	public void setSceneList(ArrayList<Scene> sceneList) {
		this.sceneList = sceneList;
	}

	public MyKeyListener getKeyListener() {
		return keyListener;
	}

	public void setKeyListener(MyKeyListener keyListener) {
		this.keyListener = keyListener;
	}


	
	
	

}
