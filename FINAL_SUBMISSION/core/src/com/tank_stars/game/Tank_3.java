package com.tank_stars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tank_3 extends Tank{
    public Tank_3(String n) {
        super(n);
        health=1000;
        tank_image=new Texture(Gdx.files.internal("Helios.png"));
    }
}
