package M2;

import M0.Trace;

public class ServiceFourni extends Service {

	public ServiceFourni(String name, Composant parent) {
		super(name, parent);
	}

	@Override
	public void activate(String message) {
		Trace.printMessage("In " + this.getParent().getName() + " : "
				+ this.getName() + " (" + this.getClass().getSuperclass().getSimpleName() 
				+ ") received message : " + message);
		
	}
}
