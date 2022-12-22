package com.tank_stars.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.tank_stars.game.Hud;
import com.tank_stars.game.TankStarsGame;

public class GameState extends State {
    private Texture game_background;
    private Texture pause_button;
    private TankStarsGame game;
    private Hud hud;

    public static World game_world;
    private Box2DDebugRenderer debugRenderer;

//    private Texture player_1_Tank_img;		// tank image
//    private Texture player_2_Tank_img;
//    private Rectangle player_1_tank;		// tank object
//    private Rectangle player_2_tank;

    public GameState(GameStateManager gsm) {
        super(gsm);
        game=gsm.getGame();
        hud=new Hud(game.batch);
        game_world=new World(new Vector2(0,-10),true);
        BodyDef bdef=new BodyDef();
        PolygonShape shape=new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

//        game_background = new Texture(Gdx.files.internal("GameScreen.png"));
        game_background=new Texture(Gdx.files.internal("Game_background.png"));
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
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
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
