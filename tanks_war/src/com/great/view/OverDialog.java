package com.great.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.great.ctrl.Ctrl;
import com.great.ctrl.MyMouseListener;

public class OverDialog extends JDialog{
	
	private JButton jbtAnew,jbtShut;
	private MyMouseListener MyMouseListener;
	
	public OverDialog(Ctrl ctrl) {
		init(ctrl);
		this.setLayout(null);

		jbtAnew.setBounds(165, 100, 70, 30);
		jbtAnew.addMouseListener(MyMouseListener);
		
		jbtShut.setBounds(245, 100, 70, 30);
		jbtShut.addMouseListener(MyMouseListener);
		
		this.add(jbtAnew);
		this.add(jbtShut);
		this.setTitle("Game Over");
		this.setUndecorated(true);	// 去掉窗口的装饰 
		this.setPreferredSize(new Dimension(400,200));
		this.setResizable(false);
		this.setModal(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void init(Ctrl ctrl) {
		
		jbtAnew = new JButton("重新");
		jbtShut = new JButton("关闭");
		MyMouseListener  = new MyMouseListener(ctrl);
		
	}

	public JButton getJbtAnew() {
		return jbtAnew;
	}

	public void setJbtAnew(JButton jbtAnew) {
		this.jbtAnew = jbtAnew;
	}

	public JButton getJbtShut() {
		return jbtShut;
	}

	public void setJbtShut(JButton jbtShut) {
		this.jbtShut = jbtShut;
	}


}
