package M2;

public abstract class Port {

	private String name;
	private Composant parent;
	
	public Port(String name, Composant parent) {
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return this.name;
	}
	
	public Composant getParent() {
		return this.parent;
	}
}
