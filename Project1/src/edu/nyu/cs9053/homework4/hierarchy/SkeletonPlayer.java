package edu.nyu.cs9053.homework4.hierarchy;

public class SkeletonPlayer extends Sledder {

    private final int runningSpeed;

    public SkeletonPlayer(String name, int age, String sledColor, int runningSpeed) {
        super(name, age, sledColor);
        this.runningSpeed = runningSpeed;
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        SkeletonPlayer that = (SkeletonPlayer) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (getSledColor() == null ? that.getSledColor() == null : getSledColor().equals(that.getSledColor()))
                && (runningSpeed == 0 ? that.runningSpeed == 0 : runningSpeed == that.runningSpeed) ;
    }

    @Override
    public int hashCode() {
        int result = this.getAge();
        result = result * 31 + this.getRunningSpeed();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }
        if (this.getSledColor() != null) {
            result = result * 31 + this.getSledColor().hashCode();
        }

        return result;
    }
}