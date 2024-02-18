export function calculaAliquota(rendimentos: number) {
  if (rendimentos <= 22847.76) {
    return 0;
  } else if (rendimentos >= 22847.77 && rendimentos <= 33919.8) {
    return 7.5;
  } else if (rendimentos >= 33919.81 && rendimentos <= 45012.6) {
    return 15;
  } else if (rendimentos >= 45012.61 && rendimentos <= 55976.16) {
    return 22.5;
  } else {
    return 27.5;
  }
}
