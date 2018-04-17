package com.great.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.great.util.Util;

public class MyMenuListener implements ActionListener{
	
	private Ctrl ctrl;

	
	public MyMenuListener(Ctrl ctrl) {
		this.ctrl = ctrl;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch (e.getActionCommand()) {
		case "开始游戏":
			
			System.out.println("开始游戏");
			
			break;
		case "重新开始":
			
			ctrl.getAppStop();
			new Ctrl();
			
			break;
		case "排行榜":
			
			ctrl.getRankingDialog().setVisible(true);
			
			break;
		case "自定义":
			
			ctrl.getCustomDialog().setVisible(true);
			
			break;
		case "退出":

			System.exit(0);
			
			break;
		case "游戏说明":
			
			ctrl.getGameShowDialog().setVisible(true);
			
			break;
			
		}
		
		if(e.getSource()==ctrl.getCustomDialog().getJcbLevel()) {
			
			int index = ctrl.getCustomDialog().getJcbLevel().getSelectedIndex();
			
			switch (index) {
			case 0:
				ctrl.getCustomDialog().setLevel(Util.MAP_ONE);
				break;
			case 1:
				ctrl.getCustomDialog().setLevel(Util.MAP_TWO);
				break;
			case 2:
				ctrl.getCustomDialog().setLevel(Util.MAP_THREE);
				break;
			case 3:
				ctrl.getCustomDialog().setLevel(Util.MAP_FOUR);
				break;
			case 4:
				ctrl.getCustomDialog().setLevel(Util.MAP_FIVE);
				break;
			case 5:
				ctrl.getCustomDialog().setLevel(Util.MAP_SIX);
				break;
			case 6:
				ctrl.getCustomDialog().setLevel(Util.MAP_SEVEN);
				break;
			case 7:
				ctrl.getCustomDialog().setLevel(Util.MAP_EIGHT);
				break;
			}
			
			ctrl.getCustomDialog().setMapChange(true);
			ctrl.getCustomDialog().setc
			
		}
		if(e.getSource()==ctrl.getCustomDialog().getJcbTankSpeed()) {
			
			int index = ctrl.getCustomDialog().getJcbTankSpeed().getSelectedIndex();
			
			switch (index) {
			case 0:
				ctrl.getCustomDialog().setTankSpeed(6);
				break;
			case 1:
				ctrl.getCustomDialog().setTankSpeed(7);
				break;
			case 2:
				ctrl.getCustomDialog().setTankSpeed(8);
				break;
			case 3:
				ctrl.getCustomDialog().setTankSpeed(9);
				break;
			case 4:
				ctrl.getCustomDialog().setTankSpeed(10);
				break;
			case 5:
				ctrl.getCustomDialog().setTankSpeed(11);
				break;
			case 6:
				ctrl.getCustomDialog().setTankSpeed(12);
				break;
			case 7:
				ctrl.getCustomDialog().setTankSpeed(13);
				break;
			case 8:
				ctrl.getCustomDialog().setTankSpeed(14);
				break;
			case 9:
				ctrl.getCustomDialog().setTankSpeed(15);
				break;
			}
			
		}
		if(e.getSource()==ctrl.getCustomDialog().getJcbBulletSpeed()) {
			
			int index = ctrl.getCustomDialog().getJcbBulletSpeed().getSelectedIndex();
			
			switch (index) {
			case 0:
				ctrl.getCustomDialog().setBulletSpeed(10);
				break;
			case 1:
				ctrl.getCustomDialog().setBulletSpeed(11);
				break;
			case 2:
				ctrl.getCustomDialog().setBulletSpeed(12);
				break;
			case 3:
				ctrl.getCustomDialog().setBulletSpeed(13);
				break;
			case 4:
				ctrl.getCustomDialog().setBulletSpeed(14);
				break;
			case 5:
				ctrl.getCustomDialog().setBulletSpeed(15);
				break;
			case 6:
				ctrl.getCustomDialog().setBulletSpeed(16);
				break;
			case 7:
				ctrl.getCustomDialog().setBulletSpeed(17);
				break;
			case 8:
				ctrl.getCustomDialog().setBulletSpeed(18);
				break;
			case 9:
				ctrl.getCustomDialog().setBulletSpeed(19);
				break;
			}
			
		}
			
	}

}
