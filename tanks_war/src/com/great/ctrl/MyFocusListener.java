package com.great.ctrl;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MyFocusListener extends FocusAdapter{
	
	private Ctrl ctrl;
	
	public MyFocusListener(Ctrl ctrl) {
		this.ctrl = ctrl;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		super.focusGained(e);
		
		ctrl.getMoveFoeTank().setFlag(true);
		ctrl.getBullet().setFlag(true);
		ctrl.getAppScene().setFlag(true);
		
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		super.focusLost(e);
		
		ctrl.getMoveFoeTank().setFlag(false);
		ctrl.getBullet().setFlag(false);
		ctrl.getAppScene().setFlag(false);
		
	}
	
}
