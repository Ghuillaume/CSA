package M2;

import M0.Trace;

public class RoleFrom extends Role {

	public RoleFrom(String name, Connecteur parent) {
		super(name, parent);
	}

	@Override
	public final void activate(String message) {
		Trace.printMessage("In " + this.getParent().getName() + " : "
				+ this.getName() + " (" + this.getClass().getSuperclass().getSimpleName() 
				+ ") received message : " + message);
		
		this.parent.run(this, message);
	}
}
