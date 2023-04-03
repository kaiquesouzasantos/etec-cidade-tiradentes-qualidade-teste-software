import { Pattern } from "./pattern.js"

export class Requester {
    static retornaUsuarioViaURL() {
        const urlParams = new URLSearchParams(window.location.search)

        return this.retornaUsuario(
            urlParams.get('txtNome'), Pattern.retornaCPF(urlParams.get('txtCPF')), urlParams.get('numberRendimentos')
        )
    }

    static async retornaUsuario(nome, cpf, rendimentos) {
        return new Promise(async (resolve, reject) => {
            const response = await fetch(
                `https://server-imposto-renda-production.up.railway.app/?nome=${nome}&rendimentos=${rendimentos}&cpf=${cpf}`
            )
      
            const value = await response.json();  
            return resolve();
        });
    }
}