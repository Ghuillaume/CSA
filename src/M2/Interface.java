package M2;

import M0.Trace;

public abstract class Interface {

	protected String name;
	
	public Interface(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public abstract Configuration getConfig();
	
	public abstract Element getParent();
	
	public abstract void activate(String message);
	
	/*public void notifyIface(String message) {
		Trace.printMessage("In " + this.getParent().getName() + " : "
				+ this.getName() + " (" + this.getClass().getSuperclass().getSimpleName() 
				+ ") received message : " + message);
		
		this.activate(message);
	}*/
}
