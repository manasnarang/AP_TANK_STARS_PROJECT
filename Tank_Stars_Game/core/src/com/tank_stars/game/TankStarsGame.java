package com.tank_stars.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tank_stars.game.states.GameStateManager;
import com.tank_stars.game.states.MainMenuState;

public class TankStarsGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture backgroundImage;
	private Texture player_1_Tank_img;		// tank image
	private Texture player_2_Tank_img;
	private Rectangle player_1_tank;		// tank object
	private Rectangle player_2_tank;
	private OrthographicCamera camera;
	private Texture new_game_button;
	private GameStateManager gsm;

	@Override
	public void create () {
		gsm = new GameStateManager();
		gsm.push(new MainMenuState(gsm));
		new_game_button=new Texture(Gdx.files.internal("new_game_button.jpg"));
		camera= new OrthographicCamera();
		camera.setToOrtho(false,1280,720);
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(1,0,0,1);
		player_1_Tank_img= new Texture(Gdx.files.internal("Helios.png"));		// CHANGE TANKS BASED ON
		player_2_Tank_img = new Texture(Gdx.files.internal("Frost.png"));		//WHAT PLAYERS CHOOSE
		backgroundImage = new Texture(Gdx.files.internal("badlogic.jpg"));			// CHANGE BACKGROUND IMAGE LATER
		player_1_tank= new Rectangle();
		player_2_tank = new Rectangle();
		player_1_tank.height=29;
		player_1_tank.width=64;
		player_1_tank.x = 20;		// start at 20 pixels from left
		player_1_tank.y = 100;		// and 100 pixels from bottom

		player_2_tank.width=64;
		player_2_tank.height=37;
		player_2_tank.y=100;			// start at 100 pixels from bottom
		player_2_tank.x = 800-84;	// and 20 pixels from right
	}
	private void print_home_screen(){
		ScreenUtils.clear(0,1,0,1);
		batch.draw(new_game_button,411,227);
	}

	private void print_game_screen(){
		batch.draw(player_1_Tank_img,player_1_tank.x,player_1_tank.y);
		batch.draw(player_2_Tank_img,player_2_tank.x,player_2_tank.y);
	}
	@Override
	public void render () {
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
//		camera.update();
//		batch.setProjectionMatrix(camera.combined);
//		batch.begin();
//		print_home_screen();
//		if(Gdx.input.isTouched()) {
//			Vector3 touchPos = new Vector3();
//			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
//			camera.unproject(touchPos);
//			print_game_screen();
//		}
//		batch.end();
	}
	
	@Override
	public void dispose () {
		player_1_Tank_img.dispose();
		player_2_Tank_img.dispose();
		backgroundImage.dispose();
		batch.dispose();
	}
}
