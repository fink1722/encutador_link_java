const botao = document.getElementById("btnEnviar");


botao.addEventListener("click", enviar);

function enviar(){
    const link = document.getElementById("link").value;
    console.log(link);

    fetch("http://localhost:8080/encurtar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            linkOriginal: link
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro: " + response.status);
            }
            return response.json();
        })
        .then(dados => {

            resultado.innerHTML = `
                <h3>Link encurtado!</h3>

                <a href="http://localhost:8080/r/${dados.linkNovo}" target="_blank">
                http://localhost:8080/r/${dados.linkNovo}
                </a>
            `;



        })
        .catch(erro => {
            console.error(erro);
        });
}


