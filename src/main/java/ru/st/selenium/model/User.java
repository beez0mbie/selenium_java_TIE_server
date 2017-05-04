package ru.st.selenium.model;

public class User {
	String login, password, newPassword, role, name, phone, metroStation, metroLine;

	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setRole(String role) {
		this.role = role;
		return this;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public User setMetroStation(String metroStation) {
		this.metroStation = metroStation;
		return this;
	}

	public User setMetroLine(String metroLine) {
		this.metroLine = metroLine;
		return this;
	}

	public User setNewPassword(String newPassword) {
		this.newPassword = newPassword;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getMetroStation() {
		return metroStation;
	}

	public String getMetroLine() {
		return metroLine;
	}

	public String getNewPassword() {
		return newPassword;
	}
	
	
}
