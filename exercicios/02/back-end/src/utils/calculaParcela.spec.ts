import { calculaParcela } from './calculaParcela';

describe('calculaParcela', () => {
  it('should calculate the correct installment for a 0% aliquot', () => {
    const resultado = calculaParcela(30000, 0);
    expect(resultado).toBe('0.00');
  });

  it('should calculate the correct installment for a 7.5% aliquot', () => {
    const resultado = calculaParcela(30000, 7.5);
    expect(resultado).toBe('2250.00');
  });

  it('should calculate the correct installment for a 15% aliquot', () => {
    const resultado = calculaParcela(40000, 15);
    expect(resultado).toBe('6000.00');
  });

  it('should calculate the correct installment for a 22.5% aliquot', () => {
    const resultado = calculaParcela(50000, 22.5);
    expect(resultado).toBe('11250.00');
  });

  it('should calculate the correct installment for a 27.5% aliquot', () => {
    const resultado = calculaParcela(70000, 27.5);
    expect(resultado).toBe('19250.00');
  });
});
