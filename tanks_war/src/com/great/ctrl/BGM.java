package com.great.ctrl;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class BGM {
	
	
	//�ļ���  File
	public File f = new File("bgm/qinghuaci.wav");
	public File a = new File("bgm/blast.wav");
	//������Ч���ļ�
	
	
	//  ��Ƶ
	public AudioClip ac ;
	//��Ч �� ��Ƶ
	public AudioClip ab ;
	public BGM() {
		 
		//��ȡ��Ƶ�ļ�
		
		try {
			ac = Applet.newAudioClip(f.toURI().toURL());
			ab = Applet.newAudioClip(a.toURI().toURL());
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	//����һ��
	public void play() {
		ac.play();
	}
	
	//ֹͣ����
	public void stop() {
		ac.stop();
	}
	
	//ѭ������
	public void loop() {
		ac.loop();
	}
	

}
