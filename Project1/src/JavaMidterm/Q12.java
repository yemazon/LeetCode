package JavaMidterm;

public class Q12 {
	public static void main(String[] args) {

	    Bengal[] bengals = new Bengal[] {new Bengal("A", "B"), new Bengal("C", "D")};
		Animal[] animals = bengals;
		Wolf[] wolves = (Wolf[]) animals;
		wolves[1] = new Wolf("E");
		bengals[1] = new Bengal("E", "F");
		System.out.printf("Hello %s%n", bengals[1]);
		wolves[1] = new Wolf("Grey thorn");
		System.out.printf("Hello %s%n", wolves[1]);
	}
}