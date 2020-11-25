package menu;

import contact.Contact;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu implements Menu_Interface {

    Scanner scanner = new Scanner(System.in);
    static private int id = 1;
    Map<Integer, Contact> contactMap = new HashMap<>();

    public Menu() {
        showMenuDisplay();

    }

    @Override
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
                default: {
                    System.out.println("error!");
                    isActiveMenu = false;
                }
            }


        } while (isActiveMenu);
    }

    @Override
    public void printAllContacts() {
        System.out.println("\n======ALL CONTACTS======\n");

        if (contactMap.isEmpty()) {
            System.out.println("\n=========Contact list is empty========\n");
        } else {
            printContactInfo();
            try (Scanner scanner = new Scanner(new File("addressBook.txt"))) {
                while(scanner.hasNext()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                // print some message
            }
        }
        System.out.println("\n======================\n");
    }

    @Override
    public void addContact() {

        Contact contactForAdd = createContact();

        contactMap.put(id++, contactForAdd);

        System.out.println("======THE RECORD WAS ADDED======");

    }


    @Override
    public void deleteContact() {
        System.out.println("======Enter ID for delete======");

        int idForDelete = scanner.nextInt();

        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {
            if (contact.getKey() == idForDelete) {

                System.out.println("======The ENTRY WITH ID {" + idForDelete + "} WAS REMOVED======");
            } else {
                System.out.println("======INVALID ID {" + idForDelete + "} PROVIDED======");
            }
        }
        contactMap.remove(idForDelete);
        if (contactMap.isEmpty()) {
            System.out.println("===ADDRESS BOOK IS EMPTY===");
            id = 1;
        }
    }


    @Override
    public void updateContact() {
        System.out.println("======Enter ID for update contact ======");

        int idForReplace = scanner.nextInt();

        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {
            if (contact.getKey() == idForReplace) {

                Contact contactForUpdate = createContact();

                contact.setValue(contactForUpdate);


            } else {
                System.out.println("NOT FIND ID:  " + idForReplace);
            }

        }
    }


    @Override
    public void searchContactByPhoneNumber() {
        System.out.println("====== Enter phone number for search contact ======");

        int phone = scanner.nextInt();

        for (Map.Entry<Integer, Contact> contact : contactMap.entrySet()) {
            if (contact.getValue().getPhoneNumber() == phone) {
                System.out.println("\n======THE CONTACT FOUND======\n");
                printContactInfo();

            } else {
                System.out.println("NOT FIND " + phone);
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
        Contact contact = new Contact(contactName, contactLastName, phoneNumber, contactBirthDate, contactCity, contactStreet);
        printInFile(contact);
        return contact;

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


    private void printInFile(Contact contactForPrintInFile) {


        Path filePath = Paths.get("addressBook.txt");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, Charset.defaultCharset(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
            printWriter.println("\nID contact:" + id +
                    "\nName: " + contactForPrintInFile.getName() +
                    "\nLast name: " + contactForPrintInFile.getLastName() +
                    "\nPhone number: " + contactForPrintInFile.getPhoneNumber() +
                    "\nBirth date: " + contactForPrintInFile.getBirthDate() +
                    "\nCity: " + contactForPrintInFile.getCity() +
                    "\nstreet: " + contactForPrintInFile.getStreet());

        } catch (IOException e) {
            // print some message
        }

    }
//    public boolean isFileEmpty(File file) {
//        BufferedReader br = new BufferedReader(new BufferedReader());
//        return br.lines() == null;
//    }
}


