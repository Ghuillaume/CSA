package M2;


public class Attachment {

	private String name;
	private Interface sideA;
	private Interface sideB;
	
	public Attachment(String name) {
		this.name = name;
	}

	public void bind(Interface a, Interface b) {
		this.sideA = a;
		this.sideB = b;
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

	public Interface getReceiver(Interface sender) {
		if(sender instanceof Role) {
			if(((Role)sender).getName().equals(this.sideA.getName())) {
				return this.sideB;
			}
			else if(((Role)sender).getName().equals(this.sideB.getName())) {
				return this.sideA;
			}
		}
		else if(sender instanceof Port) {
			if(((Port)sender).getName().equals(this.sideA.getName())) {
				return this.sideB;
			}
			else if(((Port)sender).getName().equals(this.sideB.getName())) {
				return this.sideA;
			}
		}
		return null;
	}
	
}
