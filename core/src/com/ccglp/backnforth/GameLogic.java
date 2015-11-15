package com.ccglp.backnforth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;



public class GameLogic extends InputAdapter {
	public GameLogic(){
		init();
	}
	private void init(){
		Gdx.input.setInputProcessor(this);
		Gdx.input.setCatchBackKey(true);
	}
	
	public void handleInputGame (float deltaTime, DefaultLevel level){
		if (!level.player.black){
		if (Gdx.input.isKeyPressed(Keys.SPACE)|| Gdx.input.isKeyPressed(Keys.UP)){
			if (level.player.white)
				level.player.setVelocityY(448);
				
			else if (level.player.canUseJump){
				level.player.setVelocityY(1920);
				
			}
			level.player.canUseJump = false;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)&& level.player.white){
			level.player.setVelocityY(-448);
		}
		if (Gdx.input.isKeyPressed(Keys.D)|| (Gdx.input.isKeyPressed(Keys.RIGHT))){
			if (level.player.collisionY)
				level.player.setVelocityX(448);
			else{
				level.player.setVelocityX(448);
			}
			
		
	}
		if(Gdx.input.isKeyPressed(Keys.A) || (Gdx.input.isKeyPressed(Keys.LEFT))){
			if(level.player.collisionY)
				level.player.setVelocityX(-448);
			else{
				level.player.setVelocityX (-448);
			}
		}
	}
		if (Gdx.input.isKeyPressed(Keys.NUM_1)){
			level.player = level.red;
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_2)){
			level.player = level.black;
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_3)){
			level.player = level.white;
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_4)){
			level.player = level.blue;
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_5)){
			level.player = level.green;
		}
		else if (Gdx.input.isKeyPressed(Keys.ESCAPE)){
			Gdx.app.exit();
		}

	}
}