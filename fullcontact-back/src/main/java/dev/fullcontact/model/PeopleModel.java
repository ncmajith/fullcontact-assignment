package dev.fullcontact.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class PeopleModel {

	@Email(message = "Please enter valid email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	@NotNull(message = "Please enter email")
	private String email = null;

	@NotNull(message = "Please enter phone")
	private String phone = null;

	@NotNull(message = "Please enter service name")
	private String service = null;

	@NotNull(message = "Please enter url")
	private String url = null;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PeopleModel(String email, String phone, String service, String url) {
		super();
		this.email = email;
		this.phone = phone;
		this.service = service;
		this.url = url;
	}

	public PeopleModel() {

	}

	@Override
	public String toString() {
		return "PeopleModel [emails=" + email + ", phones=" + phone + ", service=" + service + ", url=" + url + "]";
	}

}
