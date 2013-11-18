package M1.client_server;

import M2.Composant;
import M2.Configuration;
import M2.PortFourni;
import M2.PortRequis;

public class ServerComponent extends Composant {

	public ServerComponent(String name, Configuration config) {
		super(name, config);
		
		config.addComponent(this);
		this.addPort(new AnswerRequestPort("AnswerRequest", this));
		this.addPort(new ReceiveRequestPort("ReceiveRequest", this));
	}

}