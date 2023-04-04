export function calculaParcela(rendimentos: number, aliquota: number) {
  return ((rendimentos / 100) * aliquota).toFixed(2);
}
