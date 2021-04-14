package com.example.payment.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    private Long id;
    private Long supplier_id;
    private Long account;
    private Double amount;
    private Date date;
}
