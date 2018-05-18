package JavaMidterm;

public class QQ4 {
	public static void main(String[] args) {
		Boolean value = (args == null ? false : getBoolean(args));
		System.out.printf("Arg? %s%n", (value == null ? "<null>" : String.valueOf(value)));
	}

	private static Boolean getBoolean(String[] args) {
		if ((args.length < 1) || "null".equals(args[0])) {
			return null;
		}
		return Boolean.parseBoolean(args[0]);
	}
}