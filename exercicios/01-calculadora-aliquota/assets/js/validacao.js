export class Validacao {
	constructor({nome, cpf, rendimentos}){
		this.nome = nome
		this.cpf = cpf
		this.rendimentos = rendimentos
	}

	validacao(){
		return this.validaCPF() && this.validaPreenchimento() && this.validaRendimentos() && this.validaNome() && this.validaNumero()
	}

	validaCPF() {
		let cpf = this.cpf.replace(/[^\d]+/g,'')
		var numeros, digitos, soma, i, resultado, digitos_iguais;
		digitos_iguais = 1;
	
		if (cpf.length < 11)
			return false
	
		for (i = 0; i < cpf.length - 1; i++)
			if (cpf.charAt(i) != cpf.charAt(i + 1)) {
				digitos_iguais = 0
				break
			}
	
		if (!digitos_iguais) {
			numeros = cpf.substring(0, 9)
			digitos = cpf.substring(9)
			soma = 0
	
			for (i = 10; i > 1; i--)
				soma += numeros.charAt(10 - i) * i
			resultado = soma % 11 < 2 ? 0 : 11 - soma % 11
	
			if (resultado != digitos.charAt(0))
				return false
	
			numeros = cpf.substring(0, 10)
			soma = 0
	
			for (i = 11; i > 1; i--)
				soma += numeros.charAt(11 - i) * i
			resultado = soma % 11 < 2 ? 0 : 11 - soma % 11
	
			if (resultado != digitos.charAt(1))
				return false
	
			return true
		} else
			return false
	}
	
	validaPreenchimento(){
		return !(this.nome == null || this.peso == null || this.altura == null)
	}
	
	validaRendimentos(){
		return this.rendimentos >= 0
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
