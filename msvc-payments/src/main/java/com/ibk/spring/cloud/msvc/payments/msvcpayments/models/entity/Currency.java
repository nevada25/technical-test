package com.ibk.spring.cloud.msvc.payments.msvcpayments.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El codigo no puede estar en blanco")
    @NotNull(message = "El codigo es obligatorio")
    private String code;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @OneToMany(mappedBy = "currency")
    private List<ExchangeRate> exchange_list;

    public List<ExchangeRate> getExchange_list() {
        return exchange_list;
    }

    public void setExchange_list(List<ExchangeRate> exchange_list) {
        this.exchange_list = exchange_list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
