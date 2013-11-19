package M2;

public abstract class PortConfig extends Interface {
	
	protected Configuration parent;

	public PortConfig(String name, Configuration config) {
		super(name);
		this.parent = config;
	}
	
	public Configuration getConfig() {
		return this.parent;
	}
	
	public Configuration getParent() {
		return this.parent;
	}
}
