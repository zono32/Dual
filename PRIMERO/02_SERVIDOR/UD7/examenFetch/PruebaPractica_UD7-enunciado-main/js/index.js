window.onload = onceLoaded;
function onceLoaded() {
    getNotas();
    let btnCrearNota = document.querySelector("#btnCrearNota");
    btnCrearNota.onclick = mostrarCrearForm;

    crearNotasForm = document.querySelector("#crearForm");
    crearNotasForm.onsubmit = function (event) {
        event.preventDefault();
        if (validarTitulo()) {
            crearNotaApiRemota();
        }
        else {
            showMsg("No se permite la creación de notas con títulos distintos de: " + TITULO_PERMITIDO, true, "div-msg", false);
        }
    }
}

function mostrarCrearForm() {
    let crear_section = document.querySelector("#crear-section");
    crear_section.classList.toggle('d-none');
}


function getNotas() { 

    document.querySelector('#loading-div').classList.toggle('d-none');
    fetch(REMOTE_API_URL)  
        .then(response => response.json())            
        .then(response2=> crearTabla("notas-table", response2, ["Title", "Created At", "Updated At", "Completed", "Id"])); 
      
    
   
}


/**
 * Crea una tabla html dentro del div con id "notas" con los datos y cabeceras aportados
 * @param {string} tableId atributo id del html con el que se creará la tabla html
 * @param {array} array_data array de datos con los que se poblará la tabla html
 * @param {array} array_cabeceras array de string con las cabeceras de la tabla
 */
function crearTabla(tableId, array_data, array_cabeceras) {
    let table = document.createElement('table');
    table.setAttribute('id', tableId);
    //añadimos clase css de bootstrap https://getbootstrap.com/docs/5.0/content/tables/
    table.classList.add('table');
    let thead = document.createElement('thead');
    table.appendChild(thead);
    let fila_cab = crear_fila(array_cabeceras, 'th');
    thead.appendChild(fila_cab);

    let tbody = document.createElement('tbody');
    for (let i = 0; i < array_data.length; i++) {

        let fila_body = crear_fila(array_data[i], 'td');
        fila_body.setAttribute('id', 'tr_' + array_data[i].userId);
        tbody.append(fila_body);
    }

    table.appendChild(tbody);

    //Añadimos la tabla al html
    div_element = document.querySelector("#notas");
    div_element.innerHTML = '';
    div_element.appendChild(table);
}

/**
 * Crea un elemento tr con celdas th o td con los datos incluidos en el 
 * @param {Object} object Puede tratarse de un array de índices numéricos con las cadenas que se incluirán dentro de las celdas cabecera o un objeto JSON cuyos valores formarán parte de las celdas
 * @param {String} th_td Se indica si se crearán celdas th o td mediante las cadenas 'th' o 'td'
 * @returns {HTMLElement} Devuelve el elemento tr
 */
function crear_fila(object, th_td) {

    const keys = Object.keys(object);

    let tr = document.createElement('tr');

    for (let i = 0; i < keys.length; i++) {
        let celda = document.createElement(th_td);
        const key = keys[i];
        celda.innerHTML = object[key];

        tr.appendChild(celda);
    }
    return tr;
}





