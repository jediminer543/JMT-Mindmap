package org.jmt.mindmap.component;

import java.util.UUID;

public class Link {

	public UUID node1, node2;
	
	public Link(UUID node1, UUID node2) {
		this.node1 = node1;
		this.node2 = node2;
	}
	
}
