package M0;

import M1.client_server.*;
import M1.server_details.*;
import M2.*;

public class Application {

	public static void main(String[] args) {
		
		
		// MAIN CONFIGURATION
		ClientServerConfiguration mainConfig = new ClientServerConfiguration("Client-Server-Config");
		mainConfig.build();
		
		
		// SERVER DETAILS CONFIGURATION
		ServerDetailsConfiguration serverConfig = new ServerDetailsConfiguration("Server-details-Config");
		serverConfig.setParent(mainConfig.getComposant("Server"));
		mainConfig.getComposant("Server").setSubconf(serverConfig);
		
		
		// RUNNING THE APPLICATION
		mainConfig.getComposant("Client").getServiceF("SendRequestService").activate("test");

		
		// Bindings
		mainConfig.addLink("ServerToSubConf", serverConfig.getPortR("ReceiveRequestPortConfig"), mainConfig.getComposant("Server").getPortR("ReceiveRequest"));
		mainConfig.addLink("SubConfToServer", serverConfig.getPortR("AnswerRequestPortConfig"), mainConfig.getComposant("Server").getPortR("AnswerRequest"));
	}

}
