package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Comment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "uid", nullable = false)
	private Login user;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "eid", nullable = false)
	private Event event;

	private String description;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
