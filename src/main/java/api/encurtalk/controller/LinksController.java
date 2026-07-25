package api.encurtalk.controller;

import api.encurtalk.dto.LinkResponse;
import api.encurtalk.entities.Links;
import api.encurtalk.service.EncurtarService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


@RestController

public class LinksController {

    private final EncurtarService encurta;


    public LinksController(EncurtarService encurta){
        this.encurta = encurta;
    }

    @RequestMapping("/encurtar")
    @PostMapping
    public ResponseEntity<LinkResponse> gerarLinkEncurtado(@RequestBody Map<String, String> request){

        String linkOriginal = request.get("linkOriginal");

        Links lk = encurta.encurtaLk(linkOriginal);

        String redirectUrl = "http://localhost:8080/r/" + lk.getLinkNovo();

        LinkResponse rp = new LinkResponse(lk.getId(), lk.getHora(), lk.getLinkNovo(), lk.getLinkOriginal() , redirectUrl, lk.getQrcode());

        return ResponseEntity.status(HttpStatus.CREATED).body(rp);


    }


    @GetMapping("/r/{linkNovo}")
    public  void redirect(@PathVariable String linkNovo, HttpServletResponse resp) throws IOException {

        Links lk = encurta.obterUrlOr(linkNovo);

        if (lk != null ){
            resp.sendRedirect(lk.getLinkOriginal());
        }else{

            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }


    }





}
