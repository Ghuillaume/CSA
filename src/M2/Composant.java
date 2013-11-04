package M2;

import java.util.LinkedList;



public class Composant extends Element {

	LinkedList<Service> services;
	LinkedList<Port> ports;
	

	public Composant(String name) {
		super(name);
		
		this.services = new LinkedList<Service>();
		this.ports = new LinkedList<Port>();
	}


	
	public void addService(boolean isFourni, String name) {
		Service sc;
		if (isFourni) {
			sc = new ServiceFourni(name);
		} else {
			sc = new ServiceRequis(name);
		}
		this.services.add(sc);
	}
	
	public void addPort(boolean isFourni, String name) {
		Port pc;
		if (isFourni) {
			pc = new PortFourni(name);
		} else {
			pc = new PortRequis(name);
		}
		this.ports.add(pc);
	}

}
