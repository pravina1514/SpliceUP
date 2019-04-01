package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

public class Contact {
	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)

		private Long Conid;
		
		
		private String name;
	
		private String email;

		private String message;

		public Long getConid() {
			return Conid;
		}

		public void setConid(Long conid) {
			Conid = conid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}


}