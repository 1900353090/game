package com.great.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.great.ctrl.Ctrl;
import com.great.ctrl.MyMenuListener;

public class GameMenu extends JMenuBar{
	
	private JMenu game,help;
	private JMenuItem playGame,resendGame,list,custon,exit,gameShow;
	private MyMenuListener myMenuListener;
	
	public GameMenu(Ctrl ctrl) {
		init(ctrl);
		
		playGame.setActionCommand("开始游戏");
		playGame.addActionListener(myMenuListener);
		resendGame.setActionCommand("重新开始");
		resendGame.addActionListener(myMenuListener);
		list.setActionCommand("排行榜");
		list.addActionListener(myMenuListener);
		custon.setActionCommand("自定义");
		custon.addActionListener(myMenuListener);
		exit.setActionCommand("退出");
		exit.addActionListener(myMenuListener);
		gameShow.setActionCommand("游戏说明");
		gameShow.addActionListener(myMenuListener);
		game.add(playGame);
		game.add(resendGame);
		game.add(list);
		game.add(custon);
		game.add(exit);
		help.add(gameShow);
		this.add(game);
		this.add(help);
		
	}
	
	public void init(Ctrl ctrl) {
		
		game = new JMenu("游戏");
		help = new JMenu("帮助");
		playGame = new JMenuItem("开始游戏");
		resendGame = new JMenuItem("重新开始");
		list = new JMenuItem("排行榜");
		custon = new JMenuItem("自定义");
		exit = new JMenuItem("退出");
		gameShow = new JMenuItem("游戏说明");
		myMenuListener = new MyMenuListener(ctrl);
		
	}

	public JMenuItem getPlayGame() {
		return playGame;
	}

	public void setPlayGame(JMenuItem playGame) {
		this.playGame = playGame;
	}

	public JMenuItem getResendGame() {
		return resendGame;
	}

	public void setResendGame(JMenuItem resendGame) {
		this.resendGame = resendGame;
	}

	public JMenuItem getList() {
		return list;
	}

	public void setList(JMenuItem list) {
		this.list = list;
	}

	public JMenuItem getCuston() {
		return custon;
	}

	public void setCuston(JMenuItem custon) {
		this.custon = custon;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}

	public JMenuItem getGameShow() {
		return gameShow;
	}

	public void setGameShow(JMenuItem gameShow) {
		this.gameShow = gameShow;
	}

	public JMenu getGame() {
		return game;
	}

	public void setGame(JMenu game) {
		this.game = game;
	}

	public JMenu getHelp() {
		return help;
	}

	public void setHelp(JMenu help) {
		this.help = help;
	}
	
	
	

}
