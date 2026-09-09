package bank_project.dto;

import jakarta.persistence.PrePersist;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
    private Long transactionId;
    private BigDecimal amount;
    private String type;
    private String status;
    private LocalDateTime createdAt;
    public TransactionResponse(){}

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public TransactionResponse(BigDecimal amount, Long transactionId,String type, String status,LocalDateTime createdAt) {
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.createdAt=createdAt;
        this.transactionId=transactionId;
    }


}
