package M2;

import java.util.ArrayList;
import java.util.Iterator;

import M0.Trace;

public class Configuration extends Element {

	private ArrayList<Composant> components;
	private ArrayList<Connecteur> connectors;
	private ArrayList<Attachment> attachments;
	private ArrayList<Binding> bindings;
	private ArrayList<ServiceConfig> servicesRequis;
	private ArrayList<ServiceConfig> servicesFournis;
	private ArrayList<PortConfig> portsRequis;
	private ArrayList<PortConfig> portsFournis;
	
	private ArrayList<String> tags;
	
	
	
	public Configuration(String name) {
		super(name);
		
		this.components = new ArrayList<Composant>();
		this.connectors = new ArrayList<Connecteur>();
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
	
	
	public void addService(ServiceConfigRequis sc) {
		if(this.tags.contains(sc.getName())) {
			Trace.printError("Tag " + sc.getName() + " is not available, service as not been created");
		}
		else {
			this.servicesRequis.add(sc);
			this.tags.add(sc.getName());
		}
	}
	
	public void addPort(PortConfigFourni pc) {
		if(this.tags.contains(pc.getName())) {
			Trace.printError("Tag " + pc.getName() + " is not available, service as not been created");
		}
		else {
			this.portsFournis.add(pc);
			this.tags.add(pc.getName());
		}
	}
	
	public void addPort(PortConfigRequis pc) {
		if(this.tags.contains(pc.getName())) {
			Trace.printError("Tag " + pc.getName() + " is not available, service as not been created");
		}
		else {
			this.portsRequis.add(pc);
			this.tags.add(pc.getName());
		}
	}
	
	// Attach (2)
	
	public Attachment addLink(String name, RoleFrom r, PortFourni p) {
		Attachment a = null;
		if(this.tags.contains(name)) {
			Trace.printError("Tag " + name + " is not available, service as not been created");
		}
		else {
			a = new Attachment(name, this);
			a.bind(r, p);
			this.attachments.add(a);
			this.tags.add(a.getName());
		}
		return a;
	}
	
	public Attachment addLink(String name, RoleTo r, PortRequis p) {
		Attachment a = null;
		if(this.tags.contains(name)) {
			Trace.printError("Tag " + name + " is not available, service as not been created");
		}
		else {
			a = new Attachment(name, this);
			a.bind(r, p);
			this.attachments.add(a);
			this.tags.add(a.getName());
		}
		return a;
	}
	
	
	// Bindings (4)
	
	public Binding addLink(String name, RoleFrom r, PortConfigFourni p) {
		Binding b = null;

		if(this.tags.contains(name)) {
			Trace.printError("Tag " + name + " is not available, service as not been created");
		}
		else {
			b = new Binding(name, this);
			b.bind(r, p);
			this.bindings.add(b);
			this.tags.add(b.getName());
		}
		return b;
	}
	
	public Binding addLink(String name, RoleTo r, PortConfigRequis p) {
		Binding b = null;

		if(this.tags.contains(name)) {
			Trace.printError("Tag " + name + " is not available, service as not been created");
		}
		else {
			b = new Binding(name, this);
			b.bind(r, p);
			this.bindings.add(b);
			this.tags.add(b.getName());
		}
		return b;
		
	}
	
	public Binding addLink(String name, PortConfigRequis pc, PortRequis p) {
		Binding b = null;

		if(this.tags.contains(name)) {
			Trace.printError("Tag " + name + " is not available, service as not been created");
		}
		else {
			b = new Binding(name, this);
			b.bind(pc, p);
			this.bindings.add(b);
			this.tags.add(b.getName());
		}
		return b;
	}
	
	public Binding addLink(String name, PortConfigFourni pc, PortFourni p) {
		Binding b = null;

		if(this.tags.contains(name)) {
			Trace.printError("Tag " + name + " is not available, service as not been created");
		}
		else {
			b = new Binding(name, this);
			b.bind(pc, p);
			this.bindings.add(b);
			this.tags.add(b.getName());
		}
		return b;
	}
	
	
	// Links management
	
	public void callAttachments(Interface sender, String message) {

		ArrayList<Interface> receiver = new ArrayList<Interface>();
		
		// Find all receiver in attachments list
		Iterator<Attachment> itAttach = this.attachments.iterator();
		while(itAttach.hasNext()) {
			Interface dest = itAttach.next().getReceiver(sender);
			if(dest != null) {
				receiver.add(dest);
			}
		}
		
		// Activate all receivers
		Iterator<Interface> itIface = receiver.iterator();
		while(itIface.hasNext()) {
			Interface dest = itIface.next();
			dest.activate(message);
		}
	}
	
	public void callBindings(Object sender, String message) {

		ArrayList<Interface> receiver = new ArrayList<Interface>();
		
		// Find all receiver in attachments list
		Iterator<Binding> itBind = this.bindings.iterator();
		while(itBind.hasNext()) {
			receiver.add(itBind.next().getReceiver(sender));
		}
		
		// Activate all receivers
		Iterator<Interface> itIface = receiver.iterator();
		while(itIface.hasNext()) {
			itIface.next().activate(message);
		}
	}

}
