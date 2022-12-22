package com.tank_stars.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Tank_1 extends Tank{

    public Tank_1(String n) {
        super(n);
        health=800;
        tank_image=new Texture(Gdx.files.internal("Abrams.png"));
        weapons=new ArrayList<String>();
        weapons.add("Weapon1");
        weapons.add("Weapon2");
        weapons.add("Weapon3");
        weapons.add("Weapon4");
        weapons.add("Weapon5");
    }

}
