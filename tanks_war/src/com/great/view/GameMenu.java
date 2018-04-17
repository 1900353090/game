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
		
		playGame.setActionCommand("��ʼ��Ϸ");
		playGame.addActionListener(myMenuListener);
		resendGame.setActionCommand("���¿�ʼ");
		resendGame.addActionListener(myMenuListener);
		list.setActionCommand("���а�");
		list.addActionListener(myMenuListener);
		custon.setActionCommand("�Զ���");
		custon.addActionListener(myMenuListener);
		exit.setActionCommand("�˳�");
		exit.addActionListener(myMenuListener);
		gameShow.setActionCommand("��Ϸ˵��");
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
		
		game = new JMenu("��Ϸ");
		help = new JMenu("����");
		playGame = new JMenuItem("��ʼ��Ϸ");
		resendGame = new JMenuItem("���¿�ʼ");
		list = new JMenuItem("���а�");
		custon = new JMenuItem("�Զ���");
		exit = new JMenuItem("�˳�");
		gameShow = new JMenuItem("��Ϸ˵��");
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
