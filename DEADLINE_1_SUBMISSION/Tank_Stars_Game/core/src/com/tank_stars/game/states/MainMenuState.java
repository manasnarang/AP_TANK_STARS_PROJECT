package com.tank_stars.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.ScreenUtils;


public class MainMenuState extends State{
    private Texture new_game_button;
    private Texture resume_game_button;
    private Texture exit_button;
    public MainMenuState(GameStateManager gameStateManager){
        super(gameStateManager);
        new_game_button=new Texture(Gdx.files.internal("New_game_2.png"));
//        Image new_game_button_image = new Image(new_game_button);
//        ImageButton new_game = new ImageButton(new_game_button_image.getDrawable());
        resume_game_button = new Texture(Gdx.files.internal("Resume.png"));
        exit_button = new Texture(Gdx.files.internal("Exit.png"));
    }
    @Override
    public void handleInput(){
        if(Gdx.input.justTouched()){
            Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

            if((touchPos.x>=100 && touchPos.x<=1180)) {
                if (touchPos.y >= 35 && touchPos.y <= 245) {
                    //New game button will redirect to tank selection screen
                    gsm.set(new TankSelectState(gsm));
                    dispose();
                }
                else if(touchPos.y>=255 && touchPos.y<=465){
                    //Resume button will redirect to Saved Games screen
                    gsm.set(new SavedGamesState(gsm));
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
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        ScreenUtils.clear(0, 0.3f, 0, 1);
        sb.draw(new_game_button,100,475,1080,210);
        sb.draw(resume_game_button,100,255,1080,210);
        sb.draw(exit_button,100,35,1080,210);
        handleInput();
        sb.end();
    }
    @Override
    public void dispose(){
        new_game_button.dispose();
        resume_game_button.dispose();
        exit_button.dispose();
    }
}
