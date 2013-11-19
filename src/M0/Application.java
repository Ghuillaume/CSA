package M0;

import M1.client_server.*;
import M1.server_details.*;
import M2.*;

public class Application {

	public static void main(String[] args) {
		
		// Config
		ClientServerConfiguration mainConfig = new ClientServerConfiguration("Client-Server-Config");
		
		// Components
		ClientComponent client = new ClientComponent("Client", mainConfig);
		ServerComponent server = new ServerComponent("Server", mainConfig);
		
		// Server
		RPCConnector RPC = new RPCConnector("RPC", mainConfig);
		
		// Attachments
		mainConfig.addLink("ClientToRPC", RPC.getRoleFrom("ClientCaller"), client.getPortF("SendRequest"));
		mainConfig.addLink("RPCToClient", RPC.getRoleTo("ClientCalled"), client.getPortR("ReceiveAnswer"));
		mainConfig.addLink("ServerToRPC", RPC.getRoleFrom("ServerCaller"), server.getPortF("AnswerRequest"));
		mainConfig.addLink("RPCToServer", RPC.getRoleTo("ServerCalled"), server.getPortR("ReceiveRequest"));
		
		// Request
		client.sendRequest("test");
		
	}

}
