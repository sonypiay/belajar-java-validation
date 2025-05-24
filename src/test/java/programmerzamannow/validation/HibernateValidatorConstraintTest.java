package programmerzamannow.validation;

import org.junit.jupiter.api.Test;

public class HibernateValidatorConstraintTest extends AbstractValidatorTest {

    @Test
    void testHibernateValidatorConstraintFailed() {
        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setOrderId("1234567890");
        payment.setCreditCard("433");

        validate(payment);
    }

    @Test
    void testHibernateValidatorConstraintSuccess() {
        Payment payment = new Payment();
        payment.setAmount(10_000L);
        payment.setOrderId("1234567890");
        payment.setCreditCard("4111111111111111");

        validate(payment);
    }
}
