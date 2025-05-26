package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.CreditCardPaymentGroup;

import java.util.Locale;
import java.util.Set;

public class MessageInternationalizationTest extends AbstractValidatorTest {

    @Test
    void testMessageI18N() {
        Locale.setDefault(new Locale("id", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("12345678901");
        payment.setAmount(10L);
        payment.setCreditCard("4111111111111111");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testMessageInterpolator() {
        Payment payment = new Payment();
        payment.setOrderId("12345678901");
        payment.setAmount(10L);

        Locale locale = new Locale("id", "ID");
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println("Path: " + violation.getPropertyPath());

            MessageInterpolatorContext context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(),
                    violation.getInvalidValue(),
                    violation.getRootBeanClass(),
                    violation.getPropertyPath(),
                    violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES,
                    true
            );

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale);
            System.out.println("Message: " + message);

            System.out.println("-------------------------------------");
        }
    }
}
