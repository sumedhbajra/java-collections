package com.sumedhbajra;

import java.util.*;
/**
 * Requirements -> So I need a class that would create
 * me a number of object when provided input data.
 * Those created object should hold unique data like no. and boolean.
 * getTheaterName, getSeats, reserveSeats
 * return boolean approach for reserving seats - system providing data.
 *
 *
 * */
public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };
                                        //A-Z
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows-1); // ??
        // ??
        for(char row = 'A'; row <= lastRow; row++) {
            // TEST
//                System.out.println("Row: " + row);
            // TEST
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if (row > 'F' || (seatNum < 4 || seatNum > 9) ) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
//        System.out.println("SEAT COUNT: " + seats.size());
        int foundSeat = Collections.binarySearch(seats,  requestedSeat,null);
//        System.out.println("seatNumber: " + seatNumber);
//        System.out.println("requestedSeat: " + requestedSeat);
//        System.out.println("Found Seat: " + foundSeat);
//        Seat s1 = Collections.min(seats);
//        System.out.println("printing s1: " + s1);
        if(foundSeat >= 0) {
//            System.out.println("seats.get(foundSeat): " + seats.get(foundSeat));
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

    //        for(Seat seat: seats) {
    //            System.out.print(".");
    //            if(seat.getSeatNumber().equals(seatNumber)) {
    //                requestedSeat = seat;
    //                break;
    //            }
    //        }
    //
    //        if(requestedSeat == null) {
    //            System.out.println("There is no seat " + seatNumber);
    //            return false;
    //        }
    //
    //        return requestedSeat.reserve();
    }

    // for testing
    public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled.");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public String toString() {
            return "Seat{" +
                    "seatNumber='" + seatNumber + '\'' +
                    ", reserved=" + reserved +
                    '}';
        }
    }
}