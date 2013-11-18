package M2;

public abstract class PortConfig {

	private String name;
	private Configuration parent;
	
	public PortConfig(String name, Configuration config) {
		this.name = name;
		this.parent = config;
	}
	
	public Configuration getParent() {
		return this.parent;
	}
	
	public String getName() {
		return this.name;
	}
}
