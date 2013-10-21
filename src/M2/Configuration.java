package M2;

import java.util.LinkedList;

public class Configuration {

	LinkedList<Element> elements;
	LinkedList<Attachment> attachments;
	LinkedList<Binding> bindings;
	
	String name;
	
	
	public Configuration(String name) {
		
		this.name = name;
		this.elements = null;
		this.attachments = null;
		this.bindings = null;
	}
	
	public void addElement(Element e) {
		this.elements.add(e);
	}
	
	
	// Bindings (2)
	
	public void addLink(String name, RoleFrom r, PortFourni p) {
		Attachment a = new Attachment(name);
		a.bind(r, p);
		this.attachments.add(a);
	}
	
	public void addLink(String name, RoleTo r, PortRequis p) {
		Attachment a = new Attachment(name);
		a.bind(r, p);
		this.attachments.add(a);
	}
	
	
	// Attach
	
	public void addLink(String name, RoleFrom r, PortConfigFourni p) {
		Binding b = new Binding(name);
		b.bind(r, p);
		this.bindings.add(b);
	}
	
	
}
