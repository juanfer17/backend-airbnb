package com.flypass.prueba.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestTransactionCreateDTO {
    private String name;
    private String ubication;
    private Boolean availability;
    private String imgUrl;
    private BigDecimal price;
}
