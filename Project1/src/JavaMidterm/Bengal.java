package JavaMidterm;

public class Bengal extends Tiger {

	private final String location;

	public Bengal(String name, String location) {
		super(name);
		this.location = location;
	}

	@Override public String getName() {
		return super.getName();
	}

	public String getLocation() {
		return this.location;
	}


}