import { Pessoa } from '../model/pessoa.model.js'

export class Requester {
  static async retornaUsuarioViaURL() {
    const urlParams = new URLSearchParams(window.location.search)

    return await this.retornaPessoa(
        urlParams.get('nome'), urlParams.get('peso'), urlParams.get('altura')
    )
  }

  static async retornaPessoa(nome, peso, altura) {
    const url = 'http://localhost:8080/imc';
    return (await fetch(`${url}?nome=${nome}&peso=${peso}&altura=${altura}`)).json()
  }
}
