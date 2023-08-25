package com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "balance_details")
public class BalanceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_balance")
    private Long id_balance;

    @ManyToOne
    @JoinColumn(name = "id_balance", insertable = false, updatable = false)
    private Balance balance;

    private BigDecimal amount_payment;

    private LocalDate date_registry;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_balance() {
        return id_balance;
    }

    public void setId_balance(Long id_balance) {
        this.id_balance = id_balance;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public BigDecimal getAmount_payment() {
        return amount_payment;
    }

    public void setAmount_payment(BigDecimal amount_payment) {
        this.amount_payment = amount_payment;
    }

    public LocalDate getDate_registry() {
        return date_registry;
    }

    public void setDate_registry(LocalDate date_registry) {
        this.date_registry = date_registry;
    }
}
