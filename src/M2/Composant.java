package M2;

import java.util.HashMap;



public class Composant extends Element {

	private HashMap<String,ServiceRequis> servicesR;
	private HashMap<String,ServiceFourni> servicesF;
	private HashMap<String,PortRequis> portsR;
	private HashMap<String,PortFourni> portsF;
	

	public Composant(String name, Configuration parent) {
		super(name, parent);
		this.servicesR = new HashMap<String,ServiceRequis>();
		this.servicesF = new HashMap<String,ServiceFourni>();
		this.portsR = new HashMap<String,PortRequis>();
		this.portsF = new HashMap<String,PortFourni>();
	}

	public void addService(ServiceFourni s) {
		this.servicesF.put(s.getName(), s);
	}

	public void addService(ServiceRequis s) {
		this.servicesR.put(s.getName(), s);
	}
	
	public void addPort(PortFourni p) {
		this.portsF.put(p.getName(), p);
	}
	
	public void addPort(PortRequis p) {
		this.portsR.put(p.getName(), p);
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
