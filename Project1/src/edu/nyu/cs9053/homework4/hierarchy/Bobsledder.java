package edu.nyu.cs9053.homework4.hierarchy;

public class Bobsledder extends Sledder {

    private final int teammateNumber;

    public Bobsledder(String name, int age, String sledColor, int teammateNumber) {
        super(name, age, sledColor);
        this.teammateNumber = teammateNumber;
    }

    public int getTeammateNumber() {
        return teammateNumber;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Bobsledder that = (Bobsledder) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (getSledColor() == null ? that.getSledColor() == null : getSledColor().equals(that.getSledColor()))
                && (teammateNumber == 0 ? that.teammateNumber == 0 : teammateNumber == that.teammateNumber);
    }

    @Override
    public int hashCode() {
        int result = this.getAge();
        result = result * 31 + this.getTeammateNumber();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }
        if (this.getSledColor() != null) {
            result = result * 31 + this.getSledColor().hashCode();
        }

        return result;
    }
}