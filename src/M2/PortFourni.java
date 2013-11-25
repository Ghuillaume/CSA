package M2;

import M0.Trace;

public class PortFourni extends Port {

	public PortFourni(String name, Composant parent) {
		super(name, parent);
	}

	@Override
	public void activate(String message) {
		Trace.printMessage("In " + this.getParent().getName() + " : "
				+ this.getName() + " (" + this.getClass().getSuperclass().getSimpleName() 
				+ ") received message : " + message);
		
		this.getConfig().callAttachments(this, message);
		this.getConfig().callBindings(this, message);
	}
}
