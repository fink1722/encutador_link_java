package api.encurtalk.service;


import api.encurtalk.entities.Links;
import api.encurtalk.repository.LinksRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class EncurtarService {

    private final LinksRepository linkRp;

    public EncurtarService(LinksRepository linkRp ){
        this.linkRp = linkRp;
    }


    public String randomNum(){
        String af = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < 5; i++){

            int indice = random.nextInt(af.length());
            resultado.append(af.charAt(indice));


        }
        String urlNova = resultado.toString();
        return  urlNova;

    }

    public Links encurtaLk(String linkOriginal){
        Links links = new Links();

        links.setLinkOriginal(linkOriginal);
        links.setLinkNovo(randomNum());
        links.setHora(LocalDateTime.now());

        return linkRp.save(links);
    }

   public Links obterUrlOr(String linkNovo){

        try{
            return linkRp.findByLinkNovo(linkNovo).orElse(null);

        } catch (Exception e) {
            throw new RuntimeException("Url inexistente", e);
        }




   }


}
