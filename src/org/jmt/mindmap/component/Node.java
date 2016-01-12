package org.jmt.mindmap.component;

import java.util.UUID;

public class Node {

	public String shortName, description;
	public boolean virtual;
	public UUID id;
	
	public Node(String shortName) {
		this(shortName, "");
	}
	
	public Node(String shortName, String description) {
		this(shortName, description, false);
	}
	
	public Node(String shortName, String description, boolean virtual) {
		this(shortName, description, virtual, UUID.randomUUID());
	}
	
	public Node(String shortName, String description, boolean virtual, UUID id){
		this.shortName = shortName;
		this.description = description;
		this.virtual = virtual;
		this.id = id;
	}
	
	
}
