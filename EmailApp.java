package emailadminapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class EmailApp {
    static HashSet<Long> regNos = new HashSet<>();
    static ArrayList<Email> addedEmails= new ArrayList<>();

    static Email findByReg(long reg) {
        for (Email e : addedEmails) {
            if (e.getRegNo() == reg) {
                return e;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        long reg;
        System.out.println("Welcome to Student Email Administration Application!");
        while (true) {
            System.out.println("1. Register new account\n2. Set new password for existing account.\n3. Set alternate email for existing account\n0. Exit");

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            in.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("Enter first name: ");
                    String fname = in.nextLine();
                    System.out.println("Enter last name: ");
                    String lname = in.nextLine();

                    Email newEmail = new Email(fname, lname);

                    regNos.add(newEmail.getRegNo());
                    addedEmails.add(newEmail);
                    break;
                case 2:
                    System.out.println("Enter reg no: ");
                    reg = in.nextLong();

                    if (regNos.contains(reg)) {
                        Email curr = findByReg(reg);
                        curr.setPassword();
                    } else {
                        System.out.println("Registration no. not found!");
                    }
                    break;
                case 3:
                    System.out.println("Enter reg no: ");
                    reg = in.nextLong();

                    if (regNos.contains(reg)) {
                        Email curr = findByReg(reg);
                        curr.setAlternateEmail();
                    } else {
                        System.out.println("Registration no. not found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter reg no: ");
                    reg = in.nextLong();

                    if (regNos.contains(reg)) {
                        Email curr = findByReg(reg);
                        curr.displayDetails();
                    } else {
                        System.out.println("Registration no. not found!");
                    }
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }

        }

    }
}
