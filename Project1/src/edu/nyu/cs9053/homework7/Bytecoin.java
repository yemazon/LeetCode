package edu.nyu.cs9053.homework7;

public class Bytecoin implements Cryptocurrency {

    private double amount;

    public Bytecoin(double amount) {
        this.amount = amount;
    }

    @Override public double getAmount() {
        return amount;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Bytecoin that = (Bytecoin) obj;
        return  (getAmount() == 0d ? that.getAmount() == 0d : getAmount() == that.getAmount());
    }

    @Override public int hashCode() {
        return Double.valueOf(amount).hashCode();
    }
}
