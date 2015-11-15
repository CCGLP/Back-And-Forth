package com.ccglp.backnforth;


import com.badlogic.gdx.Game;


public class Main_Handler extends Game {
	
	@Override
	public void create () {
		this.setScreen(new IntroScreen(this));
		//this.setScreen(new DefaultLevel(this,"Original.tmx"));
		//this.setScreen(new DefaultLevel (this, "Leveltwo.tmx"));
		//this.setScreen ());
	}


}
