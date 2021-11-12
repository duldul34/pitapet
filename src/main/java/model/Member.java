package model;

import java.util.List;

public class Member {
	private String id;
	private String password;
	private String name;
	private String birth;
	private char gender;
	private String phone;
	private String address;
	private String email;
	private String identity;
	private List<Pet> myPets;
	
	public Member(String id) {
		super();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public List<Pet> getMyPets() {
		return myPets;
	}
	public void setMyPets(List<Pet> myPets) {
		this.myPets = myPets;
	}
	
	public boolean matchPassword(String password) {
		if(password == null) {
			return false;
		}
		return this.password.equals(password);
	}
	public boolean isSameMember(Member member) {
		return id.equals(member.id);
	}
}
