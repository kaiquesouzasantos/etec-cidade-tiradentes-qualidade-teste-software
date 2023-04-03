import { ControllerUsuario } from "./controller/controllerUsuario.js";
import { ControllerTeste } from "./controller/controllerUsuarioTeste.js";

document.getElementById("body-aliquota")?.addEventListener("mouseover", () => {
  ControllerUsuario.retornaUsuario();
})

document.getElementById("body-teste")?.addEventListener("mouseover", () => {
  ControllerTeste.executaTestes();
})
