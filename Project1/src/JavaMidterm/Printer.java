package JavaMidterm;

public class Printer {
	public static void main(String[] args) {
		String parameterValue = System.getenv("param");
		System.out.printf("%s%n", parameterValue);
	}
}