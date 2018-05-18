package edu.nyu.cs9053.homework4.hierarchy;

public class MogulSkier extends Skier {

    private final String mogulType;

    public MogulSkier(String name, int age, int skiLength, String mogulType) {
        super(name, age, skiLength);
        this.mogulType = mogulType;
    }

    public String getMogulType() {
        return mogulType;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        MogulSkier that = (MogulSkier) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (getSkiLength() == 0 ? that.getSkiLength() == 0 : getSkiLength() == that.getSkiLength())
                && (mogulType == null ? that.mogulType == null : mogulType.equals(that.mogulType));
    }

    @Override
    public int hashCode() {
        int result = this.getAge();
        result = result * 31 + this.getSkiLength();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }
        if (this.getMogulType() != null) {
            result = result * 31 + this.getMogulType().hashCode();
        }

        return result;
    }
}