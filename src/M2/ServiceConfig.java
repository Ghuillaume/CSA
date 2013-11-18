package M2;

public abstract class ServiceConfig {

	private String name;
	private Configuration parent;
	
	public ServiceConfig(String name, Configuration config) {
		this.name = name;
		this.parent = config;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Configuration getParent() {
		return this.parent;
	}
}
