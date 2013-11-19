package M2;

public abstract class Service extends Interface {

	protected Composant parent;
	
	public Service(String name, Composant parent) {
		super(name);
		this.parent = parent;
	}
	
	public Composant getParent() {
		return this.parent;
	}
	
	public Configuration getConfig() {
		return this.parent.getParent();
	}
}
