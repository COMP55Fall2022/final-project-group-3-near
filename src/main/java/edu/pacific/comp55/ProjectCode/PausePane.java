package edu.pacific.comp55.ProjectCode;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import edu.pacific.comp55.starter.GButton;
import edu.pacific.comp55.starter.GraphicsPane;

public class PausePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
									// all of the GraphicsProgram calls
	private GImage pause;
	private GButton resume;
	private GButton menu;
	public boolean paused = true;

	public PausePane(MainApplication app) {
		this.program = app;
		pause = new GImage("pause.png", 0, 0);
		pause.setSize(program.WINDOW_WIDTH, program.WINDOW_HEIGHT);
		
		resume = new GButton("resume", 550, 370, 240, 100);
		resume.setColor(Color.pink);
		resume.setVisible(false);
		
		menu = new GButton("menu", 230, 370, 240, 100);
		menu.setColor(Color.red);
		menu.setVisible(false);
	}

	@Override
	public void showContents() {
		program.add(pause);
		program.add(resume);
		program.add(menu);
	}

	@Override
	public void hideContents() {
		program.remove(pause);
		program.remove(resume);
		program.remove(menu);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == menu) {
			program.stopTime();
			program.stopSound();
			program.switchToMenu();
		}else if(obj == resume) {
			program.playSound();
			program.startTime();
			paused = false;
			program.switchToGame();
		}
	}
}
