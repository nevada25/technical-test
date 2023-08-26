package com.ibk.spring.cloud.msvc.balances.msvcbalances.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_client")
    @NotNull
    private Long id_client;

    @ManyToOne
    @JoinColumn(name = "id_client", insertable = false, updatable = false)
    @NotNull
    private Client client;

    @OneToMany(mappedBy = "balance")
    private List<BalanceDetail> balance_details;


    @NotNull
    private BigDecimal  full_payment;


    private BigDecimal  accumulated_payment=new BigDecimal(0);


    public List<BalanceDetail> getBalance_details() {
        return balance_details;
    }

    public void setBalance_details(List<BalanceDetail> balance_details) {
        this.balance_details = balance_details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getFull_payment() {
        return full_payment;
    }

    public void setFull_payment(BigDecimal full_payment) {
        this.full_payment = full_payment;
    }

    public BigDecimal getAccumulated_payment() {
        return accumulated_payment;
    }

    public void setAccumulated_payment(BigDecimal accumulated_payment) {
        this.accumulated_payment = accumulated_payment;
    }
}
