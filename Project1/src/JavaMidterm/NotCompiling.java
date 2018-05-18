package JavaMidterm;

public class NotCompiling {
	private int value;
	
	public int getValue(int decrement) {
		int value = 0;
		return (value - decrement);
	}
	
	public int getValue(boolean increment) {
		int value = 0;
		return (increment ? (value + 1) : (value) - 1);
	}
}