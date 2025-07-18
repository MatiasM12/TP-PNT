import { buscarPorId } from "../service/pais.js";

const bodyTablaPais = document.getElementById("bodyTablaPais");
const spanIdPaisEncontrado = document.getElementById("idPaisEncontrado");
const divMensajeNoEncontrado = document.getElementById("mensajeNoEncontrado");
const inputIdPais = document.getElementById("idPaisABuscar");
const botonBuscar = document.getElementById("botonBuscarPaisPorId");

function inicializar() {
    buscar(1); // Carga país con ID 1 al inicio
    bindearEventos();
}

function bindearEventos() {
    botonBuscar.addEventListener("click", () => {
        limpiarMensajes();

        const valor = inputIdPais.value.trim();
        if (!/^\d+$/.test(valor)) {
            mostrarMensajeNoEncontrado("Debe ingresar un número válido.");
            return;
        }

        const id = parseInt(valor);
        buscar(id);
    });
}

async function buscar(idPais) {
    try {
        const pais = await buscarPorId(idPais);
        mostrar(pais);
    } catch (error) {
        mostrarMensajeNoEncontrado("No se encontró el país.");
    }
}

function mostrar(pais) {
    bodyTablaPais.innerHTML = `
        <tr>
            <td>${pais.id}</td>
            <td>${pais.nombre}</td>
        </tr>`;
    spanIdPaisEncontrado.textContent = pais.id;
}

function mostrarMensajeNoEncontrado(mensaje = "País no encontrado.") {
    bodyTablaPais.innerHTML = "";
    spanIdPaisEncontrado.textContent = "";
    divMensajeNoEncontrado.textContent = mensaje;
    divMensajeNoEncontrado.classList.remove("d-none");
}

function limpiarMensajes() {
    divMensajeNoEncontrado.classList.add("d-none");
    divMensajeNoEncontrado.textContent = "";
}

window.addEventListener("DOMContentLoaded", inicializar);
