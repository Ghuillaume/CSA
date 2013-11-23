package M1.server_details;

import M2.Configuration;
import M2.PortConfigFourni;
import M2.PortConfigRequis;

public class ServerDetailsConfiguration extends Configuration {

	public ServerDetailsConfiguration(String name) {
		super(name);
		
		this.addPort(new PortConfigFourni("AnswerRequestPortConfig", this));
		this.addPort(new PortConfigRequis("ReceiveRequestPortConfig", this));
	}

	public void build() {

	}
}
