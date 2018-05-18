package edu.nyu.cs9053.homework5;

public class PotRoast implements Recipe {

    private double remainingSecondsUntilDone;

    private int ovenTemperature;

    private static final int VOLUME_CUBIC_INCHES = 10000;

    private static final double BAKING_TIME_COEFFICIENT = 0.2;

    @Override public void initializeFromOven(Oven oven) {
        if (oven == null) {
            throw new IllegalArgumentException("Oven cannot be null");
        }
        ovenTemperature = oven.getSetTemperature();
        remainingSecondsUntilDone = ovenTemperature * BAKING_TIME_COEFFICIENT * 60;
    }

    @Override public int getVolumeCubicInches() {
        return VOLUME_CUBIC_INCHES;
    }

    @Override public Double getRemainingSecondsUntilDone() {
        return remainingSecondsUntilDone;
    }

    @Override public void adjust(Time unit, int amount, int ovenTemperature) {
        int seconds = (unit == Time.Minutes) ? amount * 60 : amount;
        remainingSecondsUntilDone = (remainingSecondsUntilDone - seconds) * this.ovenTemperature / ovenTemperature;
        this.ovenTemperature = ovenTemperature;
    }

    @Override public boolean isRecipeDone() {
        return remainingSecondsUntilDone <= 0;
    }
}
