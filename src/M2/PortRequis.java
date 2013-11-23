package M2;

import M0.Trace;

public class PortRequis extends Port {

	public PortRequis(String name, Composant parent) {
		super(name, parent);
	}
	
	@Override
	public final void activate(String message) {
		Trace.printMessage("In " + this.getParent().getName() + " : "
				+ this.getName() + " (" + this.getClass().getSuperclass().getSimpleName() 
				+ ") received message : " + message);
		
		this.parent.run(this, message);
		this.getConfig().callBindings(this, message);
	}


}
