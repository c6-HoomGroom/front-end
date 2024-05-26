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
@RequestMapping("/tags")
public class TagController {

    @GetMapping("")
    public String goToTagPage(Model model) throws URISyntaxException {
        URI url = new URI("https://product-service-uflspwyoiq-ew.a.run.app/tags/api");
        RestTemplate restTemplate = new RestTemplate();
        Tag[] tags = restTemplate.getForObject(url, Tag[].class);
        model.addAttribute("tags", tags);
        return "tagPage";
    }

    @PostMapping("")
    public String createTagPost(@ModelAttribute Tag tag) {
        RestTemplate restTemplate = new RestTemplate();
        String endpointUrl = "https://product-service-uflspwyoiq-ew.a.run.app/tags/api";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", tag.getName());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(endpointUrl, HttpMethod.POST, entity, String.class);

        return "redirect:/tags";
    }

    @GetMapping("/add")
    public String createTagPage(Model model) {
        Tag tag = new Tag();
        model.addAttribute("tag", tag);
        return "tagCreate";
    }

    @PostMapping("/delete")
    public String deleteTag(@RequestParam("tagId") String tagId) {
        String apiUrl = "https://product-service-uflspwyoiq-ew.a.run.app/tags/api/delete/" + tagId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(apiUrl);
        return "redirect:/tags";
    }

}
