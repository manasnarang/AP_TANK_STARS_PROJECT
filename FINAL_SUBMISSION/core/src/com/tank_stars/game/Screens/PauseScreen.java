package com.tank_stars.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tank_stars.game.TankStarsGame;
import com.tank_stars.game.states.MainMenuState;
import com.tank_stars.game.states.SavedGamesState;

public class PauseScreen implements Screen {
    private TankStarsGame game;
    private Texture resume_game_button;
    private Texture save_and_exit;
    private Texture exit_button;
    private GameScreen gameScreen;

    public PauseScreen(TankStarsGame game, GameScreen previous_sceen) {
        this.game = game;
        this.gameScreen=previous_sceen;
        resume_game_button = new Texture(Gdx.files.internal("Resume.png"));
        exit_button = new Texture(Gdx.files.internal("Exit.png"));
        save_and_exit = new Texture(Gdx.files.internal("save_and_exit_1.png"));
    }

    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (touchPos.x >= 340 && touchPos.x <= 940) {
                if (touchPos.y >= 155 && touchPos.y <= 285) {       //Resume
//                    gsm.pop();
                    game.setScreen(gameScreen);     //Go back to previous screen
                    dispose();
                } else if (touchPos.y>=295 && touchPos.y<=425){     //Save and Exit
//                    gsm.pop();
//                    SavedGamesState savedGamesState =new SavedGamesState(gsm);
//                    savedGamesState.push((GameState) gsm.peek());
//                    gsm.set(new SavedGamesState(gsm));
                    game.getSavedGamesScreen().push(gameScreen);
                    game.setScreen(game.getSavedGamesScreen());
                }
                else if (touchPos.y>=435 && touchPos.y<=565){       //Exit
//                    gsm.pop();
//                    gsm.set(new MainMenuState(gsm));
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
        game.batch.draw(resume_game_button,340,435,600,130);
        game.batch.draw(save_and_exit,340,295,600,130);
        game.batch.draw(exit_button,340,155,600,130);
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
        resume_game_button.dispose();
        save_and_exit.dispose();
        exit_button.dispose();
    }
}
