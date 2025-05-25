package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidatorTest {

    @Test
    void testSayHello() throws NoSuchMethodException {
        Person person = new Person();
        String name = "";

        Method method = Person.class.getMethod("sayHello", String.class);
        Set<ConstraintViolation<Person>> violations = executableValidator.validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("--------------");
        }
    }

    @Test
    void testFullName() throws NoSuchMethodException {
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");

        String returnValue = person.getFullname();
        Method method = Person.class.getMethod("getFullname");
        Set<ConstraintViolation<Person>> violations = executableValidator.validateReturnValue(person, method, returnValue);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("--------------");
        }
    }
}
