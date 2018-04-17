package com.great.ctrl;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class BGM {
	
	
	//文件类  File
	public File f = new File("bgm/qinghuaci.wav");
	public File a = new File("bgm/blast.wav");
	//加载音效的文件
	
	
	//  音频
	public AudioClip ac ;
	//音效 的 音频
	public AudioClip ab ;
	public BGM() {
		 
		//截取音频文件
		
		try {
			ac = Applet.newAudioClip(f.toURI().toURL());
			ab = Applet.newAudioClip(a.toURI().toURL());
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	//播放一次
	public void play() {
		ac.play();
	}
	
	//停止播放
	public void stop() {
		ac.stop();
	}
	
	//循环播放
	public void loop() {
		ac.loop();
	}
	

}
