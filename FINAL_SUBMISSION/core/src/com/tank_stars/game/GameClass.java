package com.tank_stars.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GameClass implements Serializable {
    private Player player1;
    private Player player2;
    private ArrayList<Tank> tanks;
    private int turn;       //stores whose turn is it(1 or 2)

    public GameClass(Tank tank1,Tank tank2){
        player1=new Player(tank1,this,true);
        player2=new Player(tank2,this,false);
        tanks=new ArrayList<>();
        turn=1;     //Player 1 starts the game by default
    }

    public void weapon_fired(Player player, int power, int angle){
        int start_x,start_y;
        int enemy_pos_x,enemy_pos_y;
        start_x=player.getPos_x();
        start_y=player.getPos_y();
        int landing_pos_x,landing_pos_y;
        ArrayList<Integer> landing_vals=HelperClass.get_landing_pos(start_x,start_y,power,angle);
        landing_pos_x=landing_vals.get(0);
        landing_pos_y=landing_vals.get(1);
        if(player==this.player1 && turn==1){
            turn=2;
            enemy_pos_x=player2.getPos_x();
            enemy_pos_y=player2.getPos_y();
            if((landing_pos_x>=(enemy_pos_x-10) && landing_pos_x<=(enemy_pos_x+10)) && (landing_pos_y>=(enemy_pos_y-10) && landing_pos_y<=(enemy_pos_y+10))){
                player2.update_health(10);
                player2.mov_forward(20,20);     //change later
            }
        }
        else if(player==this.player2 && turn==2){
            turn=1;
            enemy_pos_x=player1.getPos_x();
            enemy_pos_y=player1.getPos_y();

            if((landing_pos_x>=(enemy_pos_x-10) && landing_pos_x<=(enemy_pos_x+10)) && (landing_pos_y>=(enemy_pos_y-10) && landing_pos_y<=(enemy_pos_y+10))){
                player1.update_health(10);
                player1.mov_forward(20,20);     //change later
            }
        }
    }
    public void start_game(){

    }
    public void resume_game(){
        Iterator iter = tanks.iterator();
        while (iter.hasNext()){
        }
    }
    public void exit(){

    }
    public void choose_tank(){

    }

}
