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
	
	public void addConnectedRoles(RoleFrom rf, RoleTo rt) {
		this.rolesF.put(rf.getName(), rf);
		this.rolesT.put(rt.getName(), rt);
		this.glue.addConnection(rf, rt);
	}

	
	// run
	
	public final void run(Role sender, String message) {
		// TODO si pas composite, pas appeler la glue et exécuter au niveau du dessous
		//if(this.subConfiguration == null) {
			this.glue.bind(sender, message);
		/*}
		else {
			this.getParent().callBindings(sender, message);
		}*/
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
