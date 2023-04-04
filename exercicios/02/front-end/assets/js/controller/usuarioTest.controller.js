import { Requester } from '../components/usuario.requester.js'
import { CASOS_TESTE } from '../test/casosTest.list.js'

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
        if(this.verificaResultadoTeste(teste)) 
            this.exibeInformacoesTeste(teste.nomeTeste, 'Passou', '#149c68')
        else
            this.exibeInformacoesTeste(teste.nomeTeste, 'Falhou', 'red')
    }

    static exibeInformacoesTeste(nomeTeste, resultado, cor) {
        try {
            document.getElementById('form-teste').innerHTML += 
            '\
            <div class="mb-3 col-4 input-group flex-nowrap">\
                <span class="input-group-text" id="addon-wrapping" style="background-color: '+cor+';">'+resultado+'</span>\
                <input type="text" class="form-control" placeholder="'+nomeTeste+'" aria-describedby="addon-wrapping" readonly>\
            </div>\
            '
        } catch (e) {}
    }

    static async verificaResultadoTeste(teste) {
        return await teste.parcelaEsperada == Requester.retornaUsuario(teste.nome, teste.cpf, teste.rendimentos).parcela
    } 
}