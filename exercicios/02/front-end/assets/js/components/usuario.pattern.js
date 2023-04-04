export class Pattern {
    static retornaCPF(cpf) {
        return cpf.replace(/[^\d]+/g,'')
    }

    static retornaNumero(numero) {
        return numero.replace(/[^\d]+/g,'')
    }
}