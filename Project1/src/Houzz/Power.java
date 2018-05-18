package Houzz;

public class Power {
    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.power(5,8)== power.binaryPower(5,8) ? 1: 0);
    }

    private int power(int a, int b) {
        if (b == 0) {
            return 1;
        }

        int res = 1;
        while (b > 0) {
            res = res * a;
            b--;
        }
        return res;
    }
    private int binaryPower(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        if (b % 2 == 0) {
            return binaryPower(a,b/2) * binaryPower(a,b/2);
        }
        return binaryPower(a,b/2) * binaryPower(a,b/2) * a;
    }
}
