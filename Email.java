package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private int mailboxcapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLength = 10;
	private String email;
	private String companySuffix = "aiya.com";
	
	//Constructor for first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Call function asking for department, return the department
		this.department = setDepartment();
		
		//Call a method return a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Password: " + password);
		//Combine elements to generate email 
		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix; 
	}
	
	//Ask for department
	private String setDepartment() {
		System.out.print("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		if(departmentChoice==1) {
			return "salse";
		}else if(departmentChoice==2) {
			return "dev";
		}else if(departmentChoice==3) {
			return "acct";
		}else {
			return "";
		}
	}
	
	//Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] array = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int)(Math.random()*passwordSet.length());
			array[i] = passwordSet.charAt(rand);
		}
		
		return new String(array);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int mailboxcapacity) {
		this.mailboxcapacity = mailboxcapacity;
	}
	
	//Set the alternate email
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	//Change the password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String showInfo() {
		return "Name: " + firstName + " " + lastName +
				"\nCompany Email: " + email +
				"\nMailbox Capacity: " + mailboxcapacity + "mb";
	}
	
	public int getMailboxCapacity() {return mailboxcapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
}
