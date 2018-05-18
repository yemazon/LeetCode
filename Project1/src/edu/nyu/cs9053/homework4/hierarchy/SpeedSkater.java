package edu.nyu.cs9053.homework4.hierarchy;

public class SpeedSkater extends IceSkater {

    private final int averageSpeed;

    public SpeedSkater(String name, int age, int skateSize, int averageSpeed) {
        super(name, age, skateSize);
        this.averageSpeed = averageSpeed;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        SpeedSkater that = (SpeedSkater) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (getSkateSize() == 0 ? that.getSkateSize() == 0 : getSkateSize() == that.getSkateSize())
                && (averageSpeed == 0 ? that.averageSpeed == 0 : averageSpeed == that.averageSpeed);
    }

    @Override
    public int hashCode() {
        int result = this.getAge();
        result = result * 31 + this.getSkateSize();
        result = result * 31 + getAverageSpeed();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }

        return result;
    }
}