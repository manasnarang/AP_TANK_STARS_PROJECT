package com.tank_stars.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class SavedGamesState extends State{
    private Stack<GameState> saved_games;
    private Texture home_button;
    private Texture saved_games_img;
    public SavedGamesState(GameStateManager gsm) {
        super(gsm);
    }

    public void push(GameState gameState){
        saved_games.push(gameState);
    }
    public void resume_game(int i){
        gsm.set(saved_games.get(i));
    }
    @Override
    protected void handleInput() {
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void dispose() {

    }
}
