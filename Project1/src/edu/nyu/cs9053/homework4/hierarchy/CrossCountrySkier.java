package edu.nyu.cs9053.homework4.hierarchy;

public class CrossCountrySkier extends Skier {

    private final String locomotion;

    public CrossCountrySkier(String name, int age, int skiLength, String locomotion) {
        super(name, age, skiLength);
        this.locomotion = locomotion;
    }

    public String getLocomotion() {
        return locomotion;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        CrossCountrySkier that = (CrossCountrySkier) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (getSkiLength() == 0 ? that.getSkiLength() == 0 : getSkiLength() == that.getSkiLength())
                && (locomotion == null ? that.locomotion == null : locomotion.equals(that.locomotion));
    }

    @Override
    public int hashCode() {
        int result = this.getAge();
        result = result * 31 + this.getSkiLength();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }
        if (this.getLocomotion() != null) {
            result = result * 31 + this.getLocomotion().hashCode();
        }

        return result;
    }
}