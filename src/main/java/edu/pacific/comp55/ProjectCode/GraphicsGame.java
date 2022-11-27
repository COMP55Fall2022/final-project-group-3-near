package edu.pacific.comp55.ProjectCode;

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GraphicsGame extends GraphicsProgram {
	public static final int PROGRAM_WIDTH = 1;
	public static final int PROGRAM_HEIGHT = 1;
	private Timer t = new Timer(1000, this); // 1000 ms = 1 second
	private Game game;
	private GLabel timer;
	private GLabel score;
	private int timerCount = 0;
	private int scoreCount = 0;
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		//needed for graphics program
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public void showMenu() {
		
	}
	
	public void showControl() {
		
	}
	
	public void showGame() {
		
	}
	
	public void showTime() {
		
	}
	
	public void showScore() {
		
	}
	
	public void drawBlock(Block B) {
		GImage block;
		if (B.getBlockType() == BlockType.BAR) {
			block = new GImage("media/bar2.jpg",0,0);
		}
		else if (B.getBlockType() == BlockType.RIGHTL) {
			block = new GImage("media/l4.png",0,0);
		}
		else if (B.getBlockType() == BlockType.LEFTL) {
			block = new GImage("media/lm4.png",0,0);
		}
		else if (B.getBlockType() == BlockType.RIGHTS) {
			block = new GImage("media/s.png",0,0);
		}
		else if (B.getBlockType() == BlockType.SQUARE) {
			block = new GImage("media/square.png",0,0);
		}
		else {
			block = new GImage("media/t3.png",0,0);
		}
		add(block);
		// TODO: ADD LEFTS
	}
	
}