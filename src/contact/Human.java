package contact;

import java.util.Objects;

public abstract class Human {
    private String name;
    private String lastName;

    public Human(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getName().equals(human.getName()) && getLastName().equals(human.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName());
    }


}
