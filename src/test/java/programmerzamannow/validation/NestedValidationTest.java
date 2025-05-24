package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest extends AbstractValidatorTest {

    @Test
    void testNestedValidation() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");

        Address address = new Address();
        person.setAddress(address);

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("-------------------------------------");
        }
    }
}
