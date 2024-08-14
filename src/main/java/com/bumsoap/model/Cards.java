package com.bumsoap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter @Setter
@Table(name="cards")
public class Cards {
    @Id
    private long card_id;
    private String cardNumber;
    private long customerId;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
    private Date createDt;
}
