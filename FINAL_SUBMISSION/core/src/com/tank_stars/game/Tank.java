package com.tank_stars.game;

import com.badlogic.gdx.graphics.Texture;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Tank implements Serializable {
    private String name;
    public Tank(String n){
        this.name = n;
    }
    protected int health;
    protected int fuel;
    protected int pos_x;
    protected int pos_y;
    protected Texture tank_image;
    protected ArrayList<String> weapons;

    protected int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected int getFuel() {
        return fuel;
    }

    protected void setFuel(int fuel) {
        this.fuel = fuel;
    }

    protected int getPos_x() {
        return pos_x;
    }

    protected void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    protected int getPos_y() {
        return pos_y;
    }

    protected void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
    protected void fire(){

    }
    public ArrayList<String> get_weapons(){
        return weapons;
    }
    public void mov_forward(int pos_x,int pos_y){
        this.pos_x = this.pos_x + pos_x;
        this.pos_y = this.pos_y + pos_y;

    }
    public void mov_backward(int pos_x,int pos_y){
        this.pos_x = this.pos_x - pos_x;
        this.pos_y = this.pos_y - pos_y;
    }
}
