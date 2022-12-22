package com.tank_stars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private Integer player_1_health;
    private Integer player_2_health;
    private Integer player_1_fuel;
    private Integer player_2_fuel;
    private Integer power;
    private Integer angle;

    Label player_1_healthLabel;
    Label player_2_healthLabel;
    Label player_1_fuelLabel;
    Label player_2_fuelLabel;
    Label powerLabel;
    Label angleLabel;

    public Hud(SpriteBatch sb){
        player_1_health=100;
        player_2_health=100;
        viewport=new FitViewport(1280,720, new OrthographicCamera());
        stage=new Stage(viewport,sb);
        Table table=new Table();
        table.top();
        table.setFillParent(true);

        player_1_healthLabel=new Label(String.format("%03d",player_1_health),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player_2_healthLabel=new Label(String.format("%03d",player_2_health),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player_1_fuelLabel=new Label(String.format("%03d",player_1_fuel),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player_2_fuelLabel=new Label(String.format("%03d",player_2_fuel),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        powerLabel=new Label(String.format("%03d",power),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        angleLabel=new Label(String.format("%03d",angle),new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(player_1_healthLabel).expandX();
        table.add(player_2_healthLabel).expandX();
        table.add(player_1_fuelLabel).expandX();
        table.add(player_2_fuelLabel).expandX();
        table.row();
        table.add(powerLabel).expandX();
        table.add(angleLabel).expandX();


    }
}
