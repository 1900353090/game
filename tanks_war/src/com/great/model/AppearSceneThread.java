package com.great.model;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import com.great.ctrl.Ctrl;
import com.great.util.Util;

public class AppearSceneThread extends Thread {

	private Ctrl ctrl;
	private Random ran;
	private boolean onOFF;
	private boolean flag;
	private int time1;
	private int time2;

	public AppearSceneThread(Ctrl ctrl) {

		this.ctrl = ctrl;
		ran = new Random();
		onOFF = true;
		flag = true;
		time1 = 0;
		time2 = 0;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		while (true) {
			if (onOFF) {
				if (flag) {
					if (time1 == 0) {

						getCoincide();

					}
				}

				if (time1 == 30) {
					for (int i = 0; i < ctrl.getTanksWarFrame().getGamePanel().getSceneList().size(); i++) {

						if (ctrl.getTanksWarFrame().getGamePanel().getSceneList().get(i).isFlag()) {
							ctrl.getTanksWarFrame().getGamePanel().getSceneList().remove(i);
						}

					}
					time1 = -1;
				}

				if (time2 == 30) {
					if("打铁包".equals(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getEatKind())) {
						ctrl.getTanksWarFrame().getGamePanel().getKeyListener().setForgeIron(false);
					}
					if("防御包".equals(ctrl.getTanksWarFrame().getGamePanel().getMyTank().getEatKind())) {
						for (int j = 34; j < ctrl.getTanksWarFrame().getGamePanel().getMap().length; j++) {
							ctrl.getTanksWarFrame().getGamePanel().getMap()[j][16] = 1;
							ctrl.getTanksWarFrame().getGamePanel().getMap()[j][17] = 1;
							ctrl.getTanksWarFrame().getGamePanel().getMap()[j][22] = 1;
							ctrl.getTanksWarFrame().getGamePanel().getMap()[j][23] = 1;
						}
						for (int j = 34; j <= 35; j++) {
							ctrl.getTanksWarFrame().getGamePanel().getMap()[j][18] = 1;
							ctrl.getTanksWarFrame().getGamePanel().getMap()[j][19] = 1;
							ctrl.getTanksWarFrame().getGamePanel().getMap()[j][20] = 1;
							ctrl.getTanksWarFrame().getGamePanel().getMap()[j][21] = 1;
						}
					}
//					switch (ctrl.getTanksWarFrame().getGamePanel().getMyTank().getEatKind()) {
//					case 1:
//
//						break;
//					case 2:
//
//						break;
//
//					case 3:
//
//						break;
//					}
					ctrl.getTanksWarFrame().getGamePanel().getMyTank().setEatKind("");
					time2 = 0;
					ctrl.getTanksWarFrame().getGamePanel().getMyTank().setEat(false);
				}
				
				//遍历爆炸集合
				for(int i=0;i<ctrl.getTanksWarFrame().getGamePanel().getBombList().size();i++) {
					//删除爆炸集合内的一个元素
					ctrl.getTanksWarFrame().getGamePanel().getBombList().remove(i);
					i--;
				}

				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				time1 += 1;
				if (ctrl.getTanksWarFrame().getGamePanel().getMyTank().isEat()) {
					time2 += 1;
				}

			}
			if (!onOFF) {
				return;
			}
		}

	}

	public void getCoincide() {

		while (true) {

			int SceneX = ran.nextInt(39);
			int SceneY = ran.nextInt(39);
			int type = ran.nextInt(3) + 1;
			switch (type) {
			case 1:
				Scene Scene1 = new Scene(SceneX * 20, SceneY * 20, new ImageIcon(Util.BLOOD_SCENE).getImage(),
						"血包");
				ctrl.getTanksWarFrame().getGamePanel().getSceneList().add(Scene1);
				break;
			case 2:
				Scene Scene2 = new Scene(SceneX * 20, SceneY * 20, new ImageIcon(Util.FORGEIRON_SCENE).getImage(),
						"打铁包");
				ctrl.getTanksWarFrame().getGamePanel().getSceneList().add(Scene2);
				break;
			case 3:
				Scene Scene3 = new Scene(SceneX * 20, SceneY * 20, new ImageIcon(Util.DEFENSE_SCENE).getImage(),
						"防御包");
				ctrl.getTanksWarFrame().getGamePanel().getSceneList().add(Scene3);
				break;
			}

			int num = 0;
			for (int a = 0; a < ctrl.getTanksWarFrame().getGamePanel().getSceneList().size(); a++) {
				for (int y = 0; y < ctrl.getTanksWarFrame().getGamePanel().getMap().length; y++) {

					for (int x = 0; x < ctrl.getTanksWarFrame().getGamePanel().getMap()[y].length; x++) {
						Rectangle recBarrier1 = new Rectangle(x * 20, y * 20, 20, 20);
						Rectangle recScene1 = new Rectangle(
								ctrl.getTanksWarFrame().getGamePanel().getSceneList().get(a).getSceneX(),
								ctrl.getTanksWarFrame().getGamePanel().getSceneList().get(a).getSceneY(), 60, 60
								);
						if (ctrl.getTanksWarFrame().getGamePanel().getMap()[y][x] == 0) {
							if (recScene1.intersects(recBarrier1)) {
								num++;
								if (num == 9) {
									return;
								}
							}
						}
					}

				}
			}
			ctrl.getTanksWarFrame().getGamePanel().getSceneList().remove(0);

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

	public int getTime2() {
		return time2;
	}

	public void setTime2(int time2) {
		this.time2 = time2;
	}
	
	

}
