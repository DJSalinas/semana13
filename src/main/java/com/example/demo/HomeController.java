package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping(path = "/api/bandas/{id}/formacion")
	public @ResponseBody List<Map <String, Object>> formacion(@PathVariable Integer id){

		String sql = "SELECT integrante.id as ID, musico.nombre, instrumento.nombre as INSTRUMENTO\r\n" + //
				"\t FROM Integrante\r\n" + //
				"\t JOIN Musico on integrante.id_musico = musico.id\r\n" + //
				"\t JOIN Instrumento on integrante.id_instrumento = instrumneto.id\r\n" + //
				"\t WHERE integrante.id_banda = ?";
		List<Map <String, Object>> queryResult = jdbcTemplate.queryForList(sql);
		return queryResult;																																												
	}

	/** Estructura de lo que devuelve
	 *[
	 * {id:1, Musico:"Freddy", Instrumento:"Voz"}
	 *]
	 *
	 * List<Map <String, Object>>
	 * 
	 sql = SELECT integrante.id as ID, musico.nombre, instrumento.nombre as INSTRUMENTO
	 FROM Integrante
	 JOIN Musico on integrante.id_musico = musico.id
	 JOIN Instrumento on Integrante.id_instrumento = instrumneto.id
	 WHERE integrante.id_banda = ?
	 */
	
}