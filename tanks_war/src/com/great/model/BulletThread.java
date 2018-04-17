package com.great.model;

import java.util.Random;

import com.great.ctrl.Ctrl;

public class BulletThread extends Thread{
	
	private Ctrl ctrl;
	private boolean onOFF;
	private boolean flag;
	private Random ran;

	
	public BulletThread(Ctrl ctrl) {
		
		this.ctrl = ctrl;
		onOFF = true;
		flag = true;
		ran = new Random();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			if(onOFF) {
				if(flag) {
					
					for(int i=0;i<ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().size();i++) {
						int shoot = ran.nextInt(100);
						if(shoot==1) {
							FoeBullet foeB = new FoeBullet(ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).getTankX(),ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).getTankY(),ctrl.getTanksWarFrame().getGamePanel().getFoeTankList().get(i).getDir());
							ctrl.getTanksWarFrame().getGamePanel().getFoeBList().add(foeB);
						}
					}
					
					for(int j=0;j<ctrl.getTanksWarFrame().getGamePanel().getFoeBList().size();j++) {
						
						ctrl.getTanksWarFrame().getGamePanel().getFoeBList().get(j).getMove(ctrl.getTanksWarFrame().getGamePanel().getFoeBList(),ctrl.getTanksWarFrame().getGamePanel().getMap(),ctrl.getTanksWarFrame().getGamePanel().getMyTank(),ctrl.getTanksWarFrame().getGamePanel().getMyBList(),ctrl);
						
					}
					
					for(int i=0;i<ctrl.getTanksWarFrame().getGamePanel().getMyBList().size();i++) {
						
						ctrl.getTanksWarFrame().getGamePanel().getMyBList().get(i).getMove(ctrl.getTanksWarFrame().getGamePanel().getMyBList(),ctrl.getTanksWarFrame().getGamePanel().getMap(),ctrl.getTanksWarFrame().getGamePanel().getFoeTankList(),ctrl.getTanksWarFrame().getGamePanel().getFoeBList(),ctrl);
						
					}
					
				}
			}
			try {
				sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!onOFF) {
				return;
			}
						
		}
		
	}

	public boolean isOnOFF() {
		return onOFF;
	}

	public void setOnOFF(boolean onOFF) {
		this.onOFF = onOFF;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
	
}
