package com.infy.springboot.microservice.microserviceinter.springbootmicroserviceinterservice;

import java.math.BigDecimal;

import javax.persistence.Column;

public class ShowCustomerDataBean {

	private String phone;
	private String firstName;
	private String lastName;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String accountNumber;
	private String accountBalance;
	private String totalBalance;
	
	public ShowCustomerDataBean() {
		
	}
	public ShowCustomerDataBean(String phone, String firstName, String lastName, String email, String addressLine1,
			String addressLine2, String accountNumber, String accountBalance, String totalBalance) {
		super();
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.totalBalance = totalBalance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(String totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	
}
