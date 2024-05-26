package id.ac.ui.cs.advprog.frontend.controller;

import id.ac.ui.cs.advprog.frontend.model.Product;
import id.ac.ui.cs.advprog.frontend.model.ProductList;
import id.ac.ui.cs.advprog.frontend.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("")
public class HomeController {
    @GetMapping("/")
    public String goToHomePage(Model model){
        return "homePage";
    }

    @GetMapping("/test")
    public String goToTestPage(Model model){
        return "testPage";
    }

    @GetMapping("/products")
    public String goToProductPage(Model model) throws URISyntaxException {
        URI url = new URI("https://product-service-uflspwyoiq-ew.a.run.app/products/api");
        RestTemplate restTemplate = new RestTemplate();
        Product[] products = restTemplate.getForObject(url, Product[].class);
        model.addAttribute("products", products);
        return "productPage";
    }

}

