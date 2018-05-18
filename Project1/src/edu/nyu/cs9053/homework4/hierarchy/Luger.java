package edu.nyu.cs9053.homework4.hierarchy;

public class Luger extends Sledder {

    private final int speedRecord;

    public Luger(String name, int age, String sledColor, int speedRecord) {
        super(name, age, sledColor);
        this.speedRecord = speedRecord;
    }

    public int getSpeedRecord() {
        return speedRecord;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Luger that = (Luger) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (getSledColor() == null ? that.getSledColor() == null : getSledColor().equals(that.getSledColor()))
                && (speedRecord == 0 ? that.speedRecord == 0 : speedRecord == that.speedRecord) ;
    }

    @Override
    public int hashCode() {
        int result = this.getAge();
        result = result * 31 + this.getSpeedRecord();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }
        if (this.getSledColor() != null) {
            result = result * 31 + this.getSledColor().hashCode();
        }

        return result;
    }
}