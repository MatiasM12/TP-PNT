import { buscarPorId, agregarProvincia } from "../service/provincia.js";

const bodyTablaProvincia = document.getElementById("bodyTablaProvincia");
const inputNombreProvinciaNueva = document.getElementById("nombreProvinciaNueva");
const botonAgregarProvincia = document.getElementById("botonAgregarProvincia");
const mensajeAgregarProvincia = document.getElementById("mensajeAgregarProvincia");
const divMensajeNoEncontrado = document.getElementById("mensajeNoEncontrado");
const inputIdProvincia = document.getElementById("idProvinciaABuscar");
const botonBuscar = document.getElementById("botonBuscarProvinciaPorId");

function inicializar() {
    buscar(1);
    bindearEventosABotones();
}

function bindearEventosABotones() {
    // Evento para buscar por id
    botonBuscar.addEventListener("click", () => {
        limpiarMensajes();

        const valor = inputIdProvincia.value.trim();

        if (!/^\d+$/.test(valor)) {
            mostrarMensajeNoEncontrado("Debe ingresar un número válido.");
            return;
        }

        const id = parseInt(valor);
        buscar(id);
    });
    
    // Evento para agregar nueva provincia
    botonAgregarProvincia.addEventListener("click", async () => {
        mensajeAgregarProvincia.textContent = "";
        const nombre = inputNombreProvinciaNueva.value.trim();
        if (!nombre) {
            mensajeAgregarProvincia.textContent = "El nombre no puede estar vacío.";
            mensajeAgregarProvincia.className = "text-danger";
            return;
        }

        try {
            const respuesta = await agregarProvincia({ nombre });

            if (respuesta.error) {
                // Error que viene del backend
                throw new Error(respuesta.error);
            }

            mensajeAgregarProvincia.textContent = `Provincia "${respuesta.nombre}" agregada con ID ${respuesta.id}.`;
            mensajeAgregarProvincia.className = "text-success";
            inputNombreProvinciaNueva.value = "";


        } catch (error) {
            mensajeAgregarProvincia.textContent = error.message || "Error al agregar la provincia.";
            mensajeAgregarProvincia.className = "text-danger";
            console.error(error);
        }
    });
}

async function buscar(idProvincia) {
    try {
        const provincia = await buscarPorId(idProvincia);
        mostrar(provincia);
    } catch (error) {
        mostrarMensajeNoEncontrado("No se encontró la provincia.");
    }
}

function mostrar(provincia) {
    bodyTablaProvincia.innerHTML = `
        <tr>
            <td>${provincia.id}</td>
            <td>${provincia.nombre}</td>
        </tr>`;
}

function mostrarMensajeNoEncontrado(mensaje = "Provincia no encontrada.") {
    bodyTablaProvincia.innerHTML = "";
    divMensajeNoEncontrado.textContent = mensaje;
    divMensajeNoEncontrado.classList.remove("d-none");
}

function limpiarMensajes() {
    divMensajeNoEncontrado.classList.add("d-none");
    divMensajeNoEncontrado.textContent = "";
}

window.addEventListener("DOMContentLoaded", inicializar);
