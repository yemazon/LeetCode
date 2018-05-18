package edu.nyu.cs9053.homework4.hierarchy;

public class Curler extends WinterSportPlayer {

    private final String country;

    public Curler(String name, int age, String country) {
        super(name, age);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Curler that = (Curler) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (country == null ? that.country == null : country.equals(that.country)) ;
    }

    @Override
    public int hashCode() {
        int result = this.getAge();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }
        if (this.getCountry() != null) {
            result = result * 31 + this.getCountry().hashCode();
        }

        return result;
    }
}
