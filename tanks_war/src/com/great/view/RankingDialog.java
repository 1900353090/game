package com.great.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import com.great.util.Util;

public class RankingDialog extends JDialog{

	private ArrayList<String> playerList;
	private String [] player;
	private JTextArea list;	//设置一个文本框
	
	public RankingDialog() {
		init();
		this.setLayout(null);
		Util.getRead(playerList);
		
		Font listFont = new Font("Serif",0,40);
		//将字体样式和大小的设置添加到gameShow文本框上
		list.setFont(listFont);
		int x=0;
		System.out.println(playerList.size());
		for(int i=0;i<playerList.size();i++) {
			
			for(int j=x;j<playerList.size();j++) {
				
				int  num1  = Integer.valueOf(playerList.get(i).substring(playerList.get(i).indexOf("分数")+2));
				int  num2  = Integer.valueOf(playerList.get(j).substring(playerList.get(j).indexOf("分数")+2));
				if(num1<num2) {
					
					String player1 = playerList.get(i);
					String player2 = playerList.get(j);
					playerList.set(i, player2);
					playerList.set(j, player1);

				}
			}
			x++;
		}
		
		for(int i=0;i<playerList.size();i++) {
			player[i] = playerList.get(i);
		}

		list.setText(
				  player[0]+"\n"
				+ player[1]+"\n"
				+ player[2]+"\n"
				+ player[3]+"\n"
				+ player[4]+"\n"
				+ player[5]+"\n"
				+ player[6]+"\n"
				+ player[7]+"\n"
				+ player[8]+"\n"
				+ player[9]+"\n"
			);
		list.setBounds(0, 0, 600, 600);
		list.setEditable(false);
		list.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		
		this.add(list);
		
		this.setTitle("封神榜");
		this.setUndecorated(true);	// 去掉窗口的装饰 
		this.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);	//采用指定的窗口装饰风格
		this.setPreferredSize(new Dimension(600,600));
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		//this.setVisible(false);
		this.setLocationRelativeTo(null);
		
	}
	
	public void init() {
		playerList = new ArrayList<String>();
		list = new JTextArea();
		player = new String[10];
	}
	
}
