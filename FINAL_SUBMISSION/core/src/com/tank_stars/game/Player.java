package com.tank_stars.game;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private Tank tank;
    private int health;
    private int fuel;
    private int pos_x;
    private int pos_y;
    private GameClass game;
    private transient int power;
    private transient int angle;
    private String selected_weapon;
    private ArrayList<String> weapons;
    public Player(Tank tank,GameClass game,boolean startOnLeft){
        power=50;
        angle=0;
        this.tank=tank;
        this.game=game;
        health=tank.getHealth();    //different types of tanks have different health
        fuel=100;       //starts at 100 by default
        weapons=new ArrayList<>();
        weapons=this.tank.get_weapons();
        pos_y=20;   //change initial coordinates later
        if(startOnLeft){
            pos_x=20;       //CHANGE THIS LATER
        }
        else{
            pos_x=1260;     //CHANGE LATER
        }
    }
    public void update_health(int damage){
        health-=damage;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }
    public void mov_forward(int x_dist,int y_dist){

    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }


    public int getHealth() {
        return health;
    }


    public void choose_weapon(String weapon){
        selected_weapon=weapon;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public void fire(){
        weapons.remove(selected_weapon);
        selected_weapon="";
        game.weapon_fired(this,power,angle);
    }
}
