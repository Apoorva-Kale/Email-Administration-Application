package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private int defaultPasswordLength = 10;
	private String company = "xyzcompany.com";
	private String email;
	
	// Constructor to receive the first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName; // this refers to the class variable
		this.lastName = lastName;
		
		//Call the department function and return the department
		this.department = setDepartment();
		
		//Call the password function and return the password
		this.password = randomPass(defaultPasswordLength);
		System.out.println("PASSWORD : " + this.password);
		
		// Set email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + company;
	}
	
	// Ask for department
	private String setDepartment() {
		System.out.print("New Employee : " + firstName + "\nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 forAccounting\n0 for none\nEnter department : ");
		Scanner sc = new Scanner(System.in);
		int deptChoice = sc.nextInt();
		if(deptChoice == 1) {return "Sales";}
		else if(deptChoice == 2) {return "Development";}
		else if(deptChoice == 3) {return "Accounting";}
		else {return "";}
	}	
		
	// Generate a random password
	private String randomPass(int length){
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
		char[] password = new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
		
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// Get all the info to display in main()
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword( ) {return password;}
	
	// Display all the info
	public String showInfo() {
		return "DISPLAY NAME : " + firstName + lastName + 
				"\nCOMPANY EMAIL : " + email + 
				"\nMAILBOX CAPACITY : " + mailboxCapacity + "mb";
	}
}	

