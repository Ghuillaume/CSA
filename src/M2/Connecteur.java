package M2;

import java.util.HashMap;


public class Connecteur extends Element {
	
	// TODO Glue

	HashMap<String,RoleFrom> rolesF;
	HashMap<String,RoleTo> rolesT;
	private Configuration configuration;
	
	
	public Connecteur(String name) {
		super(name);
		configuration = null;
		this.rolesT = new HashMap<String,RoleTo>();
		this.rolesF = new HashMap<String,RoleFrom>();
	}

	public void addConfiguration(Configuration config) {
		this.configuration = config;
	}

	public void addRole(boolean isFrom, String name) {
		if (isFrom) {
			this.rolesF.put(name, new RoleFrom(name));
		} else {
			this.rolesT.put(name, new RoleTo(name));
		}
	}
	
	
	/*
	 * GETTERS
	 */

	public RoleFrom getRoleFrom(String name) {
		return this.rolesF.get(name);
	}
	
	public RoleTo getRoleTo(String name) {
		return this.rolesT.get(name);
	}
}
