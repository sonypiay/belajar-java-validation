package programmerzamannow.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import programmerzamannow.validation.group.CreditCardPaymentGroup;
import programmerzamannow.validation.group.VirtualAccountPaymentGroup;
import programmerzamannow.validation.payload.EmailErrorPayload;

public class Payment {

    @NotBlank(message = "Order ID cannot blank", groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private String orderId;

    @NotNull(
            message = "Amount cannot null",
            groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
    )
    @Range(
            min = 10_000L, max = 100_000_000L,
            message = "Amount must be between 10.000 and 100.000.000",
            groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
    )
    private Long amount;

    @LuhnCheck(
            message = "Credit card number is invalid",
            groups = {CreditCardPaymentGroup.class},
            payload = {EmailErrorPayload.class}
    )
    @NotBlank(
            message = "Credit card cannot blank",
            groups = {CreditCardPaymentGroup.class}
    )
    private String creditCard;

    @NotBlank(
            message = "Virtual account cannot blank",
            groups = {VirtualAccountPaymentGroup.class}
    )
    private String virtualAccount;

    @Valid
    @NotNull(
            message = "Customer cannot blank",
            groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
    )
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
