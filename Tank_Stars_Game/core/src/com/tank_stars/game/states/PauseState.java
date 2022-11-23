package com.tank_stars.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class PauseState extends State{
    private Texture resume_game_button;
    private Texture save_and_exit;
    private Texture exit_button;
    public PauseState(GameStateManager gsm) {
        super(gsm);
        resume_game_button = new Texture(Gdx.files.internal("Resume.png"));
        exit_button = new Texture(Gdx.files.internal("Exit.png"));
        save_and_exit = new Texture(Gdx.files.internal("save_and_exit_1.png"));
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (touchPos.x >= 340 && touchPos.x <= 940) {
                if (touchPos.y >= 155 && touchPos.y <= 285) {       //Resume
                    gsm.pop();
                    dispose();
                } else if (touchPos.y>=295 && touchPos.y<=425){     //Save and Exit
                    gsm.pop();
//                    SavedGamesState savedGamesState =new SavedGamesState(gsm);
//                    savedGamesState.push((GameState) gsm.peek());
                    gsm.set(new SavedGamesState(gsm));
                }
                else if (touchPos.y>=435 && touchPos.y<=565){       //Exit
                    gsm.pop();
                    gsm.set(new MainMenuState(gsm));
                }
            }
        }

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(resume_game_button,340,435,600,130);
        sb.draw(save_and_exit,340,295,600,130);
        sb.draw(exit_button,340,155,600,130);
        handleInput();
        sb.end();
    }

    @Override
    public void dispose() {
        resume_game_button.dispose();
        save_and_exit.dispose();
        exit_button.dispose();
    }
}
