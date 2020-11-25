package contact;

import java.util.Objects;

public class Contact extends Human {

    private int phoneNumber;


    public Contact(String name, String lastName, int phoneNumber,int birthDate, String city, String street) {
        super(name, lastName, birthDate, city, street);
        if (phoneNumber<=0){
            System.out.println("Incorrect phone number please use international format");
        }else {
            this.phoneNumber = phoneNumber;
        }

    }



    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        if (!super.equals(o)) return false;
        Contact contact = (Contact) o;
        return getPhoneNumber() == contact.getPhoneNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPhoneNumber());
    }

}
