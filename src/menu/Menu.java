package menu;

import contact.Contact;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class Menu implements Menu_Interface {

    Scanner scanner = new Scanner(System.in);
    static private int id = 1;
    Map<Integer, Contact> contactMap = new HashMap<>();


    @Override
    public void showMenuDisplay(){
        boolean isActiveMenu = true;
        do {
            try {
                System.out.println("======ADDRESS BOOK MENU======\n" +
                        "Choose one of the following options and press ENTER\n" +
                        "1. Print all contacts\n" +
                        "2. Add new contact\n" +
                        "3. Delete an contact\n" +
                        "4. Update an contact\n" +
                        "5. Search contact by phone number\n" +
                        "6. Exit\n");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Drop down select the command by clicking the button from 1 to 6");
                int button = scanner.nextInt();

                switch (button) {
                    case 1: {
                        printAllContacts();
                        break;
                    }
                    case 2: {
                        addContact();
                        break;
                    }
                    case 3: {
                        deleteContact();
                        break;
                    }
                    case 4: {
                        updateContact();
                        break;
                    }
                    case 5: {
                        searchContactByPhoneNumber();
                        break;
                    }
                    case 6: {
                        System.out.println("Exit");
                        isActiveMenu = false;
                        break;
                    }

                }
            }catch (InputMismatchException exception){
                System.out.println("===Incorrect number===");
            }

        } while (isActiveMenu);
    }

    @Override
    public void printAllContacts()  {
        System.out.println("\n======ALL CONTACTS======\n");

        if (contactMap.isEmpty()) {
            System.out.println("\n=========Contact list is empty========\n");
        } else {
            printContactInfo();
        }
        System.out.println("\n======================\n");
    }

    @Override
    public void addContact() {

        contactMap.put(id++, new Contact());
        System.out.println("======THE RECORD WAS ADDED======");

    }


    @Override
    public void deleteContact() {
        System.out.println("======Enter ID for delete======");

        int idForDelete = scanner.nextInt();

        if (contactMap.get(idForDelete) != null) {
            contactMap.remove(idForDelete);
            System.out.println("======The CONTACT WITH ID {" + idForDelete + "} WAS REMOVED======");
        } else {
            System.out.println("======INVALID ID {" + idForDelete + "} PROVIDED======");
        }

        if (contactMap.isEmpty()) {
            System.out.println("===ADDRESS BOOK IS EMPTY===");
            id = 1;
        }
    }


    @Override
    public void updateContact() {
        System.out.println("======Enter ID for update contact ======");

        int idForReplace = scanner.nextInt();

        if (contactMap.get(idForReplace) != null) {
            Contact contactForUpdate = new Contact();
            contactMap.replace(idForReplace, contactForUpdate);

            System.out.println("======The CONTACT WITH ID {" + idForReplace + "} WAS UPDATED======");

        } else {
            System.out.println("NOT FIND ID:  " + idForReplace);
        }


    }


    @Override
    public void searchContactByPhoneNumber() {
        System.out.println("====== Enter phone number for search contact ======");

        int phoneNumberForSearch = scanner.nextInt();

        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {
            if (contact.getValue().getPhoneNumber() == phoneNumberForSearch) {

                System.out.println("\n======THE CONTACT FOUND======\n");
                System.out.println(
                        "\nID contact:" + contact.getKey() +
                                "\nName: " + contact.getValue().getName() +
                                "\nLast name: " + contact.getValue().getLastName() +
                                "\nPhone number: " + contact.getValue().getPhoneNumber() +
                                "\nBirth date: " + contact.getValue().getBirthDate() +
                                "\nCity: " + contact.getValue().getCity() +
                                "\nstreet: " + contact.getValue().getStreet());

            } else {
                System.out.println("NOT FIND " + phoneNumberForSearch);
            }

        }


    }


    private void printContactInfo() {
        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {

            System.out.println(
                    "\nID contact:" + contact.getKey() +
                            "\nName: " + contact.getValue().getName() +
                            "\nLast name: " + contact.getValue().getLastName() +
                            "\nPhone number: " + contact.getValue().getPhoneNumber() +
                            "\nBirth date: " + contact.getValue().getBirthDate() +
                            "\nCity: " + contact.getValue().getCity() +
                            "\nstreet: " + contact.getValue().getStreet());
        }

        }

}


