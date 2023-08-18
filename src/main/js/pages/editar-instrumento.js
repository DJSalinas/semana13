const React = require('react');
const {useState, useEffect} = require('react');
const {Link, useParams} = require('react-router-dom');
const client = require('../client');

const EditarInstrumentoPage = () => {

    const [instrumento, setInstrumento] = useState({})
    let {id} = useParams();

    //solo se ejecuta al inicio
    useEffect( ()=>{
        //trae los datos
        client({
            method: 'GET',
            path: '/api/instrumentos/'+id,
        }).done((response) => setInstrumento(response.entity))
    } , [] )

    const handleSubmit = (evento) => {
        evento.preventDefault();
        client({
            method: 'PATCH',
            path: '/api/instrumentos/' +id,
            entity: instrumento,
            headers: {'Content-Type':'application/json'}
        }).done(()=> window.location = '/')
    }

    return(
        <>
            <h1>Editar Instrumento</h1>

            <form onSubmit={handleSubmit}>
                <label>Nombre</label>
                <input type='text' name='nombre' id='nombre' value={instrumento.nombre}
                onChange={(e) => setInstrumento({...instrumento, nombre: e.target.value})}/><br/>
                <label>Categoria</label>
                <input type='text' name='categoria' id='categoria' value={instrumento.categoria} 
                onChange={(e) => setInstrumento({...instrumento, categoria: e.target.value})}/><br/>
                <label>Descripción</label>
                <input type='text' name='descripcion' id='descripcion' value={instrumento.descripcion} 
                onChange={(e) => setInstrumento({...instrumento, descripcion: e.target.value})}/><br/>
            
                <input type='submit' value="Editar Instrumento"/>
            </form>
            <Link to="/">Volver</Link>
        </>
    )
}

module.exports = EditarInstrumentoPage;