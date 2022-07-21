package com.example.catalogservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@JsonInclude(Include.NON_NULL)
public class ResponseCatalog {

    private String productId;
    private Integer qty;
    private Integer Stock;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createdAt;
}
