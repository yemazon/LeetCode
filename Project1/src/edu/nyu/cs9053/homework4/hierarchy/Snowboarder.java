package edu.nyu.cs9053.homework4.hierarchy;

public class Snowboarder extends WinterSportPlayer {

    private final int boardLength;

    public Snowboarder(String name, int age, int boardLength) {
        super(name, age);
        this.boardLength = boardLength;
    }

    public int getBoardLength() {
        return boardLength;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Snowboarder that = (Snowboarder) obj;
        return  (getName() == null ? that.getName() == null : getName().equals(that.getName()))
                && (getAge() == 0 ? that.getAge() == 0 : getAge() == that.getAge())
                && (boardLength == 0 ? that.boardLength == 0 : boardLength == that.boardLength);
    }

    @Override
    public int hashCode() {
        int result = this.getAge();
        result = result * 31 + this.getBoardLength();

        if (this.getName() != null) {
            result = result * 31 + this.getName().hashCode();
        }

        return result;
    }
}
