package com.sanpal;

import com.sanpal.read.ReadSource;

public class Launch {


    public static void main (String args[]) {

        ReadSource readSource = new ReadSource();
        //String text = readSource.readText("data/macro.txt");
        String test = readSource.changeBatParameters("src/com/sanpal/read/data/bat.txt","rsanchez", "password1234", "Macro123.mac");
        System.out.println(test);
    }
}
