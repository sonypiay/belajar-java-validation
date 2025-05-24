package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.PaymentGroup;

public class GroupSequenceTest extends AbstractValidatorTest {

    @Test
    void testGroupSequence() {
        Payment payment = new Payment();
        payment.setOrderId("1234567890");
        payment.setAmount(1000L);
        payment.setCreditCard("4111111111111111");

        validateWithGroups(payment, PaymentGroup.class);
    }
}
