package edu.nyu.cs9053.homework4;

public enum OlympicGame {

    I ("France"),
    II ("Switzerland"),
    III ("United States"),
    IV ("Germany"),
    V ("Switzerland"),
    VI ("Norway"),
    VII ("Italy"),
    VIII ("United States"),
    IX ("Austria"),
    X ("France"),
    XI ("Japan"),
    XII ("Austria"),
    XIII ("United States"),
    XIV ("Yugoslavia"),
    XV ("Canada"),
    XVI ("France"),
    XVII ("Norway"),
    XVIII ("Japan"),
    XIX ("United States"),
    XX ("Italy"),
    XXI ("Canada"),
    XXII ("Russia"),
    XXIII ("South Korea");

    private OlympicGame(String hostCountry) {
        this.hostCountry = hostCountry;
    }

    private final String hostCountry;

    public String getHostCountry() {
        return hostCountry;
    }

    public static void printHostCountry(OlympicGame ... olympicGames) {
        for (OlympicGame olympicGame : olympicGames) {
            System.out.println(olympicGame.getHostCountry());
        }
    }
}