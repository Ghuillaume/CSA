package M2;

public class Binding {

	private String name;
	private boolean isBindingConnector;
	private boolean isBindingComponent;
	
	private Role a;
	private PortConfig b;
	private Port c;
	
	private Configuration config;
	
	

	public Binding(String name, Configuration config) {
		this.name = name;
		this.isBindingComponent = false;
		this.isBindingConnector = false;
		this.config = config;
	}

	
	public void bind(RoleFrom r, PortConfigFourni p) {
		this.isBindingConnector = true;
		this.a = r;
		this.b = p;
	}
	
	public void bind(RoleTo r, PortConfigRequis p) {
		this.isBindingConnector = true;
		this.a = r;
		this.b = p;
	}
	
	public void bind(PortConfigRequis pc, PortRequis p) {
		this.isBindingComponent = true;
		this.b = pc;
		this.c = p;
	}
	
	public void bind(PortConfigFourni pc, PortFourni p) {
		this.isBindingComponent = true;
		this.b = pc;
		this.c = p;
	}
	
	
	
	/*
	 * GETTERS AND SETTERS
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object getSource() {
		if(isBindingComponent) 
			return this.b;
		else if(isBindingConnector) 
			return this.a;
		else
			return null;
	}
	
	public Object getDestination() {
		if(isBindingComponent) 
			return this.c;
		else if(isBindingConnector) 
			return this.b;
		else
			return null;
	}


	public Object getReceiver(Object sender) {
		
		if(isBindingComponent) {
			// b & c
			if(sender instanceof PortConfig) {
				if(((PortConfig)sender).getName().equals(this.b.getName())) {
					return this.c;
				}
			}
			else if(sender instanceof Port) {
				if(((Port)sender).getName().equals(this.c.getName())) {
					return this.b;
				}
			}
			
		}
		else if(isBindingConnector) {
			// a & b
			if(sender instanceof PortConfig) {
				if(((PortConfig)sender).getName().equals(this.a.getName())) {
					return this.b;
				}
			}
			else if(sender instanceof Role) {
				if(((Role)sender).getName().equals(this.b.getName())) {
					return this.a;
				}
			}
			
		}
		return null;
	}
	

}
