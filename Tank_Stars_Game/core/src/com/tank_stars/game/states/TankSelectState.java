package com.tank_stars.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class TankSelectState extends State{
    private Texture choose_tank_button1;
    private Texture choose_tank_button2;
    private Texture abrams;     //Tank 1
    private Texture frost;      //Tank 2
    private Texture helios;     //Tank 3
    private Texture start_button;
    private Texture back_button;
    public TankSelectState(GameStateManager gsm){
        super(gsm);
        abrams = new Texture(Gdx.files.internal("Abrams.png"));
        frost = new Texture(Gdx.files.internal("Frost.png"));
        helios = new Texture(Gdx.files.internal("Helios.png"));
        start_button = new Texture(Gdx.files.internal("Start_button.jpg"));
        back_button = new Texture(Gdx.files.internal("back_button.jpg"));
    }
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            if((touchPos.x>=400 && touchPos.x<=933) && (touchPos.y>=281 && touchPos.y<=470)){
                gsm.set(new GameState(gsm));
                dispose();
            }
            else if( (touchPos.x>=5 && touchPos.x<=155) && (touchPos.y>=5 && touchPos.y<=155)){
                gsm.set(new MainMenuState(gsm));
                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        ScreenUtils.clear(0, 0.3f, 0, 1);
        sb.draw(back_button,5,565,150,150);
        sb.draw(abrams,40,200,100,100);
        sb.draw(frost,150,200,100,100);
        sb.draw(helios,260, 200,100,100);
        sb.draw(start_button,400,250,533,189);
        handleInput();
        sb.end();
    }

    @Override
    public void dispose() {
        abrams.dispose();
        frost.dispose();
        helios.dispose();
        start_button.dispose();
    }
}
