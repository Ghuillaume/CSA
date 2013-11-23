package M0;

import M1.client_server.ClientServerConfiguration;
import M1.server_details.ServerDetailsConfiguration;

public class Application {

	public static void main(String[] args) {
		
		
		// MAIN CONFIGURATION
		ClientServerConfiguration mainConfig = new ClientServerConfiguration("Client-Server-Config");
		mainConfig.build();
		
		
		// SERVER DETAILS CONFIGURATION
		ServerDetailsConfiguration serverConfig = new ServerDetailsConfiguration("Server-details-Config");
		serverConfig.setParent(mainConfig.getComposant("Server"));
		mainConfig.getComposant("Server").setSubconf(serverConfig);

		
		// Bindings
		mainConfig.addLink("ServerToSubConf", serverConfig.getPortR("ReceiveRequestPortConfig"), mainConfig.getComposant("Server").getPortR("ReceiveRequest"));
		mainConfig.addLink("SubConfToServer", serverConfig.getPortF("AnswerRequestPortConfig"), mainConfig.getComposant("Server").getPortF("AnswerRequest"));
		
		
		// RUNNING THE APPLICATION
		mainConfig.getComposant("Client").getServiceF("SendRequestService").activate("test");
	}

}
