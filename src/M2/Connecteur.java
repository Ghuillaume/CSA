package M2;

import java.util.LinkedList;


public class Connecteur extends Element {

	LinkedList<Role> roles;
	
	
	public Connecteur(String name) {
		super(name);
		this.roles = new LinkedList<Role>();
	}



	public void addRole(boolean isFrom, String name) {
		Role r;
		if (isFrom) {
			r = new RoleFrom(name);
		} else {
			r = new RoleTo(name);
		}
		this.roles.add(r);
	}
}
