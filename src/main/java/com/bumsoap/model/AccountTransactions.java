package com.bumsoap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name="account_transactions")
public class AccountTransactions {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;
    private long accountNumber;
    private long customerId;
    private Date transactionDt;
    private String transactionSummary;
    private String transactionType;
    private int transactionAmt;
    private int closingBalance;
    private Date createAt;
}
