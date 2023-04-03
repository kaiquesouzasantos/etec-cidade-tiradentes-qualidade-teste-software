import { Requester } from '../components/requester.js'
import { CasoTeste } from '../model/CasoTeste.js'
import { CASOS_TESTE } from '../test/casosTeste.js'

let CONTADOR = false

export class ControllerTeste {
    static executaTestes() {
        if(!CONTADOR)
            CASOS_TESTE.forEach(
                (casoTeste) => ControllerTeste.carregaInformacoesTeste(casoTeste)
            )
            
            CONTADOR = true
    }

    static carregaInformacoesTeste(teste) {
        const resultadoTeste = this.verificaResultadoTeste(teste)

        try {
            document.getElementById('form-teste').innerHTML += 
            '\
            <div class="mb-3 col-4 input-group flex-nowrap">\
                <span class="input-group-text" id="addon-wrapping">'+resultadoTeste+'</span>\
                <input type="text" class="form-control" placeholder="'+teste.nomeTeste+'" aria-describedby="addon-wrapping" readonly>\
            </div>\
            '
        } catch (e) {}
    }

    static verificaResultadoTeste(teste) {
        const resultadoUsuario = Requester.retornaUsuario(teste.nome, teste.cpf, teste.rendimentos)
        return teste.rendimentosEsperado == resultadoUsuario.rendimentos ? 'Passou' : 'Falhou'
    } 
}