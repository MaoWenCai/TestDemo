package com.test.collection.sort;

public class User implements Comparable<User>{
	private String name;
	private String address;
    private Integer order;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getOrder() {
        return order;
    }
    public void setOrder(Integer order) {
        this.order = order;
    }
    
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int compareTo(User o) {
		return this.getOrder().compareTo(o.getOrder());
	}
}
