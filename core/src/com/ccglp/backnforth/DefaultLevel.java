package com.ccglp.backnforth;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class DefaultLevel implements Screen {
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	public OrthographicCamera camera;
	public Player red;
	public Player green;
	public Player blue;
	public Player white;
	public Player black;
	public Player player;
	private GameLogic logic;
	private Music music;
	private BitmapFont font;
	public Game game;
	public String levelName;
	
	public DefaultLevel (Game game, String name){
		this.game = game;
		this.levelName = name;
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor (0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.position.x = player.getX()+ player.getOriginX();
		camera.position.y = player.getY() + player.getOriginY()+ (4*32);
		camera.update();
		logic.handleInputGame(delta, this);
		renderer.setView(camera);
		renderer.render();
		renderer.getSpriteBatch().begin();
		player.draw(renderer.getSpriteBatch());
		
		renderer.getSpriteBatch().end();

		
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		if (levelName.equals("Original.tmx")){
		music = Gdx.audio.newMusic(Gdx.files.internal ("background_sound.mp3"));
		music.setLooping(true);
		music.play();
		}
		font = new BitmapFont (Gdx.files.internal("font.fnt"));
		logic = new GameLogic ();
		map = new TmxMapLoader().load(levelName);
		renderer = new OrthogonalTiledMapRenderer (map);
		createPlayers();
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		camera.viewportHeight = 64*14;
		camera.viewportWidth = 64*14;
	

	}

	private void createPlayers() {
		if (levelName.equals("Original.tmx") || levelName.equals("Leveltwo.tmx") || levelName.equals("LastLevel.tmx")){
		red = new Player (3*64,4*64,new Texture(Gdx.files.internal("red.png")),(TiledMapTileLayer)map.getLayers().get("Fondo"), true,this);
		blue = new Player (5*64,75*64,new Texture(Gdx.files.internal("blue.png")),(TiledMapTileLayer)map.getLayers().get("Fondo"), true,this);
		green = new Player (4*64,38*64,new Texture(Gdx.files.internal("green.png")),(TiledMapTileLayer)map.getLayers().get("Fondo"), true,this);
		black = new Player (74*64,71*64,new Texture(Gdx.files.internal("black.png")),(TiledMapTileLayer)map.getLayers().get("Fondo"), false,this);
		white = new Player (74*64,3*64,new Texture(Gdx.files.internal("white.png")),(TiledMapTileLayer)map.getLayers().get("Fondo"), false,this);
		
	
		white.startRotate();
		white.white();
		black.black();
		red.red();
		green.green();
		blue.blue();
		player = red;
		}
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
