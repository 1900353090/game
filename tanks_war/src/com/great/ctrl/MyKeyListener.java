package com.great.ctrl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import com.great.model.MyBullet;
import com.great.util.Util;
import com.great.view.GamePanel;

public class MyKeyListener extends KeyAdapter{
	
	private GamePanel gamePanel;
	private Ctrl ctrl;
	private boolean forgeIron;
	
//	//将获取的用户按键转化为布尔值默认为false
//    private boolean a = false;  
//    private boolean d = false;  
//    private boolean w = false;  
//    private boolean s = false;
//    private boolean j = false;
	
	public MyKeyListener(GamePanel gamePanel,Ctrl ctrl) {
		
		this.gamePanel = gamePanel;
		this.ctrl = ctrl;
		forgeIron = false;
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.getMyTank().setDir(1);
			gamePanel.getMyTank().setImage(new ImageIcon(Util.PLAYER1_TANK_UP).getImage());
			gamePanel.getMyTank().getMove(gamePanel.getMap(),gamePanel.getFoeTankList(),gamePanel.getSceneList(),ctrl.getAppScene(),this);
			break;
		case KeyEvent.VK_S:
			gamePanel.getMyTank().setDir(2);
			gamePanel.getMyTank().setImage(new ImageIcon(Util.PLAYER1_TANK_DOWN).getImage());
			gamePanel.getMyTank().getMove(gamePanel.getMap(),gamePanel.getFoeTankList(),gamePanel.getSceneList(),ctrl.getAppScene(),this);
			break;
		case KeyEvent.VK_A:
			gamePanel.getMyTank().setDir(3);
			gamePanel.getMyTank().setImage(new ImageIcon(Util.PLAYER1_TANK_LEFT).getImage());
			gamePanel.getMyTank().getMove(gamePanel.getMap(),gamePanel.getFoeTankList(),gamePanel.getSceneList(),ctrl.getAppScene(),this);
			break;
		case KeyEvent.VK_D:
			gamePanel.getMyTank().setDir(4);
			gamePanel.getMyTank().setImage(new ImageIcon(Util.PLAYER1_TANK_RIGTH).getImage());
			gamePanel.getMyTank().getMove(gamePanel.getMap(),gamePanel.getFoeTankList(),gamePanel.getSceneList(),ctrl.getAppScene(),this);
			break;
		case KeyEvent.VK_J:
			MyBullet myBullet = new MyBullet(gamePanel.getMyTank().getTankX(),gamePanel.getMyTank().getTankY(),gamePanel.getMyTank().getDir(),forgeIron);
			gamePanel.getMyBList().add(myBullet);
			break;
		}
		
	}

	public boolean isForgeIron() {
		return forgeIron;
	}

	public void setForgeIron(boolean forgeIron) {
		this.forgeIron = forgeIron;
	}


	
	
	
	
	
	
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		super.keyPressed(e);
//		
//		//判断用户按了哪个按键按了的为true
//		switch (e.getKeyCode()) {
//		case KeyEvent.VK_W: w = true;break;
//		
//		case KeyEvent.VK_S: s = true;break;
//
//		case KeyEvent.VK_A: a = true;break;
//
//		case KeyEvent.VK_D: d = true;break;
//		
//		case KeyEvent.VK_J:
//			MyBullet myBullet = new MyBullet(gamePanel.getMyTank().getTankX(),gamePanel.getMyTank().getTankY(),gamePanel.getMyTank().getDir());
//			gamePanel.getMyBList().add(myBullet);
//			break;
//		}
//		
//		//通过判断用户按了哪些按键然后进去相应的代码来移动玩家的飞机
//		if(w==true&&s==false&&a==false&&d==false) {
//			gamePanel.getMyTank().setDir(1);
//			gamePanel.getMyTank().setImage(new ImageIcon(Util.MY_IMG_UP).getImage());
//			gamePanel.getMyTank().getMove(gamePanel.getMap(),gamePanel.getFoeTankList());
//		}
//		
//		if(s==true&&w==false&&a==false&&d==false) {
//			gamePanel.getMyTank().setDir(2);
//			gamePanel.getMyTank().setImage(new ImageIcon(Util.MY_IMG_DOWN).getImage());
//			gamePanel.getMyTank().getMove(gamePanel.getMap(),gamePanel.getFoeTankList());
//		}
//
//		if(a==true&&w==false&&s==false&&d==false) {
//			gamePanel.getMyTank().setDir(3);
//			gamePanel.getMyTank().setImage(new ImageIcon(Util.MY_IMG_LEFT).getImage());
//			gamePanel.getMyTank().getMove(gamePanel.getMap(),gamePanel.getFoeTankList());
//		}
//		
//		if(d==true&&w==false&&s==false&&a==false) {
//			gamePanel.getMyTank().setDir(4);
//			gamePanel.getMyTank().setImage(new ImageIcon(Util.MY_IMG_RIGTH).getImage());
//			gamePanel.getMyTank().getMove(gamePanel.getMap(),gamePanel.getFoeTankList());
//		}
//		
//		if(j==true) {
//			MyBullet myBullet = new MyBullet(gamePanel.getMyTank().getTankX(),gamePanel.getMyTank().getTankY(),gamePanel.getMyTank().getDir());
//			gamePanel.getMyBList().add(myBullet);
//		}
//
//		
//	}
//	
//	/**
//	 * 松开按键时初始化按键为false
//	 */
//    public void keyReleased(KeyEvent e) {  
//         
//         switch(e.getKeyCode()) {  
//             case  KeyEvent.VK_A :  a=false;  break;  
//             case  KeyEvent.VK_W :   w= false;break;  
//             case  KeyEvent.VK_S :s = false; break;  
//             case  KeyEvent.VK_D : d = false;break;
//             case  KeyEvent.VK_J: j = false;break;
//         }  
//      } 

}
