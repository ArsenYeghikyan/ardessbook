package menu;

import contact.Contact;

public interface Menu_Interface {
   void showMenuDisplay();
   void printAllContacts();
   void addContact();
   void deleteContact();
   void updateContact();
   Contact searchContactByPhoneNumber(int phoneNumber);


}
