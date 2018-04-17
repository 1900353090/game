package com.great.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.great.ctrl.Ctrl;
import com.great.ctrl.MyMouseListener;
import com.great.util.Util;


public class WelcomePanel extends JPanel{
	
	private JButton jbtBegin,jbtQuit;
	private MyMouseListener mouseListener;
	
	public WelcomePanel(Ctrl ctrl) {
		init(ctrl);
		this.setLayout(null);
		
		
		jbtBegin.setBounds(Util.WELCOME_WIDE/8*3-(Util.WELCOME_WIDE/8)/2, Util.WELCOME_HIGH-(Util.WELCOME_HIGH/5)*2, Util.JBTBEGIN_WIDE, Util.JBTBEGIN_HIGH);
		jbtQuit.setBounds(Util.WELCOME_WIDE/8*3-(Util.WELCOME_WIDE/8)/2, Util.WELCOME_HIGH-(Util.WELCOME_HIGH/5)*2+50+5, Util.JBTQUIT_WIDE, Util.JBTQUIT_HIGH);
		this.add(jbtBegin);
		jbtBegin.addMouseListener(mouseListener);
		this.add(jbtQuit);
		jbtQuit.addMouseListener(mouseListener);
		this.setPreferredSize(new Dimension(Util.WELCOME_WIDE,Util.WELCOME_HIGH));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon(Util.WELCOME_IMG).getImage(), 0, 0, Util.WELCOME_WIDE, Util.WELCOME_HIGH, this);
		
	}
	
	public void init(Ctrl ctrl) {
		
		mouseListener = new MyMouseListener(ctrl);
		jbtBegin = new JButton("进入游戏");
		jbtQuit = new JButton("退出游戏");
		
	}


	
	/**
	 * -------------get&set-------------------------
	 */

	public JButton getJbtBegin() {
		return jbtBegin;
	}

	public void setJbtBegin(JButton jbtBegin) {
		this.jbtBegin = jbtBegin;
	}

	public JButton getJbtQuit() {
		return jbtQuit;
	}

	public void setJbtQuit(JButton jbtQuit) {
		this.jbtQuit = jbtQuit;
	}

	public MyMouseListener getMouseListener() {
		return mouseListener;
	}

	public void setMouseListener(MyMouseListener mouseListener) {
		this.mouseListener = mouseListener;
	}
	
	
	
}
