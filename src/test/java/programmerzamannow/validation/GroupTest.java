package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.CreditCardPaymentGroup;
import programmerzamannow.validation.group.VirtualAccountPaymentGroup;

public class GroupTest extends AbstractValidatorTest {

    @Test
    void testCreditCardPaymentGroup() {
        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setCreditCard("123");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testVirtualAccountPaymentGroup() {
        Payment payment = new Payment();
        payment.setAmount(1000L);
        payment.setVirtualAccount(null);

        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
