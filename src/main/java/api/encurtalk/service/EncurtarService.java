package api.encurtalk.service;


import api.encurtalk.entities.Links;
import api.encurtalk.repository.LinksRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.Base64;
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

    public static String gerarQrcode(String texto, int largura, int altura) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, largura, altura);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

            byte[] pngBytes = outputStream.toByteArray();
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(pngBytes);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar QR Code", e);
        }
    }



    public Links encurtaLk(String linkOriginal){
        Links links = new Links();

        links.setLinkOriginal(linkOriginal);
        links.setLinkNovo(randomNum());
        links.setHora(LocalDateTime.now());
        links.setQrcode(gerarQrcode(linkOriginal, 250, 250));

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
