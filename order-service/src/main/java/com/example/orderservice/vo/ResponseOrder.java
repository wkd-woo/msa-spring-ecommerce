package com.example.orderservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@JsonInclude(Include.NON_NULL)
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Integer Stock;
    private Date createdAt;

    private String orderId;
}
