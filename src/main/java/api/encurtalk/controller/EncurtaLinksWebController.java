package api.encurtalk.controller;

import api.encurtalk.service.EncurtarService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class EncurtaLinksWebController {

    private final EncurtarService encurta;

    public EncurtaLinksWebController(EncurtarService encurta){
        this.encurta = encurta;
    }

    @GetMapping("/")
    public String webPage(){
        return "index";
    }

}
