package emailadminapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private long regNo;
    private String email;
    private String passwd;
    private int passwordLength = 16;
    private String altEmail;

    Email(String firstname, String lastname) {
        System.out.println("Hello " + firstname + " " + lastname + "!");
        this.firstname = firstname;
        this.lastname = lastname;

        this.regNo = setRegistrationNumber();
        System.out.println("Good!\nGenerating email account...");

        this.passwd = generatedPassword(passwordLength);

        this.email = firstname.toLowerCase() + "." + Long.toString(regNo) + "@college.edu";

        System.out.println("Account generated!\nYour email address: " + this.email + "\nYour email password: " + this.passwd);
    }

    private long setRegistrationNumber() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please provide your registration number to complete the procedure: ");
        long reg = in.nextLong();

        return reg;
    }

    private String generatedPassword(int passwordLength) {
        String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%^&*";
        char[] generated = new char[passwordLength];
        int randIdx, charsetSize = charset.length();

        for (int i = 0; i < passwordLength; i++) {
            randIdx = (int) (Math.random() * charsetSize);
            generated[i] = charset.charAt(randIdx);
        }

        return new String(generated);
    }

    public long getRegNo() {
        return this.regNo;
    }

    public void setPassword() {
        System.out.println("Setting up new password for " + this.firstname + "...");
        System.out.println("Please enter new password: ");
        Scanner in = new Scanner(System.in);
        String pass1 = in.nextLine();
        System.out.println("Confirm password: ");
        String pass2 = in.nextLine();

        if (!pass1.equals(pass2)) {
            System.out.println("Passwords don't match!");
            return;
        }

        this.passwd = pass1;
        System.out.println("New password set successfully!");
    }

    public void setAlternateEmail() {
        System.out.println("Setting up alternate email for " + this.firstname + "...");
        System.out.println("Please enter the email: ");
        Scanner in = new Scanner(System.in);
        String altEmail = in.nextLine();

        this.altEmail = altEmail;
        System.out.println("Alternate email address set successfully!");
    }

    public void displayDetails() {
        System.out.println("-------------------------\nAccount Info\n-------------------------");
        System.out.println("First name: " + this.firstname);
        System.out.println("Last name: " + this.lastname);
        System.out.println("Registration Number: " + this.regNo);
        System.out.println("Student email: " + this.email);
        if (this.altEmail != null) {
            System.out.println("Alternate email: " + this.altEmail);
        } else {
            System.out.println("Alternate email: Not set");
        }
        System.out.println("-------------------------");
    }
}
