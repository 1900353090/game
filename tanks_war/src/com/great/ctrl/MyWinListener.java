package com.great.ctrl;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class MyWinListener extends WindowAdapter{
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		
		int msg=JOptionPane.showConfirmDialog(null, "是否确地关闭窗口");	//询问的对话框
		//判断是否关闭窗口当点击是时执行代码体
		System.out.println(msg);
		if(msg==0){

			System.exit(0);
			
		}
		
		
	}

}
