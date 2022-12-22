package com.tank_stars.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tank_stars.game.GameClass;
import com.tank_stars.game.Hud;
import com.tank_stars.game.Tank;
import com.tank_stars.game.TankStarsGame;

import java.io.Serializable;

public class GameScreen implements Screen, Serializable {
    private Texture game_background;
    private Texture pause_button;
    private TankStarsGame game;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
//    private Hud hud;
    public static World game_world;
    private Box2DDebugRenderer debugRenderer;
    private GameClass gameClass;

    public GameScreen(TankStarsGame game, Tank t1, Tank t2) {
        gameClass=new GameClass(t1,t2);
        this.game = game;
        gamecam=new OrthographicCamera();
        gamePort=new StretchViewport(1280,720,gamecam);

//        hud=new Hud(game.batch);
        game_world=new World(new Vector2(0,-10),true);
        debugRenderer=new Box2DDebugRenderer();
        BodyDef bdef_tank1=new BodyDef();
        PolygonShape shape=new PolygonShape();
        FixtureDef fdef_1 = new FixtureDef();
        Body body_tank1;
        bdef_tank1.type=BodyDef.BodyType.DynamicBody;
        bdef_tank1.fixedRotation=false;

        bdef_tank1.position.set(new Vector2(40,40));      //CHANGE LATER
        shape.setAsBox(100,100);
        fdef_1.shape=shape;
        fdef_1.friction=10.25f;
        fdef_1.restitution=0.02f;
        fdef_1.density=1f;
        body_tank1=game_world.createBody(bdef_tank1);
        body_tank1.createFixture(fdef_1);

        BodyDef bdef_tank2=new BodyDef();
        PolygonShape shape_2=new PolygonShape();
        FixtureDef fdef_2=new FixtureDef();
        Body body_tank2;
        bdef_tank2.type=BodyDef.BodyType.DynamicBody;
        bdef_tank2.fixedRotation=false;
        bdef_tank2.position.set(new Vector2(1240,40));      //CHANGE LATER
        shape_2.setAsBox(100,100);
        fdef_2.shape=shape_2;
        fdef_2.shape=shape;
        fdef_2.friction=10.25f;
        fdef_2.restitution=0.02f;
        fdef_2.density=1f;
        body_tank2=game_world.createBody(bdef_tank2);
        body_tank2.createFixture(fdef_2);


        game_background=new Texture(Gdx.files.internal("GameScreen.png"));
        pause_button = new Texture(Gdx.files.internal("pause_menu_button.png"));

    }
    public void handleInput() {
        if(Gdx.input.justTouched()){
            Vector3 touchpos=new Vector3();
            touchpos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            if((touchpos.x>=10 && touchpos.x<=95) && (touchpos.y>=10 && touchpos.y<=95)){
                game.setScreen(new PauseScreen(game,this));
//                Gdx.app.exit();
//                gsm.push(new PauseState(gsm));
//                dispose();
            }
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
//        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        ScreenUtils.clear(0, 0.3f, 0, 1);
        game.batch.draw(game_background,0,0,1280,720);
        game.batch.draw(pause_button,10,625,85,85);
        handleInput();
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game_background.dispose();

    }
}
