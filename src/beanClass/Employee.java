package beanClass;

import java.util.Calendar;

public class Employee {

	private String employeeName;
	private Calendar dateOfBirth;
	private char designation;
	private String address;
	private String pin;
	private String telephoneNo;
	private String email;
	private char region;
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * @return the dateOfBirth
	 */
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * @return the designation
	 */
	public char getDesignation() {
		return designation;
	}
	
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(char designation) {
		this.designation = designation;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}
	
	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	/**
	 * @return the region
	 */
	public char getRegion() {
		return region;
	}
	
	/**
	 * @param region the region to set
	 */
	public void setRegion(char region) {
		this.region = region;
	}
	
	/**
	 * @return the telephoneNo
	 */
	public String getTelephoneNo() {
		return telephoneNo;
	}
	
	/**
	 * @param telephoneNo the telephoneNo to set
	 */
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	
		
}
