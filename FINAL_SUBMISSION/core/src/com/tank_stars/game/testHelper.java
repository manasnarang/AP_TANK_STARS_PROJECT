package com.tank_stars.game;

import static org.junit.Assert.*;
//import com.javatpoint.logic.*;
import static org.junit.Assert.assertEquals;

import com.tank_stars.game.HelperClass;

import org.junit.Test;

import java.util.ArrayList;

public class testHelper {
    @Test
    public void Test_2d_motion() {
        HelperClass h = new HelperClass();
        ArrayList<Integer> abc=new ArrayList<>();
        abc.add(0);
        abc.add(0);
        assertEquals(abc,h.get_landing_pos(0,0,10,90));

   }
}