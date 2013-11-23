package M2;


public class Attachment {

	private String name;
	private Role a;
	private Port b;
	
	public Attachment(String name) {
		this.name = name;
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

	public Interface getReceiver(Interface sender) {
		if(sender instanceof Role) {
			if(((Role)sender).getName().equals(this.a.getName())) {
				return this.b;
			}
		}
		else if(sender instanceof Port) {
			if(((Port)sender).getName().equals(this.b.getName())) {
				return this.a;
			}
		}
		return null;
	}
	
}
