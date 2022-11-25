package com.tank_stars.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class GameState extends State {
    private Texture game_background;
    private Texture pause_button;
//    private Texture player_1_Tank_img;		// tank image
//    private Texture player_2_Tank_img;
//    private Rectangle player_1_tank;		// tank object
//    private Rectangle player_2_tank;
    public GameState(GameStateManager gsm) {
        super(gsm);
        game_background = new Texture(Gdx.files.internal("GameScreen.png"));
        pause_button = new Texture(Gdx.files.internal("pause_menu_button.png"));
//        player_1_Tank_img = new Texture(Gdx.files.internal("Abrams.png"));
//        player_2_Tank_img = new Texture(Gdx.files.internal("Frost.png"));
//        player_1_tank = new Rectangle();
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            Vector3 touchpos=new Vector3();
            touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            if((touchpos.x>=10 && touchpos.x<=95) && (touchpos.y>=10 && touchpos.y<=95)){
//                Gdx.app.exit();
                gsm.push(new PauseState(gsm));
//                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(game_background,0,0,1280,720);
        sb.draw(pause_button,10,625,85,85);
//        sb.draw(player_1_Tank_img,100,450,70,70);
//        sb.draw(player_2_Tank_img,1180,450,70,70);
        handleInput();
        sb.end();
    }

    @Override
    public void dispose() {
//        player_1_Tank_img.dispose();
//        player_2_Tank_img.dispose();
        game_background.dispose();

    }
}
