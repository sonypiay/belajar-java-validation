package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.PaymentGroup;
import programmerzamannow.validation.group.VirtualAccountPaymentGroup;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {
        Payment payment = new Payment();
        payment.setOrderId("12345678901");
        payment.setAmount(10L);
        payment.setVirtualAccount("12345678");

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
