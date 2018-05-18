package JavaMidterm;

public class Child extends Parent {

    private final String something;
	
	public Child(String name, String something) {
		super(name);
		this.something = something;
	}

	public String getSomething() {
		return something;
	}
}