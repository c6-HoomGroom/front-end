package id.ac.ui.cs.advprog.frontend.controller;

import id.ac.ui.cs.advprog.frontend.model.Product;
import id.ac.ui.cs.advprog.frontend.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @GetMapping("/")
    public String goToHomePage(Model model) {
        return "homePage";
    }

    @GetMapping("/test")
    public String goToTestPage(Model model) {
        return "testPage";
    }

    @GetMapping("/all")
    public String goToTransactionPage(Model model) {
        return "transactionPage";
    }

    @GetMapping("/buy/{id}")
    public String showPurchasePage(@PathVariable("id") UUID productId, Model model) {
        System.out.println(productId);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://product-service-uflspwyoiq-ew.a.run.app/products/api/id/" + productId;
        Product product = restTemplate.getForObject(url, Product.class);
        model.addAttribute("product", product);
        return "purchasePage";
    }

    @GetMapping("/edit/{id}")
    public String editTransactionPage(@PathVariable("id") UUID transactionId, Model model) {
        System.out.println(transactionId);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://transaction-service-uflspwyoiq-ew.a.run.app/transactions/id/" + transactionId;
        Transaction transaction = restTemplate.getForObject(url, Transaction.class);
        model.addAttribute("transaction", transaction);
        return "editTransactionPage";
    }
}
