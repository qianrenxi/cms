package org.qianrenxi.cms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Navigation implements Serializable {
	private static final long serialVersionUID = -1658503360727048866L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	@NotNull
	protected String identifier;
	@NotNull
	protected String name;
	protected String link;
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	protected Navigation parent;
	@OneToMany(mappedBy = "parent", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	protected List<Navigation> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Navigation getParent() {
		return parent;
	}

	public void setParent(Navigation parent) {
		this.parent = parent;
	}

	public List<Navigation> getChildren() {
		return children;
	}

	public void setChildren(List<Navigation> children) {
		this.children = children;
	}
}
