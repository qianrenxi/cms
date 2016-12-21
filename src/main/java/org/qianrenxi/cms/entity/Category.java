package org.qianrenxi.cms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category implements Serializable {
	private static final long serialVersionUID = 7668925955614959368L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	@NotNull
	protected String name;
	protected String identifier;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	protected Category parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	protected List<Category> children;

	public Category() {
	}
	
	public Category(Long id, String name){
		setId(id);
		setName(name);
	}
	
	public Category(Long id, String name, Category parent){
		this(id, name);
		setParent(parent);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}
}
