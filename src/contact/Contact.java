package contact;


import java.util.Objects;

public class Contact extends Human {
    private int phoneNumber;

    public Contact() {
        System.out.println("Input phone number: ");

        this.phoneNumber = scanner.nextInt();
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
