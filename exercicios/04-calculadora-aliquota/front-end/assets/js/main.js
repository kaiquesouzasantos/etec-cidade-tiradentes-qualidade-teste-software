import { ControllerUsuario } from "./controller/usuario.controller.js";
import { ControllerTeste } from "./controller/usuarioTest.controller.js";

document.getElementById("body-aliquota")?.addEventListener("mouseover", () => {
  ControllerUsuario.retornaUsuario();
})

document.getElementById("body-teste")?.addEventListener("mouseover", () => {
  ControllerTeste.executaTestes();
})
