package bank_project.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class WithdrawalRequest {
    @DecimalMin(value = "0.01")
    @NotNull
    private BigDecimal amount;

    public WithdrawalRequest() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public WithdrawalRequest(BigDecimal amount) {
        this.amount = amount;
    }
}
