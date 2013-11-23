package M2;

import java.util.HashMap;


public class Connecteur extends Element {
	
	// TODO Glue

	private HashMap<String, RoleFrom> rolesF;
	private HashMap<String, RoleTo> rolesT;
	private Glue glue;
	
	
	public Connecteur(String name, Configuration parent) {
		super(name, parent);
		this.rolesT = new HashMap<String, RoleTo>();
		this.rolesF = new HashMap<String, RoleFrom>();
		this.glue = new Glue();
	}
	
	// run
	
	public void run(Role sender, String message) {
		this.glue.bind(sender, message);
	}
	
	public void addConnectedRoles(RoleFrom rf, RoleTo rt) {
		this.rolesF.put(rf.getName(), rf);
		this.rolesT.put(rt.getName(), rt);
		this.glue.addConnection(rf, rt);
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
