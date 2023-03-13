export function validacao({nome, cpf, rendimentos}){
	return validaCPF(cpf) && validaPreenchimento(nome, cpf, rendimentos) && validaRendimentos(rendimentos) && validaNumero(rendimentos)

}

function validaCPF(cpf) {
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

function validaPreenchimento(nome, cpf, rendimentos){
	if(nome == null || cpf == null || rendimentos == null)
		return false
	return true
}

function validaRendimentos(rendimentos){
	return rendimentos >= 0
}

function validaNumero(numero){
	return new RegExp('^[0-9]+$').test(numero)
}