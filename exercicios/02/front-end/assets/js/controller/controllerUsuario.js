import { Requester } from '../components/requester.js'

export class ControllerUsuario {
    static retornaUsuario() {
        let usuario = Requester.retornaUsuarioViaURL()

        try {
            carregaInformacoesUsuario(usuario)
        } catch(e){
            console.log(usuario)
            // window.location.href = 'http://127.0.0.1:5500/index.html'
        }   
    }

    carregaInformacoesUsuario(usuario) {
        try {
            document.getElementById('txtNome').value = usuario.nome
            document.getElementById('txtCPF').value = usuario.cpf
            document.getElementById('txtRendimentos').value = 'R$'+usuario.rendimentos
            document.getElementById('txtAliquota').value = usuario.aliquota+'%'
            document.getElementById('txtParcela').value = 'R$'+usuario.parcela
        } catch (e) {}
    }
}