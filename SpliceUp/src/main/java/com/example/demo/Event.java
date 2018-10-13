package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eid;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "host_id", nullable = false)
	private UserMaster eventHost;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cid", nullable = false)
	private Cities city;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "event")
	private List<Faq> questions;

	private boolean payment;
	private int capacity;
	private String name;
	private String image;
	private String description;
	private boolean isPaidEvent;

	private Date s_date;
	private Date e_date;
	private String location;

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public UserMaster getEventHost() {
		return eventHost;
	}

	public void setEventHost(UserMaster eventHost) {
		this.eventHost = eventHost;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Cities getCity() {
		return city;
	}

	public void setCity(Cities city) {
		this.city = city;
	}

	public List<Faq> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Faq> questions) {
		this.questions = questions;
	}

	public boolean isPaidEvent() {
		return isPaidEvent;
	}

	public void setPaidEvent(boolean isPaidEvent) {
		this.isPaidEvent = isPaidEvent;
	}

}
