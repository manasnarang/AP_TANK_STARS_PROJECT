package com.tankstars.game.States;import com.badlogic.gdx.Gdx;import com.badlogic.gdx.graphics.Texture;import com.badlogic.gdx.graphics.g2d.SpriteBatch;import java.util.Stack;public class SavedGamesState extends State{    private Stack<GameState> saved_games;    private Texture home_button;    private Texture saved_games_img;    private Texture save, sg1, sg2, back;    public SavedGamesState(GamestateManager gam) {        super(gam);        save = new Texture(Gdx.files.internal("saved.png"));        sg1 = new Texture(Gdx.files.internal("sg1.png"));        sg2 = new Texture((Gdx.files.internal("sg2.png")));        back = new Texture((Gdx.files.internal("back_button.jpg")));    }    public void push(GameState gameState){        saved_games.push(gameState);    }    public void resume_game(int i){        gam.set(saved_games.get(i));    }    @Override    protected void handleInput() {    }    @Override    public void update(float dt) {    }    @Override    public void render(SpriteBatch sb) {        sb.begin();        sb.draw(back,5,565,150,150);        sb.draw(save,400,480,500,100);        sb.draw(sg1,480, 350,300,80);        sb.draw(sg2,480,250,300,80);        handleInput();        sb.end();    }    @Override    public void dispose() {        back.dispose();        save.dispose();        sg1.dispose();        sg2.dispose();    }}