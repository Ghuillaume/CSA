package M2;

import java.util.Iterator;
import java.util.LinkedList;

public class Configuration {

	LinkedList<Element> elements;
	LinkedList<Attachment> attachments;
	LinkedList<Binding> bindings;
	LinkedList<ServiceConfig> services;
	LinkedList<PortConfig> ports;
	
	String name;
	
	
	public Configuration(String name) {
		
		this.name = name;
		this.elements = new LinkedList<Element>();
		this.attachments = new LinkedList<Attachment>();
		this.bindings = new LinkedList<Binding>();
		this.services = new LinkedList<ServiceConfig>();
		this.ports = new LinkedList<PortConfig>();
	}
	
	public void addElement(Element e) {
		this.elements.add(e);
	}
	
	public void addService(boolean isFourni, String name) {
		ServiceConfig sc;
		if (isFourni) {
			sc = new ServiceConfigFourni(name);
		} else {
			sc = new ServiceConfigRequis(name);
		}
		this.services.add(sc);
	}
	
	public void addPort(boolean isFourni, String name) {
		PortConfig pc;
		if (isFourni) {
			pc = new PortConfigFourni(name);
		} else {
			pc = new PortConfigRequis(name);
		}
		this.ports.add(pc);
	}
	
	// Attach (2)
	
	public Attachment addLink(String name, RoleFrom r, PortFourni p) {
		Attachment a = new Attachment(name);
		a.bind(r, p);
		this.attachments.add(a);
		return a;
	}
	
	public Attachment addLink(String name, RoleTo r, PortRequis p) {
		Attachment a = new Attachment(name);
		a.bind(r, p);
		this.attachments.add(a);
		return a;
	}
	
	
	// Bindings (4)
	
	public Binding addLink(String name, RoleFrom r, PortConfigFourni p) {
		Binding b = new Binding(name);
		b.bind(r, p);
		this.bindings.add(b);
		return b;
	}
	
	public Binding addLink(String name, RoleTo r, PortConfigRequis p) {
		Binding b = new Binding(name);
		b.bind(r, p);
		this.bindings.add(b);
		return b;
	}
	
	public Binding addLink(String name, PortConfigRequis pc, PortRequis p) {
		Binding b = new Binding(name);
		b.bind(pc, p);
		this.bindings.add(b);
		return b;
	}
	
	public Binding addLink(String name, PortConfigFourni pc, PortFourni p) {
		Binding b = new Binding(name);
		b.bind(pc, p);
		this.bindings.add(b);
		return b;
	}
	
}
