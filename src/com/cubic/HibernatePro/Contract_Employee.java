package com.cubic.HibernatePro;

public class Contract_Employee extends Employee {
	private float payperhour;
	private String contractperiod;
	public float getPayperhour() {
		return payperhour;
	}
	public void setPayperhour(float payperhour) {
		this.payperhour = payperhour;
	}
	public String getContractperiod() {
		return contractperiod;
	}
	public void setContractperiod(String contarctperiod) {
		this.contractperiod = contarctperiod;
	}
	
	
}
