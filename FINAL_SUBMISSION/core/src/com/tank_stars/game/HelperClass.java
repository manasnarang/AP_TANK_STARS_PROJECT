package com.tank_stars.game;

import java.util.ArrayList;

public class HelperClass {
    public static ArrayList<Integer> get_landing_pos(int start_x,int start_y, int power, int angle){
        int g=10;
        int landing_pos_x,landing_pos_y;
        double radian = Math.toRadians(angle);
        double cos_angle = Math.cos(radian);
        double sin_angle = Math.sin(radian);

        int time = (int) (2*power*sin_angle)/g;

        landing_pos_x = (int) (start_x + power*cos_angle*time);
        landing_pos_y =(int) (start_y + (power*sin_angle*time) - (1/2)*g*Math.pow(time,2));
        ArrayList<Integer> landing_pos=new ArrayList<>();
        landing_pos.add(landing_pos_x);
        landing_pos.add(landing_pos_y);
        return landing_pos;
    }
}
