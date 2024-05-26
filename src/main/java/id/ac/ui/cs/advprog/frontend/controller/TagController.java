package id.ac.ui.cs.advprog.frontend.controller;

import id.ac.ui.cs.advprog.frontend.model.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

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

}
