package com.great.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

public class GameShowDialog extends JDialog{
	
	private JTextArea gameShow,writer;	//设置一个文本框jtextarea
	
	public GameShowDialog() {
		init();
		this.setLayout(null);
		
		//设置字体的样式和大小
		Font gameShowFont = new Font("Serif",0,15);
		//将字体样式和大小的设置添加到gameShow文本框上
		gameShow.setFont(gameShowFont);
		gameShow.setText(
							  "游戏一共8关,每关不同坦克类型的数量不同。\n"
							+ "\n"
							+ "敌方坦克种类:"
							+ "白(血量1,速度1,分值100)\n"
							+ "黄(血量2,速度1,分值200)\n"
							+ "绿(血量1,速度2,分值200)\n"
							+ "蓝(血量2,速度2,分值300)\n"
							+ "红(血量2,速度3,分值500)\n"
							+ "\n"
							+ "地图内会随机出现不同种类的道具:\n"
							+ "血包:HP+1\n"
							+ "子弹加强:可以打穿铁墙(时效30秒)\n"
							+ "防御加强:基地外围生成一层铁墙(时效30秒)\n"
							+ "\n"
							+ "玩家一共有三条命,每条命一共有三滴血\n"
							+ "基地被攻击,或玩家三条命用完则游戏结束"
						);
		gameShow.setBounds(0, 0, 600-6, 800-400);
		//设置文本框不可更改
		gameShow.setEditable(false);
		//添加一个边框到文本框上
		gameShow.setBorder(BorderFactory.createLineBorder(Color.gray,3));
		
		//设置字体的样式和大小
		Font writerFont = new Font("Serif",0,80);
		writer.setFont(writerFont);
		writer.setText(
						  "作者:\n"
						+ "JF1803A班12号\n"
						+ "王晨阳\n"
					);
		writer.setBounds(0, 400, 600-6, 400-35);
		writer.setEditable(false);
		writer.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		
		this.add(gameShow);
		this.add(writer);
		
		this.setTitle("游戏说明");
		this.setUndecorated(true);	// 去掉窗口的装饰 
		this.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);	//采用指定的窗口装饰风格
		this.setPreferredSize(new Dimension(600,800));
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.setVisible(false);
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
	public void init() {
		
		gameShow = new JTextArea();
		writer = new JTextArea();
		
	}

}
