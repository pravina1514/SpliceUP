package com.example.demo;

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

public class Faq {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "uid", nullable = false)
	private Login user;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "eid", nullable = false)
	private Event event;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> ansList;

	private String question;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
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

}
