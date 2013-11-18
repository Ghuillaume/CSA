package M2;

import java.util.HashMap;


public class Connecteur extends Element {
	
	// TODO Glue

	private HashMap<String,RoleFrom> rolesF;
	private HashMap<String,RoleTo> rolesT;
	private Configuration configuration;
	
	
	public Connecteur(String name, Configuration parent) {
		super(name);
		configuration = null;
		this.rolesT = new HashMap<String,RoleTo>();
		this.rolesF = new HashMap<String,RoleFrom>();
		
		this.configuration = parent;
	}
	
	public Configuration getParent() {
		return this.configuration;
	}

	public void addConfiguration(Configuration config) {
		this.configuration = config;
	}
	
	public void addRole(RoleFrom r) {
		this.rolesF.put(r.getName(), r);
	}
	
	public void addRole(RoleTo r) {
		this.rolesT.put(r.getName(), r);
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
