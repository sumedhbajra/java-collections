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

        Scanner scanner = new Scanner(System.in);

        /**
         *  Locations: {
         *      l1: { id: 1,
         *            location: {   lid: 1,
         *                          des:"abc"
         *                          exits: []
         *                      }
         *          },
         *       ...[]
         *
         *
         * */

        /**
         * Change the program to allow players to type full words, or phrases, then move to the
         * correct location based upon their input.
         * The player should be able to type commands such as "Go West", "run South", or just "East"
         * and the program will move to the appropriate location if there is one. As at present, an
         * attempt to move in an invalid direction should print a message and remain in the same place.
         *
         * Single letter commands (N,S,E,W,Q) should still be available. 
         * */

        locations.put(0, new Location(0 , "You are sitting in front of a computer learning java.") );
        locations.put(1, new Location( 1, "You are standing at the end of a road before a small bridge.") );
        locations.put(2, new Location( 2, "You are at the top of a hill.") );
        locations.put(3, new Location( 3, "You are inside a building, a well house for a small sprit") );
        locations.put(4, new Location( 4, "You are in a valley beside a stream") );
        locations.put(5, new Location( 5, "You are in the forest.") );

        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("N",5);

        locations.get(2).addExit("N",5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N",1);
        locations.get(4).addExit("W",2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }

            String direction = scanner.nextLine().toUpperCase();

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }

//            loc = scanner.nextInt();
//            if(!locations.containsKey(loc)) {
//                System.out.println("You cannot go in that direction");
//                break;
//            }

//            String[] road = "You are standing at the end of a road before a small brick building".split(" ");
//            for(String i: road) {
//                System.out.println(i);
//            }
//
//            System.out.println("=============================");
//
//            String[] building = "You are inside a building, a well house for a small spring".split(", ");
//            for (String i: building) {
//                System.out.println(i);
//            }
    }
}