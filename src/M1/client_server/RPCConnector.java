package M1.client_server;

import M2.Configuration;
import M2.Connecteur;
import M2.PortFourni;
import M2.PortRequis;
import M2.RoleFrom;
import M2.RoleTo;

public class RPCConnector extends Connecteur{

	public RPCConnector(String name, Configuration config) {
		super(name, config);
		
		config.addConnector(this);
		this.addRole(new ServerCallerRole("ServerCaller", this));
		this.addRole(new ClientCallerRole("ClientCaller", this));
		this.addRole(new ServerCalledRole("ServerCalled", this));
		this.addRole(new ClientCalledRole("ClientCalled", this));
	}

}
