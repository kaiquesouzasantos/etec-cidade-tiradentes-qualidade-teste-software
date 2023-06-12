export class Validacao {
	constructor({nome, peso, altura}){
		this.nome = nome
		this.peso = peso
		this.altura = altura
	}

	validacao(){
		return this.validaPreenchimento() && this.validaNumericos() && this.validaIMC()
	}
	
	validaPreenchimento(){
		if(this.nome == null || this.peso == null || this.altura == null)
			return false
		return true
	}
	
	validaNumericos(){
		return this.peso > 0 || this.altura > 0
	}

	validaIMC(){
		return this.peso > this.altura
	}
}