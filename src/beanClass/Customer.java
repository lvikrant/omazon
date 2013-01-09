package beanClass;

import java.util.Calendar;

public class Customer {
	
	/* Declaration of private member variables */
	private int customerId;
	private String userId;
	private String customerName;
	private Calendar dateofRegistration;
	private String address;
	private String city;
	private String pin;
	private String telephoneNo;
	private String emailId;
	private String region;
	private char defaulter;

	/* Used to set the value for the CustomerId */

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/* Used to retrieve the value stored in the CustomerId */
	public int getCustomerId() {
		return this.customerId;
	}

	/* Used to Set the value for the UserId */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/* Used to Retrieve the value stored in the UserId */
	public String getUserId()

	{
		return userId;

	}

	/* Used to Set the value for the CustName */
	public void setCustomerName(String custName) {
		customerName = custName;
	}

	/* Used to Retrieve the value stored in the CustName */
	public String getCustomerName() {
		return customerName;
	}

	/* Used to Set the value for the Date of Registration */
	public void setDateofRegistration(Calendar dateofReg) {
		dateofRegistration = dateofReg;
	}

	/* Used to Retrieve the value stored in the Date of Registration */
	public Calendar getDateofRegistration() {
		return dateofRegistration;
	}

	/* Used to Set the value for the Address */
	public void setAddress(String address) {
		this.address = address;
	}

	/* Used to Retrieve the value stored in the Address */
	public String getAddress() {

		return address;
	}

	/* Used to Set the value for the City */
	public void setCity(String city) {
		this.city = city;
	}

	/* Used to Retrieve the value stored in the City */
	public String getCity() {

		return city;
	}

	/* Used to Set the value for the Pin */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/* Used to Retrieve the value stored in the Pin */
	public String getPin() {

		return pin;
	}

	/* Used to Set the value for the Telephone No */
	public void setTelephoneNo(String telNo) {
		telephoneNo = telNo;
	}

	/* Used to Retrieve the value stored in the Telephone No */
	public String getTelephoneNo() {
		return telephoneNo;
	}

	/* Used to Set the value for the Email */
	public void setEmail(String email) {
		this.emailId = email;
	}

	/* Used to Retrieve the value stored in the Email */
	public String getEmailId() {

		return emailId;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	/* Used to Retrieve the value stored in the Email */
	public String getRegion() {

		return region;
	}

	/* Used to Set the value for the Defaulter */
	public void setDefaulter(char defaulter) {
		this.defaulter = defaulter;
	}

	/* Used to Retrieve the value stored in the Defaulter */
	public char getDefaulter() {

		return defaulter;
	}
}
