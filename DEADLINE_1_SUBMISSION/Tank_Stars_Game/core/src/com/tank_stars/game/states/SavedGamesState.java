package com.tank_stars.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.Stack;

public class SavedGamesState extends State{
    private Stack<GameState> saved_games;
    private Texture home_button;
    private Texture saved_games_img;
    private Texture save, sg1, sg2, back;
    public SavedGamesState(GameStateManager gsm) {
        super(gsm);
        save = new Texture(Gdx.files.internal("saved.png"));
        sg1 = new Texture(Gdx.files.internal("sg1.png"));
        sg2 = new Texture((Gdx.files.internal("sg2.png")));
        back = new Texture((Gdx.files.internal("home_button.jpg")));
    }

    public void push(GameState gameState){
        saved_games.push(gameState);
    }
    public void resume_game(int i){
        gsm.set(saved_games.get(i));
    }
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            Vector3 touchPos =new Vector3();
            touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            if((touchPos.x>=5 && touchPos.x<=155) && (touchPos.y>=5 && touchPos.y<=155)){
                gsm.set(new MainMenuState(gsm));
                dispose();
            }
            else if((touchPos.x>=480 && touchPos.x<=780)){
                if((touchPos.y>=290 && touchPos.y<=370) || (touchPos.y>=390 && touchPos.y<=470)){
                    gsm.set(new GameState(gsm));
                    dispose();
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
        sb.draw(back,5,565,150,150);
        sb.draw(save,400,480,500,100);
        sb.draw(sg1,480, 350,300,80);
        sb.draw(sg2,480,250,300,80);
        handleInput();
        sb.end();


    }

    @Override
    public void dispose() {
        back.dispose();
        save.dispose();
        sg1.dispose();
        sg2.dispose();

    }
}