package edu.nyu.cs9053.homework4.hierarchy;

public class FigureSkater extends IceSkater {

    private final String discipline;

    public FigureSkater(String name, int age, int skateSize, String discipline) {
        super(name, age, skateSize);
        this.discipline = discipline;
    }

    public String getDiscipline() {
        return discipline;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        FigureSkater that = (FigureSkater) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (getSkateSize() == 0 ? that.getSkateSize() == 0 : getSkateSize() == that.getSkateSize())
                && (discipline == null ? that.discipline == null : discipline.equals(that.discipline)) ;
    }

    @Override
    public int hashCode() {
        int result = this.getAge();
        result = result * 31 + this.getSkateSize();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }
        if (this.getDiscipline() != null) {
            result = result * 31 + this.getDiscipline().hashCode();
        }

        return result;
    }
}