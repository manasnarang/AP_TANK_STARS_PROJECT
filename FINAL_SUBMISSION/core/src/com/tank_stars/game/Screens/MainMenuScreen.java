package com.tank_stars.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.tank_stars.game.TankStarsGame;
import com.tank_stars.game.states.SavedGamesState;
import com.tank_stars.game.states.TankSelectState;

public class MainMenuScreen implements Screen {
    private TankStarsGame game;
    private Texture new_game_button;
    private Texture resume_game_button;
    private Texture exit_button;

    public MainMenuScreen(TankStarsGame game) {
        new_game_button=new Texture(Gdx.files.internal("New_game_2.png"));
        resume_game_button = new Texture(Gdx.files.internal("Resume.png"));
        exit_button = new Texture(Gdx.files.internal("Exit.png"));
        this.game = game;
    }

    public void handleInput(){
        if(Gdx.input.justTouched()){
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

            if((touchPos.x>=100 && touchPos.x<=1180)) {
                if (touchPos.y >= 35 && touchPos.y <= 245) {
                    //New game button will redirect to tank selection screen
//                    gsm.set(new TankSelectState(gsm));
                    game.setScreen(new TankSelectScreen(game));
                    dispose();
                }
                else if(touchPos.y>=255 && touchPos.y<=465){
                    //Resume button will redirect to Saved Games screen
//                    gsm.set(new SavedGamesState(gsm));
                    game.setScreen(game.getSavedGamesScreen());
//                    game.setScreen(new SavedGamesScreen(game));
                    dispose();
                }
                else if(touchPos.y>=475 && touchPos.y<=685){
//                    gsm.set(new ExitPromptState(gsm));
//                    dispose();
                    //exit the game
                    Gdx.app.exit();
                }
            }
        }

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0.3f,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(new_game_button,100,475,1080,210);
        game.batch.draw(resume_game_button,100,255,1080,210);
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
        new_game_button.dispose();
        resume_game_button.dispose();
        exit_button.dispose();

    }
}
