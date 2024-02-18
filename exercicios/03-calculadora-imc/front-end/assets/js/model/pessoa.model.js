export class Pessoa {
    constructor(nome, peso, altura){
        this.nome = nome
        this.peso = peso
        this.altura = altura
    }

    calculaIMC(){
        return (this.peso / (this.altura * this.altura)).toFixed(2)
    }

    estadoIMC(){
        let imc = this.calculaIMC()
        
        if(imc <= 0) 
            return "N/A"

        if (imc < 18.5) {
            return "Magreza"
        } else if (imc >= 18.5 && imc < 25) {
            return "Peso Normal";
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso"
        } else if (imc >= 30 && imc < 35) {
            return "Obesidade Grau I"
        } else if (imc >= 35 && imc < 40) {
            return "Obesidade Grau II"
        } else if (imc >= 40){
            return "Obesidade Grau III"
        }
    }
}