package com.ibk.spring.cloud.msvc.payments.msvcpayments.models.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "exchange_rates")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate date_registry;

    private BigDecimal amount;

    @Column(name = "id_currency")
    private Long id_currency;

    @ManyToOne
    @JoinColumn(name = "id_currency", insertable = false,updatable = false)
    private Currency currency;

/*    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Currency currency;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate_registry() {
        return date_registry;
    }

    public void setDate_registry(LocalDate date_registry) {
        this.date_registry = date_registry;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId_currency() {
        return id_currency;
    }

    public void setId_currency(Long id_currency) {
        this.id_currency = id_currency;
    }
}
