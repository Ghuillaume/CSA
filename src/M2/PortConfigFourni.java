package M2;

import M0.Trace;

public class PortConfigFourni extends PortConfig {

	public PortConfigFourni(String name, Configuration config) {
		super(name, config);
	}
	
	@Override
	public final void activate(String message) {
		Trace.printMessage("In " + this.getParent().getName() + " : "
				+ this.getName() + " (" + this.getClass().getSuperclass().getSimpleName() 
				+ ") received message : " + message);

		this.getConfig().callBindings(this, message);
	}

}
