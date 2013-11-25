package M1.server_details;

import M1.client_server.ClientComponent;
import M2.Configuration;

public class ServerDetailsConfiguration extends Configuration {

	public ServerDetailsConfiguration(String name) {
		super(name);
		
		this.addPort(new AnswerRequestConf("AnswerRequestPortConfig", this));
		this.addPort(new ReceiveRequestConf("ReceiveRequestPortConfig", this));
	}

	public void build() {

		// Component
		ConnexionManagerComponent connexionManager = new ConnexionManagerComponent("ConnexionManager", this);
	}
}
