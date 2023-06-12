export class Validacao {
	constructor({nome, peso, altura}){
		this.nome = nome
		this.peso = peso
		this.altura = altura
	}

	validacao(){
		return this.validaPreenchimento() && this.validaNumericos() && this.validaIMC() && this.validaNome() && this.validaNumero()
	}
	
	validaPreenchimento(){
		return !(this.nome == null || this.peso == null || this.altura == null)
	}
	
	validaNumericos(){
		return this.peso > 0 || this.altura > 0
	}

	validaIMC(){
		return parseFloat(this.peso) > parseFloat(this.altura)
	}

	validaNome(){
		let pattern = /^[a-zA-Z\s]+$/
		return pattern.test(this.nome) 
	}

	validaNumero(){
		let pattern = /^\d+(\.\d+)?$/
		return pattern.test(this.peso) && pattern.test(this.altura)
	}
}