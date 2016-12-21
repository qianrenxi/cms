package org.qianrenxi.cms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = -5423148129266892432L;
	
	public enum Status {
		DRAFT, PENDING, PUBLISHED
	}
	
	public enum Visibility {
		PUBLIC, PROTECTED, PRIVATE
	}

	@Id
	@GeneratedValue
	protected Long id;
	protected String title;
	protected String alias;
	protected String digest;
	protected String content;
	protected String thumbnail;
	@Enumerated(EnumType.STRING)
	protected Status status;
	protected Date publishDate;
	@Enumerated(EnumType.STRING)
	protected Visibility visibility;
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	protected List<Author> authors;
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	protected List<Category> categories;
	@ElementCollection
	protected List<String> tags;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Visibility getVisibility() {
		return visibility;
	}
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
