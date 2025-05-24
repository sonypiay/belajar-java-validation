package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest extends AbstractValidatorTest {

    @Test
    void testValidationFailed() {
        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Constraint: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value: " + violation.getInvalidValue());
            System.out.println("Path: " + violation.getPropertyPath());
        }
    }

    @Test
    void testValidationFailedSize() {
        Person person = new Person();

        person.setFirstName("JokowiJokowiJokowiJokowiJokowiJokowiJokowiJokowiJokowi");
        person.setLastName("JokowiJokowiJokowiJokowiJokowiJokowiJokowiJokowiJokowi");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(2, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Constraint: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value: " + violation.getInvalidValue());
            System.out.println("Path: " + violation.getPropertyPath());
        }
    }

    @Test
    void testValidationSuccess() {
        Person person = new Person();

        person.setFirstName("John");
        person.setLastName("Doe");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertEquals(0, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Constraint: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid value: " + violation.getInvalidValue());
            System.out.println("Path: " + violation.getPropertyPath());
        }
    }
}
