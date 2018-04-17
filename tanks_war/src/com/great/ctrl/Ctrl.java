package com.great.ctrl;

import com.great.model.AppearFoeTankThread;
import com.great.model.AppearSceneThread;
import com.great.model.BulletThread;
import com.great.model.MoveFoeTankThread;
import com.great.view.CustomDialog;
import com.great.view.GameShowDialog;
import com.great.view.NameDialog;
import com.great.view.OverDialog;
import com.great.view.RankingDialog;
import com.great.view.TanksWarFrame;

public class Ctrl {
	
	private TanksWarFrame TanksWarFrame;
	private NameDialog nameDialog;
	private OverDialog overDialog;
	private GameShowDialog gameShowDialog;
	private RankingDialog rankingDialog;
	private CustomDialog customDialog;
	
	private AppearFoeTankThread AppFoeTank;
	private MoveFoeTankThread MoveFoeTank;
	private BulletThread Bullet;
	private AppearSceneThread AppScene;
	
	public Ctrl() {
		
		init();
		
	}
	
	public void init() {
		
		TanksWarFrame = new TanksWarFrame(this);
		nameDialog = new NameDialog(this);
		overDialog = new OverDialog(this);
		gameShowDialog = new GameShowDialog();
		customDialog = new CustomDialog(this);
		
		rankingDialog = new RankingDialog();
		
		AppFoeTank = new AppearFoeTankThread(this);

		MoveFoeTank = new MoveFoeTankThread(this);

		Bullet = new BulletThread(this);

		AppScene = new AppearSceneThread(this);
		
	}


	public void getAppStop() {
		AppFoeTank.setOnOFF(false);
		MoveFoeTank.setOnOFF(false);
		Bullet.setOnOFF(false);
		AppScene.setOnOFF(false);
		TanksWarFrame.dispose();;
		overDialog.dispose();
		nameDialog.dispose();
		gameShowDialog.dispose();
	}
	
	public void getThreadStart() {
		
		AppFoeTank.start();
		MoveFoeTank.start();
		Bullet.start();
		AppScene.start();
		
	}

	
	
	/**
	 * -----------------------get&set-----------------------
	 */

	public TanksWarFrame getTanksWarFrame() {
		return TanksWarFrame;
	}

	public void setTanksWarFrame(TanksWarFrame tanksWarFrame) {
		TanksWarFrame = tanksWarFrame;
	}

	public NameDialog getNameDialog() {
		return nameDialog;
	}

	public void setNameDialog(NameDialog nameDialog) {
		this.nameDialog = nameDialog;
	}

	public AppearFoeTankThread getAppFoeTank() {
		return AppFoeTank;
	}

	public void setAppFoeTank(AppearFoeTankThread appFoeTank) {
		AppFoeTank = appFoeTank;
	}

	public MoveFoeTankThread getMoveFoeTank() {
		return MoveFoeTank;
	}

	public void setMoveFoeTank(MoveFoeTankThread moveFoeTank) {
		MoveFoeTank = moveFoeTank;
	}


	public BulletThread getBullet() {
		return Bullet;
	}

	public void setBullet(BulletThread bullet) {
		Bullet = bullet;
	}

	public OverDialog getOverDialog() {
		return overDialog;
	}

	public void setOverDialog(OverDialog overDialog) {
		this.overDialog = overDialog;
	}

	public GameShowDialog getGameShowDialog() {
		return gameShowDialog;
	}

	public void setGameShowDialog(GameShowDialog gameShowDialog) {
		this.gameShowDialog = gameShowDialog;
	}

	public RankingDialog getRankingDialog() {
		return rankingDialog;
	}

	public void setRankingDialog(RankingDialog rankingDialog) {
		this.rankingDialog = rankingDialog;
	}

	public AppearSceneThread getAppScene() {
		return AppScene;
	}

	public void setAppScene(AppearSceneThread appScene) {
		AppScene = appScene;
	}

	public CustomDialog getCustomDialog() {
		return customDialog;
	}

	public void setCustomDialog(CustomDialog customDialog) {
		this.customDialog = customDialog;
	}


	
	
	
}
