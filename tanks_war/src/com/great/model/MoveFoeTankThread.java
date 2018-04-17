package com.great.model;

import java.util.Random;

import com.great.ctrl.Ctrl;

public class MoveFoeTankThread extends Thread{
	
	private Ctrl ctrl;
	private Random ran;
	private boolean open;
	private boolean flag;
	private boolean onOFF;
	
	public MoveFoeTankThread(Ctrl ctrl) {
		
		this.ctrl = ctrl;
		ran = new Random();
		open = true;
		flag = true;
		onOFF = true;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			if(onOFF) {
				if(flag) {
					
					for(int i=0;i<ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().size();i++) {
						
						ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).setDir(ran.nextInt(4)+1);
						
					}
					
					for(int j=0;j<100;j++) {
						if(flag) {
							for(int i=0;i<ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().size();i++) {
								ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).getMove(ctrl.getTanksWarFrame().getGamePanel().getMap(),ctrl.getTanksWarFrame().getGamePanel().getMyTank(),ctrl.getTanksWarFrame().getGamePanel().getFoeTankList());
							}
							try {
								sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					if(open) {
						
					//	ctrl.getAppFoeBullet().start();
						open=false;
						
					}
					
				}
				
			}
			
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!onOFF) {
				return;
			}
			
		}
		
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isOnOFF() {
		return onOFF;
	}

	public void setOnOFF(boolean onOFF) {
		this.onOFF = onOFF;
	}
	
	
	
}
