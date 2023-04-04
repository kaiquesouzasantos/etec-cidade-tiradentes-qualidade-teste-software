export class Pattern {
    static retornaCPF(cpf) {
        return cpf.replace(/[^\d]+/g,'')
    }
}