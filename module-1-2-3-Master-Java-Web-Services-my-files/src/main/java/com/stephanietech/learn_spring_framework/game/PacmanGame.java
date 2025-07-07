package com.stephanietech.learn_spring_framework.game;

//@Component
public class PacmanGame implements GamingConsole{

	public void up() {
		System.out.println("Pacman jump");
	}
	
	public void down() {
		System.out.println("Pacman down into a hole");
	}
	
	public void left() {
		System.out.println("Pacman left");
	}
	
	public void right() {
		System.out.println("Pacman right");
	}
}
