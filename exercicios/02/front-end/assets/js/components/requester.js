import { Pattern } from "./pattern.js"

export class Requester {
  static async retornaUsuarioViaURL() {
    const urlParams = new URLSearchParams(window.location.search)

    return await this.retornaUsuario(
      urlParams.get("txtNome"),
      Pattern.retornaCPF(urlParams.get("txtCPF")),
      urlParams.get("numberRendimentos")
    )
  }

  static async retornaUsuario(nome, cpf, rendimentos) {
    const response = await fetch(
      `https://server-imposto-renda-production.up.railway.app/?nome=${nome}&rendimentos=${rendimentos}&cpf=${cpf}`
    )

    return await response.json()
  }
}
