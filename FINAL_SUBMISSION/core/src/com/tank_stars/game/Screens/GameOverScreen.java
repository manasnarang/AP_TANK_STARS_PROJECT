package com.tank_stars.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tank_stars.game.TankStarsGame;

public class GameOverScreen implements Screen {
    private Texture game_over;
    private Texture replay_button;
    private Texture exit_button;
    private TankStarsGame game;

    public GameOverScreen(TankStarsGame game) {
        this.game = game;
        game_over=new Texture(Gdx.files.internal("game_over.png"));
        replay_button=new Texture(Gdx.files.internal("replay_button.png"));
        exit_button = new Texture(Gdx.files.internal("Exit.png"));

    }
    public void handleInput(){
        if(Gdx.input.justTouched()){
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

            if((touchPos.x>=100 && touchPos.x<=1180)) {
                if(touchPos.y>=255 && touchPos.y<=465){
                    //Resume button will redirect to Saved Games screen
//                    gsm.set(new SavedGamesState(gsm));
                    game.setScreen(new TankSelectScreen(game));
//                    game.setScreen(new SavedGamesScreen(game));
                    dispose();
                }
                else if(touchPos.y>=475 && touchPos.y<=685){
//                    gsm.set(new ExitPromptState(gsm));
//                    dispose();
                    //exit the game
                    game.setScreen(new MainMenuScreen(game));
                }
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
        game.batch.draw(game_over,100,475,1080,210);
        game.batch.draw(replay_button,100,255,1080,210);
        game.batch.draw(exit_button,100,35,1080,210);
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
        game_over.dispose();
        replay_button.dispose();
        exit_button.dispose();
    }
}
