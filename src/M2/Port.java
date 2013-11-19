package M2;

import M0.Trace;

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
		return this.parent.getParent();
	}
}
