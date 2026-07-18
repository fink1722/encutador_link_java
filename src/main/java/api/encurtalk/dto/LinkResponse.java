package api.encurtalk.dto;

import java.time.LocalDateTime;

public class LinkResponse {

    private long id;

    private String linkOriginal;

    private String linkNovo;

    private LocalDateTime hora;

    private String linkRd;


    public LinkResponse(long id, LocalDateTime hora, String linkNovo, String linkOriginal, String linkRd) {
        this.id = id;
        this.hora = hora;
        this.linkNovo = linkNovo;
        this.linkOriginal = linkOriginal;
        this.linkRd = linkRd;
    }

    public LinkResponse() {
    }

    public long getId() {
        return id;
    }

    public String getLinkRd() {
        return linkRd;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public String getLinkNovo() {
        return linkNovo;
    }

    public String getLinkOriginal() {
        return linkOriginal;
    }
}
