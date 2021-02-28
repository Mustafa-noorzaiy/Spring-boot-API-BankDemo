package com.bank.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// This class is called Entity or Model or POJO  'Plain old java object'

@Entity
@Table(name = "Customer")   		// to create table in database name customer which called mapping

public class Customer {
	
	// to generate account number
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Account_Number")
	private long accountNumber;
	
	@Column(name="Balance")
	private long blance;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Phone_Number")
	private long phoneNumber;
	
	@Column(name="Deposit")
	private long deposit;
	
	@Column(name="withdraw")
	private long withdraw;

	//No argument Constructor
	public Customer() {
		
	}
	
	// Parameterized Constructor
	public Customer(long id, long accountNumber, long blance, String firstName, String lastName, String email, long phoneNumber,
			long deposit, long withdraw) {
		this.id=id;
		this.accountNumber = accountNumber;
		this.blance = blance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.deposit = deposit;
		this.withdraw = withdraw;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber=accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.contains("[123456789!@#$%^&*()]")) {
			System.out.println("Name should be only letters");
		} else {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.contains("123456789!@#$%^&*()")) {
			System.out.println("Name should be only letters");
		} else {
			this.lastName = lastName;
		}
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
		int a[] = new int[10];
		for (int i = 0; i < 10; i++) {
			if (a[i] < 0 || a[i] > 9) {
				System.out.println("Wrong input");
			}
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public long getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(long d) {
		this.withdraw = d;
		
		if (d < 1) {
			System.out.println("You have: " + blance + "You need to deposit in order to take it");
		}
	}

	public long getDeposit() {
		return deposit;
	}
	public void setDeposit(long deposit) {
		this.deposit = deposit+blance;
	}

	public long getBlance() {
		return blance=deposit-withdraw;
	}
	public void setBlance(long blance) {
		this.blance = blance;
		if(blance<0) {
			System.out.println("You don't have enough money");
		}
	}
	
}
