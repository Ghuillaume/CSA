package M2;

import java.util.HashMap;

public class Configuration {

	HashMap<String,Element> elements;
	HashMap<String,Attachment> attachments;
	HashMap<String,Binding> bindings;
	HashMap<String,ServiceConfig> services;
	HashMap<String,PortConfig> ports;
	
	String name;
	
	
	public Configuration(String name) {
		
		this.name = name;
		this.elements = new HashMap<String,Element>();
		this.attachments = new HashMap<String,Attachment>();
		this.bindings = new HashMap<String,Binding>();
		this.services = new HashMap<String,ServiceConfig>();
		this.ports = new HashMap<String,PortConfig>();
	}
	
	public void addElement(Element e) {
		this.elements.put(name, e);
	}
	
	public void addService(boolean isFourni, String name) {
		ServiceConfig sc;
		if (isFourni) {
			sc = new ServiceConfigFourni(name);
		} else {
			sc = new ServiceConfigRequis(name);
		}
		this.services.put(name, sc);
	}
	
	public void addPort(boolean isFourni, String name) {
		PortConfig pc;
		if (isFourni) {
			pc = new PortConfigFourni(name);
		} else {
			pc = new PortConfigRequis(name);
		}
		this.ports.put(name, pc);
	}
	
	// Attach (2)
	
	public Attachment addLink(String name, RoleFrom r, PortFourni p) {
		Attachment a = new Attachment(name);
		a.bind(r, p);
		this.attachments.put(name, a);
		return a;
	}
	
	public Attachment addLink(String name, RoleTo r, PortRequis p) {
		Attachment a = new Attachment(name);
		a.bind(r, p);
		this.attachments.put(name, a);
		return a;
	}
	
	
	// Bindings (4)
	
	public Binding addLink(String name, RoleFrom r, PortConfigFourni p) {
		Binding b = new Binding(name);
		b.bind(r, p);
		this.bindings.put(name, b);
		return b;
	}
	
	public Binding addLink(String name, RoleTo r, PortConfigRequis p) {
		Binding b = new Binding(name);
		b.bind(r, p);
		this.bindings.put(name, b);
		return b;
	}
	
	public Binding addLink(String name, PortConfigRequis pc, PortRequis p) {
		Binding b = new Binding(name);
		b.bind(pc, p);
		this.bindings.put(name, b);
		return b;
	}
	
	public Binding addLink(String name, PortConfigFourni pc, PortFourni p) {
		Binding b = new Binding(name);
		b.bind(pc, p);
		this.bindings.put(name, b);
		return b;
	}
	
}
