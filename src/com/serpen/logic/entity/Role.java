package com.serpen.logic.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {
	
	private int id;
	private String name;
	private Set<User> coleccionUser;
	
        public Role() {
        	coleccionUser= new HashSet<User>();
        }
	
	public Role(int id, String name) {
		this.id=id;
		this.name=name;
		coleccionUser= new HashSet<User>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
	public Set<User> getColeccionUser() {
		return coleccionUser;
	}

	public void setColeccionUser(Set<User> coleccionUser) {
		this.coleccionUser = coleccionUser;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}	
}
