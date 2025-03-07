package com.bumsoap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter @Setter
@Table(name = "contact_messages")
public class Contact {
    @Id
    private String contactId;
    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
    private Date createDt;
}
