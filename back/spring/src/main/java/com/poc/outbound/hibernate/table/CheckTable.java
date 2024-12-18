package com.poc.outbound.hibernate.table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class CheckTable {

    @Id
    String id;

    String plate;

    @Column(name = "check_in_date")
    LocalDateTime checkInDate;

    @Column(name = "check_out_date")
    LocalDateTime checkOutDate;

    BigDecimal fare;

    String location;

}
