package com.great.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.great.ctrl.Ctrl;
import com.great.ctrl.MyMouseListener;

public class NameDialog extends JDialog{
	
	private JButton jbtConfirm;
	private JTextField nameField;
	private JLabel promptLabel;
	private MyMouseListener MyMouseListener;
	
	public NameDialog(Ctrl ctrl) {
		init(ctrl);
		this.setLayout(null);
		
		promptLabel.setBounds(100, 20, 100, 20);
		nameField.setBounds(100, 50, 200, 20);
		jbtConfirm.setBounds(165, 100, 70, 30);
		jbtConfirm.addMouseListener(MyMouseListener);
		
		this.add(jbtConfirm);
		this.add(nameField);
		this.add(promptLabel);
		this.setTitle("欢迎来到坦克大战!");
		//this.setUndecorated(true); // 去掉窗口的装饰 
		this.setPreferredSize(new Dimension(400,200));
		this.setResizable(false);
		this.setModal(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	
	public void init(Ctrl ctrl) {
		
		jbtConfirm = new JButton("确认");
		nameField = new JTextField();
		promptLabel = new JLabel("请输入姓名:");
		MyMouseListener  = new MyMouseListener(ctrl);
		
	}

	public JButton getJbtConfirm() {
		return jbtConfirm;
	}

	public void setJbtConfirm(JButton jbtConfirm) {
		this.jbtConfirm = jbtConfirm;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}
	
	

}
