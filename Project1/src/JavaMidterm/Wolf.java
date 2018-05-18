package JavaMidterm;

public class Wolf extends Animal {
	public Wolf(String name) {
		super(name);
	}

	public String getName(String greeeting) {
		return greeeting + " " + super.getName();
	}
}