package com.ssafy.camp.model.dto;

public class Camp {
	int id;
	int userKey;
	String name;
	String address;
	String description;
	String img;
	String orgImg;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserKey() {
		return userKey;
	}

	public void setUserKey(int userKey) {
		this.userKey = userKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Camp [id=" + id + ", userKey=" + userKey + ", name=" + name + ", address=" + address + ", description="
				+ description + ", img=" + img + ", orgImg=" + orgImg + "]";
	}
}
