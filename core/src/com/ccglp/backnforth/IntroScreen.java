package com.ccglp.backnforth;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IntroScreen implements Screen {
	private Texture texture;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Game game;
	public IntroScreen (Game game ){
		this.game = game;
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor (255.0f, 255.0f, 255.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		if (Gdx.input.isKeyPressed(Keys.ENTER)|| (Gdx.input.isKeyPressed(Keys.SPACE)) || (Gdx.input.isTouched())){
			this.game.setScreen(new DefaultLevel(this.game, "Original.tmx"));
		}
		batch.begin();
		batch.draw(texture,texture.getWidth()/2, texture.getHeight()/2);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		texture = new Texture(Gdx.files.internal("BackAndForthImage.png"));
		camera = new OrthographicCamera();
		camera.viewportHeight = texture.getHeight();
		camera.viewportWidth = texture.getWidth();
		camera.position.x = texture.getWidth();
		camera.position.y = texture.getHeight();
		camera.update();
		batch = new SpriteBatch();

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
