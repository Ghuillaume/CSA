package M2;

import M0.Trace;

public class RoleTo extends Role {

	public RoleTo(String name, Connecteur parent) {
		super(name, parent);
	}

	@Override
	public final void activate(String message) {
		Trace.printMessage("In " + this.getParent().getName() + " : "
				+ this.getName() + " (" + this.getClass().getSuperclass().getSimpleName() 
				+ ") received message : " + message);
		
		this.getConfig().callBindings(this, message);
		this.getConfig().callAttachments(this, message);
	}
}
