package com.tank_stars.game.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tank_stars.game.TankStarsGame;

import java.util.Stack;

public class GameStateManager {
    private Stack<State> states;
    private TankStarsGame game;
    public GameStateManager(TankStarsGame game){
        states = new Stack<>();
        this.game=game;
    }
    public void push(State state){
        states.push(state);
    }
    public void pop(){
        states.pop();
    }
    public void set(State state){
        states.pop();
        states.push(state);
    }
    public void update(float dt){
        states.peek().update(dt);
    }
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
    public State peek(){
        return states.peek();
    }
    public TankStarsGame getGame(){
        return this.game;
    }
}
