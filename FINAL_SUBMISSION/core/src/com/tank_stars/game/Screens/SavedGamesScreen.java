package com.tank_stars.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tank_stars.game.TankStarsGame;
import com.tank_stars.game.states.GameState;
import com.tank_stars.game.states.MainMenuState;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;


//SINGLETON PATTERN IMPLEMENTED IN THIS
// AND ITERATOR

public class SavedGamesScreen implements Screen, Serializable {
    private ArrayList<GameScreen> saved_games;
    private Texture home_button;
    private Texture saved_games_img;
    private Texture save, sg1, sg2, back;
    private TankStarsGame game;
    private static SavedGamesScreen savedGamesScreen;

    private SavedGamesScreen(TankStarsGame game) {
        saved_games=new ArrayList<>();
        this.game = game;
        save = new Texture(Gdx.files.internal("saved.png"));
        sg1 = new Texture(Gdx.files.internal("sg1.png"));
        sg2 = new Texture((Gdx.files.internal("sg2.png")));
        back = new Texture((Gdx.files.internal("home_button.jpg")));
    }
    public static SavedGamesScreen get_saved_games_instance(TankStarsGame game){
        if(savedGamesScreen==null){
            savedGamesScreen=new SavedGamesScreen(game);
        }
        return savedGamesScreen;
    }
    public void push(GameScreen gameScreen){
        saved_games.add(gameScreen);
    }
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            Vector3 touchPos =new Vector3();
            touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            if((touchPos.x>=5 && touchPos.x<=155) && (touchPos.y>=5 && touchPos.y<=155)){
//                gsm.set(new MainMenuState(gsm));
                game.setScreen(new MainMenuScreen(game));
//                dispose();
            }
            else if((touchPos.x>=480 && touchPos.x<=780)){
                if((touchPos.y>=290 && touchPos.y<=370)){
//                    gsm.set(new GameState(gsm));
                    game.setScreen(get_saved_game(0));
//                    dispose();
                }
                else if((touchPos.y>=390 && touchPos.y<=470)){
                    game.setScreen(get_saved_game(1));
                }
            }
        }
    }
    private GameScreen get_saved_game(int i){
        return saved_games.get(i);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Iterator iterator=saved_games.iterator();
        game.batch.begin();
        ScreenUtils.clear(0, 0.3f, 0, 1);
        game.batch.draw(back,5,565,150,150);
        game.batch.draw(save,400,480,500,100);
        if(iterator.hasNext()){
            game.batch.draw(sg1,480, 350,300,80);
            iterator.next();
        }
        if(iterator.hasNext()){
            game.batch.draw(sg2,480,250,300,80);
        }
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
        back.dispose();
        save.dispose();
        sg1.dispose();
        sg2.dispose();

    }
}
