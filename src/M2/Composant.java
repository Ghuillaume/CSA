package M2;

import java.util.HashMap;



public class Composant extends Element {

	HashMap<String,ServiceRequis> servicesR;
	HashMap<String,ServiceFourni> servicesF;
	HashMap<String,PortRequis> portsR;
	HashMap<String,PortFourni> portsF;
	Configuration configuration;
	

	public Composant(String name) {
		super(name);
		this.configuration = null;
		this.servicesR = new HashMap<String,ServiceRequis>();
		this.servicesF = new HashMap<String,ServiceFourni>();
		this.portsR = new HashMap<String,PortRequis>();
		this.portsF = new HashMap<String,PortFourni>();
	}

	public void addConfiguration(Configuration config) {
		this.configuration = config;
	}
	
	public void addService(boolean isFourni, String name) {
		if (isFourni) {
			this.servicesF.put(name, new ServiceFourni(name));
		} else {
			this.servicesR.put(name, new ServiceRequis(name));
		}
	}
	
	public void addPort(boolean isFourni, String name) {
		if (isFourni) {
			this.portsF.put(name, new PortFourni(name));
		} else {
			this.portsR.put(name, new PortRequis(name));
		}
	}

	public PortRequis getPortR(String name) {
		return this.portsR.get(name);
	}
	
	public PortFourni getPortF(String name) {
		return this.portsF.get(name);
	}

	public ServiceRequis getServiceR(String name) {
		return this.servicesR.get(name);
	}

	public ServiceFourni getServiceF(String name) {
		return this.servicesF.get(name);
	}

}
