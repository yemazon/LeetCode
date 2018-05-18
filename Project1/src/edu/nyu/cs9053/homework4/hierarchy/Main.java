package edu.nyu.cs9053.homework4.hierarchy;

import edu.nyu.cs9053.homework4.OlympicGame;

public class Main {
    public static void main(String[] args) {
        Bobsledder bobsledder = new Bobsledder(null, 1, null, 0);

        Bobsledder bobsledder1 = new Bobsledder(null,0,null,1);

        Luger luger = new Luger(null,0, null, 0);

        System.out.println("TORF = "+bobsledder.equals(bobsledder1));

        System.out.println(bobsledder.equals(luger));

        System.out.println(bobsledder.hashCode());

        System.out.println(bobsledder1.hashCode());

        OlympicGame[] olympicGameArray = {OlympicGame.I, OlympicGame.II};

        OlympicGame.printHostCountry(olympicGameArray);


    }

}
