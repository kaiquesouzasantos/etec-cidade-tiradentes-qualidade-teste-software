import { Requester } from "../components/usuario.requester.js";

export class ControllerUsuario {
    static async retornaUsuario() {
        let usuario = await Requester.retornaUsuarioViaURL()

        if(usuario.aliquota != null)
            this.carregaInformacoesUsuario(usuario)
        else 
            window.location.href = 'http://127.0.0.1:5500/index.html'
    }

    static carregaInformacoesUsuario(usuario) {
        try {
            document.getElementById('txtNome').value = usuario.nome
            document.getElementById('txtCPF').value = usuario.cpf
            document.getElementById('txtRendimentos').value = usuario.rendimentos
            document.getElementById('txtAliquota').value = usuario.aliquota
            document.getElementById('txtParcela').value = usuario.parcela
        } catch (e) {}
    }
}
