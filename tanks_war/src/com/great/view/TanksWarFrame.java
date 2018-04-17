package com.great.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import com.great.ctrl.Ctrl;
import com.great.ctrl.MyWinListener;


public class TanksWarFrame extends JFrame{
	
	private CardLayout cardLayout;
	private JPanel panel;
	private GamePanel gamePanel;
	private WelcomePanel welcomePanel;
	private GameMenu gameMenu;
	private MyWinListener myWinListener;
	
	public TanksWarFrame(Ctrl ctrl) {
		
		init(ctrl);
		panel.setLayout(cardLayout);
		
		panel.add("welcomePanel", welcomePanel);
		cardLayout.show(panel, "welcomePanel");
		
		this.addWindowListener(myWinListener);
		this.add(panel,BorderLayout.CENTER);
		this.setTitle("坦克大战");
		this.setUndecorated(true);	// 去掉窗口的装饰 
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);	//采用指定的窗口装饰风格 
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
	public void init(Ctrl ctrl) {
		
		gameMenu = new GameMenu(ctrl);
		cardLayout = new CardLayout();
		panel = new JPanel();
		gamePanel = new GamePanel(ctrl);
		welcomePanel = new WelcomePanel(ctrl);
		myWinListener = new MyWinListener();
		
	}
	
	public void getShowGamePanel() {
		
		this.add(gameMenu,BorderLayout.NORTH);
		panel.add("gamePanel", gamePanel);
		cardLayout.show(panel, "gamePanel");
		gameMenu.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		
	}

	
	/**
	 * ----------------------get&set----------------------
	 * @return
	 */
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	public void setWelcomePanel(WelcomePanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public GameMenu getGameMenu() {
		return gameMenu;
	}

	public void setGameMenu(GameMenu gameMenu) {
		this.gameMenu = gameMenu;
	}
	
	
	

}
