package M2;

import M0.Trace;

public class PortConfigRequis extends PortConfig {

	public PortConfigRequis(String name, Configuration config) {
		super(name, config);
	}

	@Override
	public void activate(String message) {
		Trace.printMessage("In " + this.getParent().getName() + " : "
				+ this.getName() + " (" + this.getClass().getSuperclass().getSimpleName() 
				+ ") received message : " + message);
		
	}
}
