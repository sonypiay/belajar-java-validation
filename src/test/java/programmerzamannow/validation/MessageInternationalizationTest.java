package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.CreditCardPaymentGroup;

import java.util.Locale;

public class MessageInternationalizationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {
        Locale.setDefault(new Locale("id", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("12345678901");
        payment.setAmount(10L);
        payment.setCreditCard("4111111111111111");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
