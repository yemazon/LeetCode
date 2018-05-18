package Viagogo;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);

        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());

        Event[] events = new Event[numberOfEvents];
        int count = 0;
        while(numberOfEvents > 0){
            String eventLine = scan.nextLine();
            // TODO: you will need to parse and store the events 
            String[] elements = eventLine.split(" ");
            int[] tickets = new int[elements.length - 3];
            for (int i = 0; i < elements.length - 3; i++) {
                tickets[i] = Integer.parseInt(elements[i+3]);
            }
            events[count] = new Event(Integer.parseInt(elements[0]), Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), tickets);
            count++;
            numberOfEvents--;
        }

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        Buyer[] buyers = new Buyer[numberOfBuyers];
        int countBuyer = 0;
        while(numberOfBuyers > 0){
            String buyerLine = scan.nextLine();
            // TODO: you will need to parse and store the buyers
            String[] buyerElements = buyerLine.split(" ");
            buyers[countBuyer] = new Buyer(Integer.parseInt(buyerElements[0]), Integer.parseInt(buyerElements[1]));
            countBuyer++;
            numberOfBuyers--;
        }

        // The solution to the first sample above would be to output the following to console:
        // (Obviously, your solution will need to figure out the output and not just hard code it)
        //System.out.println("2 50");

        for (Buyer buyer : buyers) {
            String result = getLowestEventIDAndPrice(buyer, events);
            System.out.println(result);
            int id = Integer.parseInt(result.split(" ")[0]);
            int price = Integer.parseInt(result.split(" ")[1]);
            events[id].refresh(price);
        }
    }

    // The following method get the manhatten distance betwen two points (x1,y1) and (x2,y2)
    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2)    {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static class Event {
        private int id;
        private int x;
        private int y;
        private int[] ticketsPrice;

        Event(int id, int x, int y, int[] ticketsPrice) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.ticketsPrice = ticketsPrice;
        }

        public int getId() {
            return id;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getLowestTicket() {
            int lowest = ticketsPrice[0];
            for (Integer each : ticketsPrice) {
                if (each <= lowest) {
                    lowest = each;
                }
            }
            return lowest;
        }

        public void refresh(int price) {
            int[] newPrice = new int[ticketsPrice.length-1];
            int index = 0;
            for (int i = 0; i < ticketsPrice.length ; i++) {
                if (ticketsPrice[i] == price) {
                    index = i;
                }
            }

            int j = 0;
            int i = 0;
            while (j < newPrice.length) {
                if (j == index) {
                    j++;
                    continue;
                }
                else {
                    newPrice[i] = ticketsPrice[j];
                    j++;
                    i++;
                }
            }
            ticketsPrice = new int[newPrice.length];
            ticketsPrice = newPrice;
        }
    }

    private static class Buyer {
        private int x;
        private int y;

        Buyer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static String getLowestEventIDAndPrice(Buyer buyer, Event[] events) {
        StringBuilder stringBuilder = new StringBuilder();

        Event nearest = events[0];
        int distance = getDistance(buyer, events[0]);
        int cheapestPrice = events[0].getLowestTicket();
        int id = events[0].id;
        for (Event eachEvent : events) {
            if (getDistance(buyer, eachEvent) < distance) {
                nearest = eachEvent;
                distance = getDistance(buyer, eachEvent);
                cheapestPrice = eachEvent.getLowestTicket();
                id = eachEvent.id;

            } else {
                if (getDistance(buyer, eachEvent) == distance) {
                    if (eachEvent.getLowestTicket() < cheapestPrice) {
                        nearest = eachEvent;
                        cheapestPrice = eachEvent.getLowestTicket();
                        id = eachEvent.id;
                    } else {
                        if (cheapestPrice == eachEvent.getLowestTicket()) {
                            if (eachEvent.id < id) {
                                nearest = eachEvent;
                                id = eachEvent.id;
                            }
                        }
                    }
                }
            }

        }
        stringBuilder.append(id);
        stringBuilder.append(" ");
        stringBuilder.append(cheapestPrice);
        return stringBuilder.toString();
    }

    private static int getDistance(Buyer buyer, Event event) {
        return calculateManhattanDistance(buyer.x, buyer.y, event.x, event.y);
    }

}