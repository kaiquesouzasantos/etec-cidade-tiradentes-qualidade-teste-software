import { Validacao } from './component/validacao.pessoa.js'
import { Requester } from './component/requester.pessoa.js'

document.getElementById('indice').addEventListener('mouseover', () => {
    let pessoa = Requester.retornaPessoa()

    if(!new Validacao(pessoa).validacao())
        window.location.href = 'http://127.0.0.1:5500/03/front-end/index.html'
    else
        carregaInformacoesPessoa(pessoa)
})

function carregaInformacoesPessoa(pessoa){
    document.getElementById('nome').value = pessoa.nome
    document.getElementById('peso').value = pessoa.peso + ' Kg'
    document.getElementById('altura').value = pessoa.altura + ' M'
    document.getElementById('imc').value = pessoa.imc
    document.getElementById('estado').value = pessoa.estado
}
