package M1.client_server;

import M0.Trace;
import M2.Composant;
import M2.Configuration;
import M2.PortFourni;
import M2.PortRequis;

public class ClientComponent extends Composant {

	public ClientComponent(String name, Configuration config) {
		super(name, config);
		
		config.addComponent(this);
		this.addPort(new SendRequestPort("SendRequest", this));
		this.addPort(new ReceiveAnswerPort("ReceiveAnswer", this));
	}


	public void sendRequest(String message) {
		Trace.printMessage("Client wants to send : " + message);
		((SendRequestPort) this.getPortF("SendRequest")).activate(message);
	}
}
