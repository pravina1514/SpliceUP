package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "qid", nullable = false)
	private Faq question;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "eid", nullable = false)
	private Event event;

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "uid", nullable = false)
	private Login user;

	private String answer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Faq getQuestion() {
		return question;
	}

	public void setQuestion(Faq question) {
		this.question = question;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Login getUser() {
		return user;
	}

	public void setUser(Login user) {
		this.user = user;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
