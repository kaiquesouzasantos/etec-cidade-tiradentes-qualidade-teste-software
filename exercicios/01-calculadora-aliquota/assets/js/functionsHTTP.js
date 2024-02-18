import { Usuario } from './usuario.js'

export function retornaUsuario(){
    const urlParams = new URLSearchParams(window.location.search)

    return constroiUsuario(
        urlParams.get('txtNome'), urlParams.get('txtCPF'), urlParams.get('numberRendimentos')
    )
}

function constroiUsuario(nome, cpf, rendimentos) {
    return new Usuario(nome, cpf, rendimentos)
}