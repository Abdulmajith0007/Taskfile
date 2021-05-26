package com.menu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long Id; 
	
    private String name; 
    
    @Column(nullable = false)
    private int parent;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getparent() {
		return parent;
	}

	public void setparent(int parent) {
		this.parent = parent;
	}

	public Menu(long id, String name, int parent) {
		super();
		Id = id;
		this.name = name;
		this.parent = parent;
	}

	public Menu() {
		
	}

	
    
    
   
}
