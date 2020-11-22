package menu;

import contact.Contact;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu implements Menu_Interface {

    Scanner scanner = new Scanner(System.in);
    //popoxakan contactCount avelacnuma Id @st avelacrac contaktneri
    public static int contactCount = 0;
    Map<Integer, Contact> contactMap = new HashMap<>();

    public void showMenuDisplay() {
        boolean isActiveMenu = true;
        do {
            System.out.println("======ADDRESS BOOK MENU======\n" +
                    "Choose one of the following options and press ENTER\n" +
                    "1. Print all entries\n" +
                    "2. Add new entry\n" +
                    "3. Delete an entry\n" +
                    "4. Update an entry\n" +
                    "5. Search entry by phone number\n" +
                    "6. Exit\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Drop down select the command by clicking the button from 1 to 6");
            int button = scanner.nextInt();

/// ogtagorcel em nor Switch case@
            switch (button) {
                case 1 -> printAllContacts();
                case 2 -> addContact();
                case 3 -> deleteContact();
                case 4 -> updateContact();
                case 5 -> searchContactByPhoneNumber();
                case 6 -> {
                    System.out.println("Exit");
                    isActiveMenu = false;
                }
                default -> {
                    System.out.println("error!");
                    isActiveMenu = false;
                }
            }


        } while (isActiveMenu);
    }

    @Override
    public void printAllContacts() {
        System.out.println("\n======ALL ENTRIES======\n");

        if (contactMap.isEmpty()) {
            System.out.println("\n=========Contact list is empty========\n");
        } else {
                printContactInfo();

        }
        System.out.println("\n======================\n");
    }

    @Override
    public void addContact() {

        contactMap.put(contactCount, createContact());
        System.out.println("======THE RECORD WAS ADDED======");
    }


    @Override
    public void deleteContact() {
        System.out.println("======Enter id for delete======");

        int idForDelete = scanner.nextInt();

        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {
            if (contact.getValue().getId() == idForDelete) {
//!!!!!!!!!!!!!!!!!!!!!!


                System.out.println("======The ENTRY WITH ID {" + idForDelete + "} WAS REMOVED======");
            } else {
                System.out.println("======INVALID ID {" + idForDelete + "} PROVIDED======");
            }
        }
        contactMap.remove(idForDelete);
    }


    @Override
    public void updateContact() {
        System.out.println("======Enter id for update======");

        int idForReplace = scanner.nextInt();

        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {
            if (contact.getValue().getId() == idForReplace) {

                Contact contact2 = createContact();
                contactMap.replace(idForReplace,contact2);

                contact.setValue(
                        new Contact(
                                contact2.getName(),
                                contact2.getLastName(),
                                contact.getValue().getId(),
                                contact2.getPhoneNumber(),
                                contact2.getBirthDate(),
                                contact2.getCity(),
                                contact2.getStreet()));

            } else {
                System.out.println("not fine this ID");
            }

        }
    }


    @Override
    public void searchContactByPhoneNumber() {
        System.out.println("======Enter phone number for search contact======");

        int phone = scanner.nextInt();

        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {
            if (contact.getValue().getPhoneNumber() == phone) {
                System.out.println("\n======THE CONTACT FOUND======\n");
                printContactInfo();

            } else {
                System.out.println("not find " + phone);
            }

        }
    }


    private Contact createContact() {
        System.out.println("Input name: ");
        String contactName = scanner.next();

        System.out.println("Input last name: ");
        String contactLastName = scanner.next();

        System.out.println("Input phone number: ");
        int phoneNumber = scanner.nextInt();

        System.out.println("Input birth date: ");
        int contactBirthDate = scanner.nextInt();

        if (phoneNumber <= 0 || contactBirthDate <= 1860) {
            System.out.println("\n======FAILED TO CREATE A RECORD======\n" +
                    "======Incorrect phone number format or birth date format, try again======\n");

            showMenuDisplay();
        }

        System.out.println("Input city: ");
        String contactCity = scanner.next();

        System.out.println("Input street: ");
        String contactStreet = scanner.next();
        contactCount++;


        return new Contact(contactName, contactLastName, contactCount, phoneNumber, contactBirthDate, contactCity, contactStreet);

    }

    private void printContactInfo() {
        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {

            System.out.println(
                    "\nID contact:" + contact.getValue().getId() +
                    "\nName: " + contact.getValue().getName() +
                    "\nLast name: " + contact.getValue().getLastName() +
                    "\nPhone number: " + contact.getValue().getPhoneNumber() + '\n' +
                    "\nBirth date: " + contact.getValue().getBirthDate() + '\n' +
                    "\nCity: " + contact.getValue().getCity() + '\n' +
                    "\nstreet: " + contact.getValue().getStreet() + '\n');


        }


    }

}
