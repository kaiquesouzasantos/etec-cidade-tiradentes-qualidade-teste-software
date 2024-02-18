import { Controller, Get, Query, Res } from '@nestjs/common';
import { AppService } from './app.service';
import { CalcularImpostoDto } from './dtos/calcularImposto.dto';
import { Response } from 'express';
import { validaCPF } from './utils/validaCpf';

@Controller('')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  calcularImposto(
    @Query() { cpf, nome, rendimentos }: CalcularImpostoDto,
    @Res() res: Response,
  ) {
    if (Number(rendimentos) <= 0) {
      return res.status(400).json({});
    }

    if (!validaCPF(cpf)) {
      return res.status(400).json({});
    }

    return res.json(
      this.appService.calcularImposto({ cpf, nome, rendimentos }),
    );
  }
}
