package id.ac.ui.cs.advprog.frontend.controller;

import id.ac.ui.cs.advprog.frontend.model.Product;
import id.ac.ui.cs.advprog.frontend.model.Tag;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @GetMapping("")
    public String goToProductPage(Model model) throws URISyntaxException {
        URI url = new URI("https://product-service-uflspwyoiq-ew.a.run.app/products/api");
        RestTemplate restTemplate = new RestTemplate();
        Product[] products = restTemplate.getForObject(url, Product[].class);
        model.addAttribute("products", products);
        return "productPage";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable("id") String id, Model model) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        URI productUrl = new URI("https://product-service-uflspwyoiq-ew.a.run.app/products/api/id/" + id);
        Product product = restTemplate.getForObject(productUrl, Product.class);
        model.addAttribute("product", product);

        URI url = new URI("https://product-service-uflspwyoiq-ew.a.run.app/tags/api");
        Tag[] tags = restTemplate.getForObject(url, Tag[].class);
        model.addAttribute("allTags", tags);
        return "productEdit";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product, @RequestParam(value = "tagNames", required = false) String tagNames) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String endpointUrl = "https://product-service-uflspwyoiq-ew.a.run.app/products/api";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", product.getId());
        requestBody.put("name", product.getName());
        requestBody.put("description", product.getDescription());
        requestBody.put("image", product.getImage());
        requestBody.put("price", product.getPrice());
        requestBody.put("discountPrice", product.getDiscountPrice());

        Set<Tag> selectedTags = new HashSet<>();
        if (tagNames != null && !tagNames.isEmpty()) {
            String[] tags = tagNames.split(",");

            for (String tagName : tags) {
                URI url = new URI("https://product-service-uflspwyoiq-ew.a.run.app/tags/api/name/" + tagName);
                Tag tag = restTemplate.getForObject(url, Tag.class);
                if (tag != null) {
                    selectedTags.add(tag);
                }
            }

            requestBody.put("tags", selectedTags);
        }

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(endpointUrl, HttpMethod.POST, entity, String.class);
        return "redirect:/products";
    }

}
