package Bloomberg;

public class HeightCalculator {
    public static void main(String[] argv) {
//        double i = 308.499128222;
//
//        double result = i * Math.asin(240/i);
//        System.out.print("result " + i + " = " + result + "\n");
//
//        double heightVar = Math.sqrt(result*result - 240.0*240.0);
//        System.out.print("height = " + (result-heightVar));

        System.out.print(getHeight(550, 240,10));

    }

    public static double getHeight(double arc, double string, int precision) {
        double diameter = string+1;
        double i = 0;
        double temp = diameter * Math.asin(480/diameter);

        while(i < precision) {
            double rule = 1 / Math.pow(10,i);
            while (!((temp+rule)>arc && temp<arc)) {
                diameter = diameter + rule;
                temp = diameter * Math.asin(480/diameter);
            }
            diameter = diameter - rule;
            i = i + 1;
            System.out.print(diameter+"\n");
        }
        System.out.print("final dia = " + diameter+"\n");
        double radius = diameter / 2;
        double theta = Math.asin(string/diameter);

        //return radius - radius * Math.cos(theta);
        return radius;
    }
}
