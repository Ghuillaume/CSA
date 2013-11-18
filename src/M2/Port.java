package M2;

import M0.Trace;

public abstract class Port {

	private String name;
	private Composant parent;
	
	public Port(String name, Composant parent) {
		this.name = name;
		this.parent = parent;
	}

	public void activate(String message) {
		Trace.printMessage("Port " + this.getName() + " received message : " + message);		
		this.parent.getParent().notifyActivation(this, message);
	}

	public String getName() {
		return this.name;
	}
	
	public Composant getParent() {
		return this.parent;
	}
}
