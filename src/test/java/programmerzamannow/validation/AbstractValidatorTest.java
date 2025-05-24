package programmerzamannow.validation;

import jakarta.validation.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class AbstractValidatorTest {

    protected ValidatorFactory validatorFactory;

    protected Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void validate(Object object) {
        final Set<ConstraintViolation<Object>> violations = validator.validate(object);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("-------------------------------------");
        }
    }

    void validateWithGroups(Object object, Class<?>... groups) {
        final Set<ConstraintViolation<Object>> violations = validator.validate(object, groups);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("-------------------------------------");
        }
    }
}
