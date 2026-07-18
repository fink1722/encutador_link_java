package api.encurtalk.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Links {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String linkOriginal;

    private String linkNovo;

    private LocalDateTime hora;


    public String getLinkNovo() {
        return linkNovo;
    }

    public void setLinkNovo(String linkNovo) {
        this.linkNovo = linkNovo;
    }

    public long getId() {
        return id;
    }


    public String getLinkOriginal() {
        return linkOriginal;
    }

    public void setLinkOriginal(String linkOriginal) {
        this.linkOriginal = linkOriginal;
    }


    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora){
        this.hora = hora;
    }

}
