package com.great.ctrl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MyWinListener extends WindowAdapter{
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		
		int msg=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ�عرմ���");	//ѯ�ʵĶԻ���
		//�ж��Ƿ�رմ��ڵ������ʱִ�д�����
		System.out.println(msg);
		if(msg==0){

			System.exit(0);
			
		}
		
		
	}

}
