package com.ccglp.backnforth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextEnding implements Screen {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private BitmapFont font;
	private int Ending;
	private float height;
	private float width;
	private Texture image;
	public TextEnding (int EndingNo){
		Ending = EndingNo;
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor (255.0f, 255.0f, 255.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.setProjectionMatrix(camera.projection);
		if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ESCAPE)){
			Gdx.app.exit();
		}
		batch.begin();
		drawDaThings();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	private void drawDaThings(){
		if (this.Ending == 0){
		font.drawMultiLine(batch, "Such a good guy, this blue", 50, height-50);
		font.drawMultiLine(batch, "But he always choose the easy way out", 50, height-100);
		font.drawMultiLine(batch, "That's not a good option in life.", 50, height-150);
		font.drawMultiLine(batch, "You can start again", 100, height-200);
		}
		if (this.Ending == 1){
			font.drawMultiLine(batch, "The name is green", 50, height-50);
			font.drawMultiLine(batch, "He can do everything alone, ", 50, height-100);
			font.drawMultiLine(batch, "but now he feels lonely", 50, height-150);
			font.drawMultiLine(batch,"Why would someone have no friends?", 50, height-200);
			font.drawMultiLine(batch, "You can start again, ", 100, height-250);
			font.drawMultiLine(batch,"with a little help from your friends", 100, height-300);
		}
		if (this.Ending==2){
			font.drawMultiLine(batch, "Red used to be a lonely girl", 50, height-50);
			font.drawMultiLine(batch, "But she found white and black ", 50, height-100);
			font.drawMultiLine(batch, "At the end, she seems powerful", 50, height-150);
			font.drawMultiLine(batch,"But without friends to help you...", 50, height-200);
			font.drawMultiLine(batch, "Power doesn't mean much", 100, height-250);
			font.drawMultiLine(batch,"Go back, and help me", 100, height-300);
		}
		if (this.Ending ==3){
			font.drawMultiLine(batch, "The name is red", 50, height-50);
			font.drawMultiLine(batch, "She have friends, ", 50, height-100);
			font.drawMultiLine(batch, "What is a friend?", 50, height-150);
			font.drawMultiLine(batch," A single soul ", 50, height-200);
			font.drawMultiLine(batch, "Dwelling in two bodies.", 100, height-250);
			font.drawMultiLine(batch,"Thanks for playing :)", 100, height-300);
		}
	}
	@Override
	public void show() {
		
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.position.x = Gdx.app.getGraphics().getWidth()/2;
		camera.position.y = Gdx.app.getGraphics().getHeight()/2;
		camera.update();
		font = new BitmapFont (Gdx.files.internal("font.fnt"));
		height = Gdx.app.getGraphics().getHeight();
		width = Gdx.app.getGraphics().getWidth();
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
