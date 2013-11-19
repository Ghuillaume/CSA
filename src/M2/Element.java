package M2;

public abstract class Element {
	
	protected String name;
	
	protected Configuration subConfiguration;
	
	public Element(String name) {
		this.name = name;
	}
	
	public void setSubconf(Configuration subconf) {
		this.subConfiguration = subconf;
	}
	
	public String getName() {
		return this.name;
	}
}
