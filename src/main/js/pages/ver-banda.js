const React = require('react');
const { Link, useParams } = require('react-router-dom');
const {useState, useEffect} = require('react');
const client = require('../client');

const VerBandaPage = () => {

    let { id } = useParams();
    const [banda, setBanda] = useState({});
    const [integrantes, setIntegrantes] = useState([])

    useEffect( ()=>{
        //obtener los datos
        client({
            method: 'GET',
            path: '/api/bandas/' + id
        }).done(response=>setBanda(response.entity))
        client({
            method: 'GET',
            path: '/api/bandas/' + id + '/informacion'
        }).done(response=>setIntegrantes(response.entity))
    } , [] )


    return (
        <>
            <h1>Ver Bandas</h1>

            <table>
                <tr>
                    <th>Nombre</th>
                    <td>{banda.nombre}</td>
                </tr>
            </table>

            <hr />

            <h2>Formación</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>Musicos</th>
                        <td>Instrumentos</td>
                    </tr>
                </thead>
                <tbody>
                    {integrantes.map(integrante=>{
                        return(
                            <tr key={integrante.ID}>
                                <td>{integrante.MUSICO}</td>
                                <td>{integrante.INSTRUMENTO}</td>
                            </tr>
                        )
                    })}
                </tbody>
                
            </table>

            <Link to="/nuevo-integrante">Nuevo Integrante</Link> | 
            <Link to="/">Volver</Link>
        </>
    )

}

module.exports = VerBandaPage;