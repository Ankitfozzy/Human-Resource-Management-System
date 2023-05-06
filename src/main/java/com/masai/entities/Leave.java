package com.masai.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Leave {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	@Column(name = "type", nullable = false)
	 	private String type;
	 	
	 	@Column(name = "applicant", nullable = false)
	 	private String applicant;
	 	
	 	@Column(name = "status", nullable = false)
	 	private String status;

		public Leave() {
			super();
		}

		public Leave(Long id, String type, String applicant, String status) {
			super();
			this.id = id;
			this.type = type;
			this.applicant = applicant;
			this.status = status;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getApplicant() {
			return applicant;
		}

		public void setApplicant(String applicant) {
			this.applicant = applicant;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Leave [id=" + id + ", type=" + type + ", applicant=" + applicant + ", status=" + status + "]";
		}
	 	
}
