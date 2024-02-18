import { Pessoa } from '../model/pessoa.model.js'

export function retornaPessoa(){
    const urlParams = new URLSearchParams(window.location.search)

    return constroiPessoa(
        urlParams.get('nome'), urlParams.get('peso'), urlParams.get('altura')
    )
}

function constroiPessoa(nome, peso, altura) {
    return new Pessoa(nome, peso, altura)
}