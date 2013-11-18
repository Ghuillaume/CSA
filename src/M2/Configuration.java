package M2;

import java.util.ArrayList;
import java.util.Iterator;

import M0.Trace;

public class Configuration {

	ArrayList<Element> components;
	ArrayList<Element> connectors;
	ArrayList<Attachment> attachments;
	ArrayList<Binding> bindings;
	ArrayList<ServiceConfig> servicesRequis;
	ArrayList<ServiceConfig> servicesFournis;
	ArrayList<PortConfig> portsRequis;
	ArrayList<PortConfig> portsFournis;
	
	ArrayList<String> tags;
	
	String name;
	
	
	public Configuration(String name) {
		
		this.name = name;
		this.components = new ArrayList<Element>();
		this.connectors = new ArrayList<Element>();
		this.attachments = new ArrayList<Attachment>();
		this.bindings = new ArrayList<Binding>();
		this.servicesRequis = new ArrayList<ServiceConfig>();
		this.servicesFournis = new ArrayList<ServiceConfig>();
		this.portsRequis = new ArrayList<PortConfig>();
		this.portsFournis = new ArrayList<PortConfig>();
		this.tags = new ArrayList<String>();
	}
	
	public void addComponent(Composant c) {
		if(this.tags.contains(c.getName())) {
			Trace.printError("Tag " + c.getName() + " is not available, component as not been created");
		}
		else {
			this.components.add(c);
			this.tags.add(c.getName());
		}
	}
	
	public void addConnector(Connecteur c) {
		if(this.tags.contains(c.getName())) {
			Trace.printError("Tag " + c.getName() + " is not available, connector as not been created");
		}
		else {
			this.connectors.add(c);
			this.tags.add(c.getName());
		}
	}
	
	public void addService(ServiceConfigFourni sc) {
		if(this.tags.contains(sc.getName())) {
			Trace.printError("Tag " + sc.getName() + " is not available, service as not been created");
		}
		else {
			this.servicesFournis.add(sc);
			this.tags.add(sc.getName());
		}
	}
	
	
	// TODO continuer le check du nom pour tout
	public void addService(ServiceConfigRequis sc) {
		this.servicesRequis.add(sc);
	}
	
	public void addPort(PortConfigFourni pc) {
		this.portsFournis.add(pc);
	}
	
	public void addPort(PortConfigRequis pc) {
		this.portsRequis.add(pc);
	}
	
	// Attach (2)
	
	public Attachment addLink(String name, RoleFrom r, PortFourni p) {
		Attachment a = new Attachment(name, this);
		a.bind(r, p);
		this.attachments.add(a);
		return a;
	}
	
	public Attachment addLink(String name, RoleTo r, PortRequis p) {
		Attachment a = new Attachment(name, this);
		a.bind(r, p);
		this.attachments.add(a);
		return a;
	}
	
	
	// Bindings (4)
	
	public Binding addLink(String name, RoleFrom r, PortConfigFourni p) {
		Binding b = new Binding(name, this);
		b.bind(r, p);
		this.bindings.add(b);
		return b;
	}
	
	public Binding addLink(String name, RoleTo r, PortConfigRequis p) {
		Binding b = new Binding(name, this);
		b.bind(r, p);
		this.bindings.add(b);
		return b;
	}
	
	public Binding addLink(String name, PortConfigRequis pc, PortRequis p) {
		Binding b = new Binding(name, this);
		b.bind(pc, p);
		this.bindings.add(b);
		return b;
	}
	
	public Binding addLink(String name, PortConfigFourni pc, PortFourni p) {
		Binding b = new Binding(name, this);
		b.bind(pc, p);
		this.bindings.add(b);
		return b;
	}
	
	
	// Links management

	public void notifyActivation(Object sender, String message) {		
		ArrayList<Object> receiver = new ArrayList<Object>();
		
		// Find all receiver in attachments list
		Iterator<Attachment> itAttach = this.attachments.iterator();
		while(itAttach.hasNext()) {
			receiver.add(itAttach.next().getReceiver(sender));
		}

		// Find all receiver in bindings list
		Iterator<Binding> itBind = this.bindings.iterator();
		while(itBind.hasNext()) {
			receiver.add(itBind.next().getReceiver(sender));
		}
		
		// Activate all receivers
		
	}
	
}
