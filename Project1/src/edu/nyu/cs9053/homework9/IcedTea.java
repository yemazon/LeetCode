package edu.nyu.cs9053.homework9;

public class IcedTea implements CoffeeDrink {

    @Override public boolean isDecaf() {
        return true;
    }

    @Override public boolean containsMilk() {
        return false;
    }
}
