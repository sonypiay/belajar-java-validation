package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

public class ConstructorValidationTest extends AbstractValidatorTest {

    @Test
    void testConstructorParameters() throws NoSuchMethodException {
        Person person = new Person();
        String firstName = "";
        String lastName = "";
        Address address = new Address();

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);
        Set<ConstraintViolation<Object>> violations = executableValidator.validateConstructorParameters(constructor, new Object[]{firstName, lastName, address});

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("--------------");
        }
    }

    @Test
    void testConstructorValidationReturnValue() throws NoSuchMethodException {
        String firstName = "";
        String lastName = "";
        Address address = new Address();
        Person person = new Person(firstName, lastName, address);

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);
        Set<ConstraintViolation<Object>> violations = executableValidator.validateConstructorReturnValue(constructor, person);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("--------------");
        }
    }
}
