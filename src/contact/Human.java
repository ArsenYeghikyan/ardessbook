package contact;


import java.util.Objects;

public abstract class Human {
    private String name;
    private String lastName;
    private int birthDate;
    private String city;
    private String street;


    public Human (String name, String lastName, int birthDate, String city, String street)  {
        this.name = name;
        this.lastName = lastName;

        if (birthDate <= 1860) {

            System.out.println("======Incorrect  birthDate , try again======\n");
        } else {
            this.birthDate = birthDate;

        }
        this.city = city;
        this.street = street;
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
