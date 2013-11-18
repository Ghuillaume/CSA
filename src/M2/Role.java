package M2;

public abstract class Role {

	private String name;
	private Connecteur parent;
	
	public Role(String name, Connecteur parent) {
		this.name = name;
		this.parent = parent;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Connecteur getParent() {
		return this.parent;
	}
}
