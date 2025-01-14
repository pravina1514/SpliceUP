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
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean payment;
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "uid", nullable = false)
	private Login user;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "eid", nullable = false)
	private Event event;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "group_id", nullable = true)
	private ParticipantsGroup partiCipantGroup;

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ParticipantsGroup getPartiCipantGroup() {
		return partiCipantGroup;
	}

	public void setPartiCipantGroup(ParticipantsGroup partiCipantGroup) {
		this.partiCipantGroup = partiCipantGroup;
	}
}
