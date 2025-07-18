export async function buscarPorId(idProvincia) {
    const urlService = "/api/provincia/";
    const urlServiceBuscarPorId = urlService + idProvincia;
    const data = await fetch(urlServiceBuscarPorId);
    return data.ok ? await data.json() : Promise.reject(response);
}

export async function agregarProvincia(provincia) {
    const response = await fetch('/api/provincia', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(provincia)
    });

    if (!response.ok) {
        throw new Error('Error al agregar provincia');
    }
    return response.json(); 
}
