package dev.fullcontact.model;

public class Profile {
	public String service;
	public String url;

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

	public Profile(String service, String url) {

		this.service = service;
		this.url = url;
	}

	public Profile() {

	}

	@Override
	public String toString() {
		return "Profile [service=" + service + ", url=" + url + "]";
	}

}
