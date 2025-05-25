package programmerzamannow.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Person {

    @Size(max = 20, message = "First name must be less than 20 characters")
    @NotBlank(message = "First name cannot blank")
    String firstName;

    @Size(max = 20, message = "Last name must be less than 20 characters")
    @NotBlank(message = "Last name cannot blank")
    String lastName;

    @NotNull(message = "Address cannot null")
    @Valid
    private Address address;

    public Person() {
    }

    public Person(
            @NotBlank(message = "firstname cannot blank") String firstName,
            @NotBlank(message = "lastname cannot blank") String lastName,
            @NotNull(message = "Address cannot blank") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void sayHello(@NotBlank(message = "Name cannot blank") String name) {
        System.out.println("Hello, " + name + ". My name is " + firstName);
    }

    public String getFullname() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
