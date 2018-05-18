package JavaMidterm;

public class Bear extends Animal {
	
	private final String forest;
	
	private final int salmons;

	public Bear(String name, String forest, int salmons) {
		super(name);
		this.forest = forest;
		this.salmons = salmons;
	}

	//implement equals - use name, forest and salmons
	@Override public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (this.getClass() != obj.getClass()) return false;
		
		Bear bear = (Bear) obj;
		if (this.salmons != bear.salmons) return false;
		if (this.getName() != null ? !this.getName().equals(bear.getName()) : bear.getName() != null) return false;

		if (this.forest != null ? !this.forest.equals(bear.forest) : bear.forest != null) return false;
		return true;
	} 

	@Override public int hashCode() {
		int forestResult = forest != null ? forest.hashCode() : 0;
		int nameResult = this.getName() != null ? this.getName().hashCode() : 0;
		return 31 * (forestResult + nameResult) + salmons;
	}
}