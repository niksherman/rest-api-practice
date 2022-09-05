package com.example.models;

import java.math.BigDecimal;
public class ChangeListPrice {
    private final String userId;
    private final String productId;
    private final BigDecimal changeListPrice;

    public ChangeListPrice(String userId, String productId, BigDecimal changeListPrice) {
        this.userId = userId;
        this.productId = productId;
        this.changeListPrice = changeListPrice;
    }

    public String getUserId() {
        return userId;
    }
    public String getProductId() {
        return productId;
    }
    public BigDecimal getChangeListPrice() {
        return changeListPrice;
    }
}
