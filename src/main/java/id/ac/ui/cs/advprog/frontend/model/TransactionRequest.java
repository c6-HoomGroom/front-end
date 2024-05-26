package id.ac.ui.cs.advprog.frontend.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class TransactionRequest {
    private UUID productId;
    private int quantity;
    private UUID voucherId;
    private UUID userId;

    @Override
    public String toString() {
        return "{" +
                "productId:" + productId +
                ", quantity:" + quantity +
                ", voucherId:" + voucherId +
                ", userId:" + userId +
                '}';
    }
}
