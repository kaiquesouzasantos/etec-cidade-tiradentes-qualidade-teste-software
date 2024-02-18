import { calculaAliquota } from './calculaAliquota';

describe('calcula aliquota', () => {
  it('should return 0 to incomes less than 22847.76', () => {
    const result = calculaAliquota(210);
    expect(result).toBe(0);
  });

  it('should return 7.5 to incomes between 22847.77 and 33919.8', () => {
    const result = calculaAliquota(31154);
    expect(result).toBe(7.5);
  });

  it('should return 15  to incomes between 33919.81 and 45012.6', () => {
    const result = calculaAliquota(37749);
    expect(result).toBe(15);
  });

  it('should return 22.5  to incomes between 45012.61 and 55976.16', () => {
    const result = calculaAliquota(51022);
    expect(result).toBe(22.5);
  });

  it('should return 27.5  to incomes greater 55976.16', () => {
    const result = calculaAliquota(151022);
    expect(result).toBe(27.5);
  });
});
