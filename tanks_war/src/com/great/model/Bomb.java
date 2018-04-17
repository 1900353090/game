package com.great.model;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.great.util.Util;

public class Bomb {
	
	private int bombX;	//爆炸的X坐标
	private int bombY;	//爆炸的Y坐标
	private Image bombimage;	//爆炸的样子
	private boolean appearbomb;	//出现爆炸(true爆炸,false不爆炸)
	private int wide;
	private int high;
	
	public Bomb(int bombX,int bombY,int wide,int high) {
		
		this.wide = wide;
		this.high = high;
		this.bombX = bombX;
		this.bombY = bombY;
		init();
		
	}
	
	public void init() {
		
		bombimage = new ImageIcon(Util.BOMB_IMG).getImage();
		appearbomb = true;
		
	}

	
	
	/**
	 * ---------------------------get&set-------------------------
	 * @return
	 */
	public int getBombX() {
		return bombX;
	}

	public void setBombX(int bombX) {
		this.bombX = bombX;
	}

	public int getBombY() {
		return bombY;
	}

	public void setBombY(int bombY) {
		this.bombY = bombY;
	}

	public Image getBombimage() {
		return bombimage;
	}

	public void setBombimage(Image bombimage) {
		this.bombimage = bombimage;
	}

	public boolean isAppearbomb() {
		return appearbomb;
	}

	public void setAppearbomb(boolean appearbomb) {
		this.appearbomb = appearbomb;
	}

	public int getWide() {
		return wide;
	}

	public void setWide(int wide) {
		this.wide = wide;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}
	
	
	
}
