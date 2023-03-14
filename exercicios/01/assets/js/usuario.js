export class Usuario {
    constructor(nome, cpf, rendimentos){
        this.nome = nome
        this.cpf = cpf
        this.rendimentos = rendimentos
        this.aliquota = this.calculaAliquota()
        this.parcela = this.calculaParcela()
    }

    calculaAliquota() {
        if(this.rendimentos <= 22847.76){
            return 0
        } else if(this.rendimentos >= 22847.77 && this.rendimentos <= 33919.80){
            return 7.5
        } else if(this.rendimentos >= 33919.81 && this.rendimentos <= 45012.60){
            return 15
        } else if(this.rendimentos >= 45012.61 && this.rendimentos <= 55976.16){
            return 22.5
        } else {
            return 22.7
        }
    }

    calculaParcela(){
        return ((this.rendimentos/100) * this.aliquota).toFixed(2)
    }
}