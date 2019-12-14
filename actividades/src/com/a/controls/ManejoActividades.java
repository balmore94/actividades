package com.a.controls;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.a.models.Actividades;
import com.a.models.Estados;
import com.a.models.Usuarios;
import com.a.utils.Dao;

@Controller
public class ManejoActividades {
	ModelAndView model = new ModelAndView();
	
	
	@Autowired
	private Dao<Actividades> actividades;
	
	@Autowired
	private Dao<Estados> estados;
	
	@Autowired
	private Dao<Usuarios> usuarios;
	
	@RequestMapping(value = "/showRegistroAtv", method = RequestMethod.GET)
	public ModelAndView viewregistroAtv() {
		Date dia = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String d = formato.format(dia);
		List<Estados> est = estados.findAll();
		System.out.println(est.size());
		model.addObject("est", est);
		List<Usuarios> us = usuarios.findAll();
		model.addObject("us", us);
		model.addObject("d", d);
		System.out.println(d);
		model.setViewName("actividades");
		return model;
	}
	
	@RequestMapping(value = "/registroAtv", method = RequestMethod.POST)
	public ModelAndView registroAtv(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("fecha") String fecha, @RequestParam("est") int est, @RequestParam("usu") int usu) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse(fecha);
			
			Usuarios u = new Usuarios();
			u.setIdUs(usu);
			
			Estados e = new Estados();
			e.setIdEst(est);
			
			Actividades a = new Actividades();
			a.setNombre(nombre);
			a.setDescripcion(descripcion);
			a.setFechaLimite(date);
			a.setEstados(e);
			a.setUsuarios(u);
			actividades.save(a);
			String msj = "<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\"><strong>Holy guacamole!</strong> You should check in on some of those fields below.<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>";
			model.addObject("msj", msj);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.setViewName("actividades");
		return model;
	}
	
	@RequestMapping(value = "/actividades", method = RequestMethod.GET)
	public ModelAndView listaActividades() {
		List<Actividades> act = actividades.findAll();
		model.addObject("act", act);
		model.setViewName("listaActividades");
		return model;
	}
}
