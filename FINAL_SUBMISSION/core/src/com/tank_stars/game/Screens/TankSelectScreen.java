package com.tank_stars.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tank_stars.game.TankStarsGame;
import com.tank_stars.game.Tank_1;
import com.tank_stars.game.Tank_2;
import com.tank_stars.game.states.GameState;
import com.tank_stars.game.states.MainMenuState;

public class TankSelectScreen implements Screen {
    private Texture choose_tank_button1;
    private Texture choose_tank_button2;
    private Texture abrams,abrams1;     //Tank 1
    private Texture frost,frost1;      //Tank 2
    private Texture helios,helios1;     //Tank 3
    private Texture start_button;
    private Texture back_button;
    private Texture choose_button;
    private Texture p1,p2;
    private TankStarsGame game;

    public TankSelectScreen(TankStarsGame game) {
        this.game = game;
        abrams = new Texture(Gdx.files.internal("Abrams.png"));
        frost = new Texture(Gdx.files.internal("Frost.png"));
        helios = new Texture(Gdx.files.internal("Helios.png"));
        start_button = new Texture(Gdx.files.internal("Start_button.jpg"));
        back_button = new Texture(Gdx.files.internal("back_button.jpg"));
        abrams1 = new Texture(Gdx.files.internal("Abrams.png"));
        frost1 = new Texture(Gdx.files.internal("Frost.png"));
        helios1 = new Texture(Gdx.files.internal("Helios.png"));
        choose_button = new Texture(Gdx.files.internal("choose.png"));
        p1 = new Texture((Gdx.files.internal("p1.png")));
        p2 = new Texture((Gdx.files.internal("p2.png")));
    }
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if((touchPos.x>=400 && touchPos.x<=900) && (touchPos.y>=580 && touchPos.y<=680)){
//                gsm.set(new GameState(gsm));
                game.setScreen(new GameScreen(game,new Tank_1("Abrams"),new Tank_1("Abrams")));
                dispose();
            }
            else if( (touchPos.x>=5 && touchPos.x<=155) && (touchPos.y>=5 && touchPos.y<=155)){
//                gsm.set(new MainMenuState(gsm));
                game.setScreen(new MainMenuScreen(game));
                dispose();
            }
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        ScreenUtils.clear(0, 0.3f, 0, 1);
        game.batch.draw(back_button,5,565,150,150);
        game.batch.draw(abrams,40,200,100,100);
        game.batch.draw(frost,150,200,100,100);
        game.batch.draw(helios,260, 200,100,100);
        game.batch.draw(start_button,400,40,500,100);
        game.batch.draw(abrams1,1280-40-100,200,100,100);
        game.batch.draw(frost1,1280-150-100,200,100,100);
        game.batch.draw(helios1,1280-260-100, 200,100,100);
        game.batch.draw(choose_button,400,480,500,100);
        game.batch.draw(p1,100,350,200,100);
        game.batch.draw(p2,1280-100-150,350,200,100);
        handleInput();
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
        abrams.dispose();
        frost.dispose();
        helios.dispose();
        abrams1.dispose();
        frost1.dispose();
        helios1.dispose();
        start_button.dispose();
    }
}
