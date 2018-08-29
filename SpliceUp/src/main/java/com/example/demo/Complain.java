package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Complain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cmpid;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "uid", nullable = false)
	private UserMaster user;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cuid", nullable = false)
	private UserMaster cUser;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "eid", nullable = false)
	private Event event;

	private String description;

	public Long getCmpid() {
		return cmpid;
	}

	public void setCmpid(Long cmpid) {
		this.cmpid = cmpid;
	}

	public UserMaster getUser() {
		return user;
	}

	public void setUser(UserMaster user) {
		this.user = user;
	}

	public UserMaster getcUser() {
		return cUser;
	}

	public void setcUser(UserMaster cUser) {
		this.cUser = cUser;
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
