package M2;

public class Attachment {

	private String name;
	private Role a;
	private Port b;
	
	private Configuration config;
	
	public Attachment(String name, Configuration config) {
		this.name = name;
		this.config = config;
	}
	
	public void bind(RoleFrom r, PortFourni p) {
		this.a = r;
		this.b = p;
	}
	
	public void bind(RoleTo r, PortRequis p) {
		this.a = r;
		this.b = p;
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

	public Role getSource() {
		return a;
	}

	public Port getDestination() {
		return b;
	}
	
}
