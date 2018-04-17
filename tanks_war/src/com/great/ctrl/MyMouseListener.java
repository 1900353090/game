package com.great.ctrl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.great.util.Util;

public class MyMouseListener extends MouseAdapter{
	
	private Ctrl ctrl;
	
	public MyMouseListener(Ctrl ctrl) {
		
		this.ctrl = ctrl;
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
		
		if(ctrl.getTanksWarFrame().getWelcomePanel().getJbtBegin().equals(e.getSource())) {
			
			ctrl.getNameDialog().setVisible(true);
			
			
		}else if(ctrl.getTanksWarFrame().getWelcomePanel().getJbtQuit().equals(e.getSource())) {
			
			System.exit(0); 
			
		}
		
		if(ctrl.getNameDialog().getJbtConfirm().equals(e.getSource())) {
			String name = ctrl.getNameDialog().getNameField().getText();
			ctrl.getTanksWarFrame().getGamePanel().getMyTank().setName(name);
			if(!name.equals("")) {

					ctrl.getNameDialog().setVisible(false);
					ctrl.getTanksWarFrame().getShowGamePanel();
					ctrl.getThreadStart();
				
			}
			
		}
		
		if(ctrl.getOverDialog().getJbtAnew().equals(e.getSource())) {
			ctrl.getAppStop();
			new Ctrl();
		}
		if(ctrl.getOverDialog().getJbtShut().equals(e.getSource())) {
			System.exit(0);
		}
		
		if(ctrl.getCustomDialog().getJbtNotarize().equals(e.getSource())) {
			ctrl.getTanksWarFrame().getGamePanel().getMyTank().setSpeed(ctrl.getCustomDialog().getTankSpeed());
			Util.MY_BULLET_SPEED = ctrl.getCustomDialog().getBulletSpeed();

			if(ctrl.getCustomDialog().isMapChange()) {
				
				ctrl.getTanksWarFrame().getGamePanel().setMap(ctrl.getCustomDialog().getLevel());
				for(int i=0;i<ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().size();i++) {
					ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().remove(i);
					i--;
				}
				ctrl.getAppFoeTank().setYellow(0);
				ctrl.getAppFoeTank().setWhite(0);
				ctrl.getAppFoeTank().setBlue(0);
				ctrl.getAppFoeTank().setGreen(0);
				ctrl.getAppFoeTank().setRed(0);
				ctrl.getCustomDialog().setMapChange(false);
				
			}
			ctrl.getCustomDialog().setVisible(false);
		}
		
		if(ctrl.getCustomDialog().getJbtClose().equals(e.getSource())) {
			ctrl.getCustomDialog().setVisible(false);
		}
		
		
	}

	

}
