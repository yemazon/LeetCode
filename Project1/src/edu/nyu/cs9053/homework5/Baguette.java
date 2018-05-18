package edu.nyu.cs9053.homework5;

public class Baguette implements Recipe {

    private double remainingSecondsUntilDone;

    private int ovenTemperature;

    private static final int VOLUME_CUBIC_INCHES = 2000;

    public double decayingTimeCoefficient;

    public Baguette(double decayingTimeCoefficient) {
        if (decayingTimeCoefficient == 0) {
            throw new IllegalArgumentException("decayingTimeCoefficient cannot be null");
        }

        this.decayingTimeCoefficient = decayingTimeCoefficient;
    }

    @Override public void initializeFromOven(Oven oven) {
        if (oven == null) {
            throw new IllegalArgumentException("Oven cannot be null");
        }
        ovenTemperature = oven.getSetTemperature();
        remainingSecondsUntilDone = (-1 / decayingTimeCoefficient) * Math.log(0.01 / ovenTemperature) * 60;
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