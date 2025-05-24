package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.CreditCardPaymentGroup;
import programmerzamannow.validation.payload.EmailErrorPayload;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest {

    @Test
    void testPayload() {
        Payment payment = new Payment();
        payment.setAmount(1_000_000L);
        payment.setOrderId("001");
        payment.setCreditCard("123");

        final Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("-------------------------------------");

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> payloadClass : payload) {
                if(payloadClass.equals(EmailErrorPayload.class)) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }
        }
    }
}
