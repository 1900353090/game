package com.great.view;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import com.great.ctrl.Ctrl;
import com.great.ctrl.MyMenuListener;
import com.great.ctrl.MyMouseListener;
import com.great.ctrl.MyWinListener;
import com.great.util.Util;

public class CustomDialog extends JDialog{
	
	private JComboBox jcbLevel;
	private JComboBox jcbTankSpeed;
	private JComboBox jcbBulletSpeed;
	private JTextField jtfTankNum;
	private JLabel jlLevel,jlTankSpeed,jlBulletSpeed,jlTankNum;
	private JRadioButton jrb1,jrb2;
	private ButtonGroup bg;
	private JButton jbtNotarize,jbtClose;
	private MyMenuListener myMenuListener;
	private MyMouseListener myMouseListener;
	private int[][] level;
	private int tankSpeed;
	private int bulletSpeed;
	private boolean mapChange;
	private boolean Custom;
	private Ctrl ctrl;
	
	public CustomDialog(Ctrl ctrl) {
		this.ctrl = ctrl;
		init();
		this.setLayout(null);
		jrb1.setBounds(20, 180, 80, 30);
		jrb2.setBounds(110, 180, 80, 30);
		bg.add(jrb1);
		bg.add(jrb2);
		jlLevel.setBounds(20, 20, 160, 80);
		jlTankSpeed.setBounds(20, 50, 160, 80);
		jlBulletSpeed.setBounds(20, 80, 160, 80);
		jlTankNum.setBounds(20, 110, 110, 80);
		
		jcbLevel.setBounds(100, 50, 40, 20);
		jcbTankSpeed.setBounds(90, 80, 40, 20);
		jcbBulletSpeed.setBounds(90, 110, 40, 20);
		jtfTankNum.setBounds(125, 140, 40, 20);
		
		jbtNotarize.setBounds(15, 220, 80, 40);
		jbtClose.setBounds(100, 220, 80, 40);
		
		jcbLevel.addActionListener(myMenuListener);
		jcbTankSpeed.addActionListener(myMenuListener);
		jcbBulletSpeed.addActionListener(myMenuListener);
		
		jbtNotarize.addMouseListener(myMouseListener);
		jbtClose.addMouseListener(myMouseListener);
		
		this.add(jbtNotarize);
		this.add(jrb1);
		this.add(jrb2);
		this.add(jlLevel);
		this.add(jlTankNum);
		this.add(jlTankSpeed);
		this.add(jlBulletSpeed);
		this.add(jtfTankNum);
		this.add(jcbBulletSpeed);
		this.add(jcbLevel);
		this.add(jcbTankSpeed);
		this.add(jbtClose);

		this.setTitle("游戏设置");
		this.setUndecorated(true);	// 去掉窗口的装饰 
		this.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);	//采用指定的窗口装饰风格
		this.setPreferredSize(new Dimension(215,300));
		this.setResizable(false);
		this.setModal(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void init() {
		String [] str1 = {"1","2","3","4","5","6","7","8"};
		jcbLevel = new JComboBox(str1);
		String [] str2 = {"6","7","8","9","10","11","12","13","14","15"};
		jcbTankSpeed = new JComboBox(str2);
		String [] str3 = {"10","11","12","13","14","15","16","17","18","19"};
		jcbBulletSpeed = new JComboBox(str3);
		jtfTankNum = new JTextField(20);
		jlLevel = new JLabel("请选择关卡:");
		jlTankSpeed = new JLabel("坦克速度:");
		jlBulletSpeed = new JLabel("子弹速度:");
		jlTankNum = new JLabel("坦克数量(10-50):");
		jrb1 = new JRadioButton("单人游戏");
		jrb2 = new JRadioButton ("双人游戏");
		bg =new ButtonGroup();
		jbtNotarize = new JButton("确认");
		jbtClose = new JButton("关闭");
		myMenuListener = new MyMenuListener(ctrl);
		myMouseListener = new MyMouseListener(ctrl);
		level = ctrl.getTanksWarFrame().getGamePanel().getMap();
		tankSpeed = Util.My_TANK_SPEED;
		bulletSpeed = Util.MY_BULLET_SPEED;
		mapChange = false;
		Custom = false;
	}

	public JComboBox getJcbLevel() {
		return jcbLevel;
	}

	public void setJcbLevel(JComboBox jcbLevel) {
		this.jcbLevel = jcbLevel;
	}

	public JComboBox getJcbTankSpeed() {
		return jcbTankSpeed;
	}

	public void setJcbTankSpeed(JComboBox jcbTankSpeed) {
		this.jcbTankSpeed = jcbTankSpeed;
	}

	public JComboBox getJcbBulletSpeed() {
		return jcbBulletSpeed;
	}

	public void setJcbBulletSpeed(JComboBox jcbBulletSpeed) {
		this.jcbBulletSpeed = jcbBulletSpeed;
	}

	public JTextField getJtfTankNum() {
		return jtfTankNum;
	}

	public void setJtfTankNum(JTextField jtfTankNum) {
		this.jtfTankNum = jtfTankNum;
	}

	public JRadioButton getJrb1() {
		return jrb1;
	}

	public void setJrb1(JRadioButton jrb1) {
		this.jrb1 = jrb1;
	}

	public JRadioButton getJrb2() {
		return jrb2;
	}

	public void setJrb2(JRadioButton jrb2) {
		this.jrb2 = jrb2;
	}

	public JButton getJbtNotarize() {
		return jbtNotarize;
	}

	public void setJbtNotarize(JButton jbtNotarize) {
		this.jbtNotarize = jbtNotarize;
	}

	public JButton getJbtClose() {
		return jbtClose;
	}

	public void setJbtClose(JButton jbtClose) {
		this.jbtClose = jbtClose;
	}

	public int[][] getLevel() {
		return level;
	}

	public void setLevel(int[][] level) {
		this.level = level;
	}

	public int getTankSpeed() {
		return tankSpeed;
	}

	public void setTankSpeed(int tankSpeed) {
		this.tankSpeed = tankSpeed;
	}

	public int getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(int bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}

	public boolean isMapChange() {
		return mapChange;
	}

	public void setMapChange(boolean mapChange) {
		this.mapChange = mapChange;
	}

	public boolean isCustom() {
		return Custom;
	}

	public void setCustom(boolean custom) {
		Custom = custom;
	}
	
	
	

}
