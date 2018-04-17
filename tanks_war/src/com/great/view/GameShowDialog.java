package com.great.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

public class GameShowDialog extends JDialog{
	
	private JTextArea gameShow,writer;	//����һ���ı���jtextarea
	
	public GameShowDialog() {
		init();
		this.setLayout(null);
		
		//�����������ʽ�ʹ�С
		Font gameShowFont = new Font("Serif",0,15);
		//��������ʽ�ʹ�С��������ӵ�gameShow�ı�����
		gameShow.setFont(gameShowFont);
		gameShow.setText(
							  "��Ϸһ��8��,ÿ�ز�̹ͬ�����͵�������ͬ��\n"
							+ "\n"
							+ "�з�̹������:"
							+ "��(Ѫ��1,�ٶ�1,��ֵ100)\n"
							+ "��(Ѫ��2,�ٶ�1,��ֵ200)\n"
							+ "��(Ѫ��1,�ٶ�2,��ֵ200)\n"
							+ "��(Ѫ��2,�ٶ�2,��ֵ300)\n"
							+ "��(Ѫ��2,�ٶ�3,��ֵ500)\n"
							+ "\n"
							+ "��ͼ�ڻ�������ֲ�ͬ����ĵ���:\n"
							+ "Ѫ��:HP+1\n"
							+ "�ӵ���ǿ:���Դ���ǽ(ʱЧ30��)\n"
							+ "������ǿ:������Χ����һ����ǽ(ʱЧ30��)\n"
							+ "\n"
							+ "���һ����������,ÿ����һ��������Ѫ\n"
							+ "���ر�����,�������������������Ϸ����"
						);
		gameShow.setBounds(0, 0, 600-6, 800-400);
		//�����ı��򲻿ɸ���
		gameShow.setEditable(false);
		//���һ���߿��ı�����
		gameShow.setBorder(BorderFactory.createLineBorder(Color.gray,3));
		
		//�����������ʽ�ʹ�С
		Font writerFont = new Font("Serif",0,80);
		writer.setFont(writerFont);
		writer.setText(
						  "����:\n"
						+ "JF1803A��12��\n"
						+ "������\n"
					);
		writer.setBounds(0, 400, 600-6, 400-35);
		writer.setEditable(false);
		writer.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
		
		this.add(gameShow);
		this.add(writer);
		
		this.setTitle("��Ϸ˵��");
		this.setUndecorated(true);	// ȥ�����ڵ�װ�� 
		this.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);	//����ָ���Ĵ���װ�η��
		this.setPreferredSize(new Dimension(600,800));
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.setVisible(false);
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
	public void init() {
		
		gameShow = new JTextArea();
		writer = new JTextArea();
		
	}

}
