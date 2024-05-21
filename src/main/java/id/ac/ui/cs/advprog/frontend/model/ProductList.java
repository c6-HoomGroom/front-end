package id.ac.ui.cs.advprog.frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductList {
    @JsonProperty("allProducts") // Adjust name if different in response
    private List<Product> products;
}
