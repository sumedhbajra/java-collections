package com.sumedhbajra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        String[] ex1 = {"aa", "bb", "cc", "dd"};
////        ArrayList<String> a1 = new ArrayList<>(List.of(ex1));
//        ArrayList<String> a1 = new ArrayList<>(Arrays.asList(ex1));
//
//        for(String i: a1) {
//            System.out.println(i);
//        }
//
//        System.out.println("--------------------");
//        LinkedList<String> a2 = new LinkedList<>(Arrays.asList(ex1));
//
//        for(String i: a2) {
//            System.out.println(i);
//        }

        Theatre theatre = new Theatre("Olympian", 8, 12);
//        theatre.getSeats();
        if(theatre.reserveSeat("B13")) {
            System.out.println("Please Pay");
        } else {
            System.out.println("Sorry. seat is taken");
        }

//        if(theatre.reserveSeat("H11")) {
//            System.out.println("Please Pay");
//        } else {
//            System.out.println("Sorry. seat is taken");
//        }

//        System.out.println("compareToIgnoreCase: " + "h11".compareToIgnoreCase("1"));
    }
}