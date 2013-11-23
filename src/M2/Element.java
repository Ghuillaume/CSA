package M2;

public abstract class Element {
	
	protected String name;
	
	protected Configuration subConfiguration;
	protected Configuration parent;
	
	public Element(String name, Configuration parent) {
		this.name = name;
		this.parent = parent;
	}
	
	public void setSubconf(Configuration subconf) {
		this.subConfiguration = subconf;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Configuration getParent() {
		return this.parent;
	}
}
