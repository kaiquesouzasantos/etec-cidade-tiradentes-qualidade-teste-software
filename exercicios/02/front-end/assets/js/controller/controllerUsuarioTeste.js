import { Requester } from '../components/requester.js'
import { CasoTeste } from '../model/CasoTeste.js'
import { CASOS_TESTE } from '../test/casosTeste.js'

export class ControllerTeste {
    static executaTestes() {
        CASOS_TESTE.forEach(
            (casoTeste) => carregaInformacoesTeste(casoTeste)
        )
    }

    carregaInformacoesTeste(teste) {
        const resultadoTeste = this.verificaResultadoTeste(teste)

        try {
            document.getElementById('form-teste').innerHTML += 
            '\
            <div class="mb-3 col-4 input-group flex-nowrap">\
                <span class="input-group-text" id="addon-wrapping">'+resultadoTeste+'</span>\
                <input type="text" class="form-control" placeholder="'+teste.nome+'" aria-describedby="addon-wrapping" readonly>\
            </div>\
            '
        } catch (e) {}
    }

    verificaResultadoTeste(teste) {
        const resultadoUsuario = Requester.retornaUsuario(teste.nome, teste.cpf, teste.rendimentos)
        return teste.rendimentosEsperado == resultadoUsuario.rendimentos ? 'Passou' : 'Falhou'
    } 
}