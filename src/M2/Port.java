package M2;


public abstract class Port extends Interface {

	protected Composant parent;
	
	public Port(String name, Composant parent) {
		super(name);
		this.parent = parent;
	}
	
	public Composant getParent() {
		return this.parent;
	}
	
	public Configuration getConfig() {
		return (Configuration)this.parent.getParent();
	}
}
