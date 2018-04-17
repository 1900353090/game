package com.great.model;

import java.awt.Image;

public class Scene {
	private int SceneX;
	private int SceneY;
	private Image image;
	private String name;
	private boolean flag;
	
	public Scene(int SceneX,int SceneY,Image image,String name) {
		
		init(SceneX,SceneY,image,name);
		
	}
	
	public void init(int SceneX,int SceneY,Image image,String name) {
		
		this.SceneX = SceneX;
		this.SceneY = SceneY;
		this.image = image;
		this.name = name;
		flag = true;
		
	}

	public int getSceneX() {
		return SceneX;
	}

	public void setSceneX(int sceneX) {
		SceneX = sceneX;
	}

	public int getSceneY() {
		return SceneY;
	}

	public void setSceneY(int sceneY) {
		SceneY = sceneY;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	

}
