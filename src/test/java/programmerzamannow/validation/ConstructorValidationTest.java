package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

public class ConstructorValidationTest extends AbstractValidatorTest {

    @Test
    void testConstructorValidationTest() throws NoSuchMethodException {
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
}
