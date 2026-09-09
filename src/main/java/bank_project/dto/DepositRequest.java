package bank_project.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DepositRequest {
    @DecimalMin(value = "0.01")
    @NotNull
    private BigDecimal amount;
    public void setAmount(BigDecimal amount){
        this.amount=amount;
    }
    public BigDecimal getAmount(){
        return amount;
    }


}
