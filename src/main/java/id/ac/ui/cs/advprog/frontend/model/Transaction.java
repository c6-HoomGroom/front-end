package id.ac.ui.cs.advprog.frontend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Transaction {
    private UUID id;
    private UUID productId;
    private UUID userId;
    private UUID promoCodeId;
    private int quantity;
    private double totalPrice;
    private String deliveryStatus;
}