package M2;

public class Test {

	public static void main(String[] args) {

		Configuration config = new Configuration("Test config");
		
		// Server
		Composant server = new Composant("Serveur");
		server.addPort(false, "ReceiveRequest");
		config.addElement(server);
		
		
		// Client
		Composant client = new Composant("Client");
		client.addPort(true, "SendRequest");
		config.addElement(client);
		
		
		// Connector
		Connecteur RPC = new Connecteur("RPC");
		RPC.addRole(true, "clientCaller");
		RPC.addRole(false, "serverCalled");
		config.addElement(RPC);
		
		
		// Binds
		config.addLink("ClientToRPC", RPC.getRoleTo("serverCalled"), server.getPortR("ReceiveRequest"));
		config.addLink("RPCToServer", RPC.getRoleFrom("clientCaller"), client.getPortF("SendRequest"));
	}

}
