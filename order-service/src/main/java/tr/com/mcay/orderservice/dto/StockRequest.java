package tr.com.mcay.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRequest {

    private Long productId;
    private Integer quantity;

    public StockRequest() {
    }

    public StockRequest(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "StockRequest{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
