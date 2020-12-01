package contact;

import java.util.Objects;
import java.util.Scanner;

public abstract class Human {
    private String name;
    private String lastName;
    private int birthDate;
    private String city;
    private String street;
    Scanner scanner = new Scanner(System.in);


    public Human() {
        System.out.println("Input name: ");
        this.name = scanner.next();

        System.out.println("Input last name: ");
        this.lastName = scanner.next();

        System.out.println("Input birth date: ");
        this.birthDate = scanner.nextInt();

        System.out.println("Input city: ");
        this.city = scanner.next();

        System.out.println("Input street: ");
        this.street = scanner.next();
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getBirthDate() == human.getBirthDate() && Objects.equals(getName(), human.getName()) && Objects.equals(getLastName(), human.getLastName()) && Objects.equals(getCity(), human.getCity()) && Objects.equals(getStreet(), human.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getBirthDate(), getCity(), getStreet());
    }
}
