package com.ccglp.backnforth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {
	private TiledMapTileLayer collisionLayer;
	private Vector2 velocity = new Vector2();
	private float gravity;
	private float oldX, oldY;
	private float tileWidth = 64;
	private float tileHeight = 64;
	public boolean collisionX = false, collisionY = false;
	private boolean collisionroof = false;
	private float timeJumping = 0;
	private boolean rota = false;
	public boolean canUseJump = true;
	public boolean white = false;
	public boolean black = false;
	private boolean red = false;
	private boolean green = false;
	private boolean blue = false;
	private float originalX;
	private float originalY;
	private DefaultLevel level;
	public Player (float X, float Y,Texture texture, TiledMapTileLayer collisionLayer, boolean gravity, DefaultLevel level){
		super (texture);
		this.collisionLayer = collisionLayer;
		if (gravity)
			this.gravity = 100*64;
		else
			this.gravity = 0;
		
		this.level = level;
		this.originalX = X;
		this.originalY = Y;
		this.setPosition(X, Y);
			
	}
	
	public void white (){
		white = true;
	}
	public void black(){
		black = true;
	}
	public void red (){
		red = true;
	}
	public void green(){
		green = true;
	}
	private void handletimeJumping (float deltaTime){
		timeJumping += deltaTime;
		if (timeJumping > 1.0f){
			canUseJump =false;
			setVelocityY(-getGravity());
		}
		if (collisionY && !collisionroof){
			timeJumping = 0.0f;
			canUseJump = true;
		}
		if (collisionroof){
			collisionroof = false;
		}
	}
	public float getVelocityX (){
		return this.velocity.x;
	}
	public void blue (){
		this.blue = true;
	}
	public float getVelocityY (){
		return this.velocity.y;
	}
	public void setVelocityX (float number){
		this.velocity.x = number;
		
	}
	public void startRotate (){
		this.rota = true;
	}
	public void setVelocityY (float number){
		this.velocity.y = number;
	}
	
	public void increaseVelocityX (float number){
		this.velocity.x += number;
	}
	public void decreaseVelocityX (float number){
		this.velocity.x -= number;
	}
	
	public void setPositionY (float position){
		this.setPosition (this.getX(), position);
	}
	
	public float getGravity () {
		return gravity;
	}
	
	private void rozamiento(){
		if (velocity.x > 0)
		this.decreaseVelocityX(16);
		if (velocity.x <0)
			this.increaseVelocityX(16);
	}
	public boolean setColisionX (String key){
		
		if (velocity.x<0){
			collisionX = collisionLayer.getCell((int)(getX()/tileWidth), (int) ((getY()+getHeight())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			
			if (!collisionX)
			collisionX = collisionLayer.getCell((int)(getX()/tileWidth), (int) ((getY()+getHeight()/2)/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionX)
			collisionX = collisionLayer.getCell((int)(getX()/tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
		}
		
		else if (velocity.x>0){
		
			collisionX = collisionLayer.getCell((int)((getX() + getWidth())/tileWidth), (int) ((getY()+getHeight())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionX)
			collisionX = collisionLayer.getCell((int)((getX()+ getWidth())/tileWidth), (int) ((getY()+getHeight()/2)/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionX)
			collisionX = collisionLayer.getCell((int)((getX()+ getWidth())/tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			
		}

		else if (velocity.x == 0)
			collisionX = false;
		
		return collisionX;
	}
	
	
	public boolean setColisionY(String key){
		if (velocity.y < 0){
			canUseJump = false;
			
			collisionY = collisionLayer.getCell((int)(getX() /tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
		
			if (!collisionY)
				
			collisionY = collisionLayer.getCell((int)((getX()+ getWidth()/2)/tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			
			if (!collisionY)
			
			collisionY = collisionLayer.getCell((int)((getX()+ getWidth())/tileWidth), (int) ((getY())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			
		}
		else if (velocity.y > 0){
			
			collisionY = collisionLayer.getCell((int)(getX() /tileWidth), (int) ((getY()+getHeight())/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionY)
			collisionY = collisionLayer.getCell((int)((getX()+ getWidth()/2)/tileWidth), (int) ((getY()+getHeight()  )/ tileHeight))
					.getTile().getProperties().containsKey(key);
			if (!collisionY)
			collisionY = collisionLayer.getCell((int)((getX()+ getWidth())/tileWidth), (int) ((getY()+getHeight())/ tileHeight))
					.getTile().getProperties().containsKey(key);
		collisionroof = collisionY;	
		}
		
		return collisionY;
	}
	
	private void rozamientoaire(){
		velocity.y -=2.0f;
	}
	@Override 
	public void draw (Batch spritebatch){
		this.update(Gdx.graphics.getDeltaTime());
		super.draw(spritebatch);
	}
	
	private void update (float deltaTime){
		if(deltaTime < 0.05)
			velocity.y -= gravity * deltaTime;
		else
			velocity.y = 0;
		//rozamientoaire();
		oldX = getX();
		oldY = getY();
		setX(getX()+ velocity.x*deltaTime);
		if (red){
			this.collisionY = false;
			if (this.setColisionY("muerte")){
				this.setPosition (originalX, originalY);
				this.level.black.setPosition(this.level.black.originalX, this.level.black.originalY);
				this.level.white.setPosition(this.level.white.originalX, this.level.white.originalY);
			}
			
			this.collisionX = false;
			if (this.setColisionX("level")){
				if (this.level.levelName.equals("Original.tmx")){
					this.level.game.setScreen(new DefaultLevel(this.level.game,"Leveltwo.tmx"));
				}
				else if (this.level.levelName.equals("Leveltwo.tmx")){
					this.level.game.setScreen(new DefaultLevel(this.level.game, "LastLevel.tmx"));
				}
				else if (this.level.levelName.equals("LastLevel.tmx")){
					this.level.game.setScreen(new TextEnding(2));
				}
			}
			this.collisionX=false;
			 if (this.setColisionX("ending")){
				 this.level.game.setScreen(new TextEnding(3));
			 }
		
		}
else if (green){
		this.rotate(90);
		this.collisionY = false;
		if (this.setColisionY("muerte")){
			this.setPosition (originalX, originalY);
		}
		this.collisionX= false;
		if (this.setColisionX("level")){
			this.level.game.setScreen(new TextEnding(1));
		}
	
	
}
else if (blue){
	this.collisionX = false;
	if (this.setColisionX("level")){
		this.level.game.setScreen(new TextEnding(0));
	}
}
		setColisionX ("colision");
		if (collisionX){
			setX (oldX);
			velocity.x = 0;
		}
		rozamiento();
		setY(getY()+velocity.y*deltaTime);

		setColisionY("colision");
		if(collisionY){
			setY(oldY);
			velocity.y = 0;
		}
	
			
		if (white){
			this.rotate(10);
			this.level.black.setPosition(this.getX(), this.getY() + 69*64);
			this.level.black.setVelocityY(2);
			if (this.level.black.setColisionY("muerte")){
				this.setPosition(originalX, originalY);
			}
			this.level.black.setVelocityY(0);
				
		}
		else if (black){
			velocity.y = -2;
			if (setColisionY("level")){
				if(this.level.levelName.equals("Original.tmx")||this.level.levelName.equals("Leveltwo.tmx")){
				level.red.setPosition(13*64, 8*64);
				}
				else {
					level.red.setPosition(55*64,25*64);
					
				}
			}
			velocity.y = 0;
		}
/*	if (red){
			
			if (this.setColisionY("muerte")){
				this.setPosition (originalX, originalY);
				this.level.black.setPosition(this.level.black.originalX, this.level.black.originalY);
				this.level.white.setPosition(this.level.white.originalX, this.level.white.originalY);
			}
			
		
		}*/
		handletimeJumping (Gdx.graphics.getDeltaTime());
	}
	
	
}


