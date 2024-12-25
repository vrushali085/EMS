package org.techhub.model;

public class RoleModel {
	private int role_id;
	private String rolename;
	private String role_description;
	public RoleModel(int role_id, String rolename, String role_description) {
		super();
		this.role_id = role_id;
		this.rolename = rolename;
		this.role_description = role_description;
	}
	public RoleModel()
	{
		
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRole_description() {
		return role_description;
	}
	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
	

}
