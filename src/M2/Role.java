package M2;

public abstract class Role extends Interface {

	protected Connecteur parent;
	
	public Role(String name, Connecteur parent) {
		super(name);
		this.parent = parent;
	}
	
	public Connecteur getParent() {
		return this.parent;
	}
	
	public Configuration getConfig() {
		return this.parent.getParent();
	}
}
