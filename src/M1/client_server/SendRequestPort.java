package M1.client_server;

import M0.Trace;
import M2.Composant;
import M2.PortFourni;

public class SendRequestPort extends PortFourni {

	public SendRequestPort(String name, Composant parent) {
		super(name, parent);
	}
	
	public void sendRequest(String message) {
		Trace.printMessage("Port " + this.getName() + " send request " + message);
	}

}
