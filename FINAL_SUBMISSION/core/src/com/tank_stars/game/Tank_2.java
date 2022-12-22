package com.tank_stars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tank_2 extends Tank{
    public Tank_2(String n) {
        super(n);
        health=800;
        tank_image=new Texture(Gdx.files.internal("Frost.png"));
    }

}
