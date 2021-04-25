package com.codecool.gladiator.util;

import java.util.Random;

public class RandomUtils {

    private  final Random RANDOM = new Random();
    private  static RandomUtils instance = null;

    private RandomUtils(){

    }

    public static RandomUtils getInstance(){
        if(instance == null){
            instance = new RandomUtils();
        }
        return instance;
    }

    public Random getRANDOM() {
        return RANDOM;
    }

}
