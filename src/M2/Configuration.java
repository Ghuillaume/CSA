package M2;

import java.util.HashMap;

public class Configuration {

	HashMap<String,Element> components;
	HashMap<String,Element> connectors;
	HashMap<String,Attachment> attachments;
	HashMap<String,Binding> bindings;
	HashMap<String,ServiceConfig> servicesRequis;
	HashMap<String,ServiceConfig> servicesFournis;
	HashMap<String,PortConfig> portsRequis;
	HashMap<String,PortConfig> portsFournis;
	
	String name;
	
	
	public Configuration(String name) {
		
		this.name = name;
		this.components = new HashMap<String,Element>();
		this.connectors = new HashMap<String,Element>();
		this.attachments = new HashMap<String,Attachment>();
		this.bindings = new HashMap<String,Binding>();
		this.servicesRequis = new HashMap<String,ServiceConfig>();
		this.servicesFournis = new HashMap<String,ServiceConfig>();
		this.portsRequis = new HashMap<String,PortConfig>();
		this.portsFournis = new HashMap<String,PortConfig>();
	}
	
	public void addComponent(Composant c) {
		this.components.put(c.getName(), c);
	}
	
	public void addConnector(Connecteur c) {
		this.connectors.put(c.getName(), c);
	}
	
	public void addService(ServiceConfigFourni sc) {
		this.servicesFournis.put(sc.getName(), sc);
	}
	
	public void addService(ServiceConfigRequis sc) {
		this.servicesRequis.put(sc.getName(), sc);
	}
	
	public void addPort(PortConfigFourni pc) {
		this.portsFournis.put(name, pc);
	}
	
	public void addPort(PortConfigRequis pc) {
		this.portsRequis.put(name, pc);
	}
	
	// Attach (2)
	
	public Attachment addLink(String name, RoleFrom r, PortFourni p) {
		Attachment a = new Attachment(name, this);
		a.bind(r, p);
		this.attachments.put(name, a);
		return a;
	}
	
	public Attachment addLink(String name, RoleTo r, PortRequis p) {
		Attachment a = new Attachment(name, this);
		a.bind(r, p);
		this.attachments.put(name, a);
		return a;
	}
	
	
	// Bindings (4)
	
	public Binding addLink(String name, RoleFrom r, PortConfigFourni p) {
		Binding b = new Binding(name, this);
		b.bind(r, p);
		this.bindings.put(name, b);
		return b;
	}
	
	public Binding addLink(String name, RoleTo r, PortConfigRequis p) {
		Binding b = new Binding(name, this);
		b.bind(r, p);
		this.bindings.put(name, b);
		return b;
	}
	
	public Binding addLink(String name, PortConfigRequis pc, PortRequis p) {
		Binding b = new Binding(name, this);
		b.bind(pc, p);
		this.bindings.put(name, b);
		return b;
	}
	
	public Binding addLink(String name, PortConfigFourni pc, PortFourni p) {
		Binding b = new Binding(name, this);
		b.bind(pc, p);
		this.bindings.put(name, b);
		return b;
	}
	
}
