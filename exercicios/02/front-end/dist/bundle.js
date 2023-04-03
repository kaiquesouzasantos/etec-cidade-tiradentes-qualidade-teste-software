(() => {
    "use strict";
    class e {
        static retornaCPF(e) {
            return e.replace(/[^\d]+/g, "")
        }
    }
    class t {
        static async retornaUsuarioViaURL() {
            const t = new URLSearchParams(window.location.search);
            return await this.retornaUsuario(t.get("txtNome"), e.retornaCPF(t.get("txtCPF")), t.get("numberRendimentos"))
        }
        static async retornaUsuario(e, t, a) {
            const n = await fetch(`https://server-imposto-renda-production.up.railway.app/?nome=${e}&rendimentos=${a}&cpf=${t}`);
            return await n.json()
        }
    }
    class a {
        static async retornaUsuario() {
            let e = await t.retornaUsuarioViaURL();
            document.getElementById("txtNome").value = e.nome, document.getElementById("txtCPF").value = e.cpf, document.getElementById("txtRendimentos").value = e.rendimentos, document.getElementById("txtAliquota").value = e.aliquota, document.getElementById("txtParcela").value = e.parcela
        }
    }
    class n {
        constructor(e, t, a, n, s) {
            this.nomeTeste = e, this.nome = t, this.cpf = a, this.rendimentos = n, this.rendimentosEsperado = s
        }
    }
    const s = "08125461051",
        o = [new n("Teste de campos preenchidos", "", "", ""), new n("Consulta com renda invalida", "teste", -1, s), new n("Consulta com CPF invalido", "teste", 0, "00000000000"), new n("Consulta taxa isenta", "teste", 22e3, s), new n("Consulta taxa 7,5%", "teste", 23e3, s), new n("Consulta taxa 15%", "teste", 34e3, s), new n("Consulta taxa  22,5%", "teste", 46e3, s), new n("Consulta taxa 27,5%", "teste", 6e4, s)];
    class r {
        static executaTestes() {
            o.forEach((e => carregaInformacoesTeste(e)))
        }
        carregaInformacoesTeste(e) {
            const t = this.verificaResultadoTeste(e);
            try {
                document.getElementById("form-teste").innerHTML += '            <div class="mb-3 col-4 input-group flex-nowrap">                <span class="input-group-text" id="addon-wrapping">' + t + '</span>                <input type="text" class="form-control" placeholder="' + e.nome + '" aria-describedby="addon-wrapping" readonly>            </div>            '
            } catch (e) {}
        }
        verificaResultadoTeste(e) {
            const a = t.retornaUsuario(e.nome, e.cpf, e.rendimentos);
            return e.rendimentosEsperado == a.rendimentos ? "Passou" : "Falhou"
        }
    }
    const i = document.getElementById("body-aliquota");
    i ? i.addEventListener("mouseover", (() => {
        a.retornaUsuario()
    })) : console.log("NO body aliquota");
    const c = document.getElementById("body-teste");
    c && c.addEventListener("mouseover", (() => {
        r.executaTestes()
    }))
})();