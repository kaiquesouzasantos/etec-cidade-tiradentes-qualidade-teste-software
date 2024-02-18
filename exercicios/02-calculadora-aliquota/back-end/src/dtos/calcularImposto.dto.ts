import { IsString, IsNumber } from 'class-validator';

export class CalcularImpostoDto {
  @IsString()
  nome: string;

  @IsString()
  rendimentos: string;

  @IsString()
  cpf: string;
}
