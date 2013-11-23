package M2;

import M0.Trace;

public class Binding {

	private String name;
	private Interface sideA;
	private Interface sideB;
	
	

	public Binding(String name) {
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
		
		if(this.sideA == null || this.sideB == null) {
			Trace.printError("Binding " + this.name + " isn't well formed");
		}
		else {
			if(sender instanceof PortConfig) {
				if(((PortConfig)sender).getName().equals(this.sideA.getName())) {
					return this.sideB;
				}
				else if(((PortConfig)sender).getName().equals(this.sideB.getName())) {
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
			else if(sender instanceof Role) {
				if(((Role)sender).getName().equals(this.sideA.getName())) {
					return this.sideB;
				}
				else if(((Role)sender).getName().equals(this.sideB.getName())) {
					return this.sideA;
				}
			}
		}
	
		return null;
	}
	

}
