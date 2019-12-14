package com.a.controls;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.a.models.Personas;
import com.a.models.TpUsuario;
import com.a.models.Usuarios;
import com.a.utils.Dao;

@Controller
public class ManejoPersonas {
	
	ModelAndView model = new ModelAndView();
	
	@Autowired
	private Dao<Personas> personas;
	
	@Autowired
	private Dao<Usuarios> usuarios;
	
	
	@RequestMapping(value = "/registroUsuario", method = RequestMethod.POST)
	public ModelAndView crearUsuario(@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos,
			@RequestParam("dui") String dui, @RequestParam("fecha_na") String fecha_na, @RequestParam("sexo") char sexo, 
			@RequestParam("username") String username, @RequestParam("pass") String pass, @RequestParam("tipou") int tipou) {
		try {
			System.out.println(tipou);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse(fecha_na);
			
			TpUsuario tp = new TpUsuario();
			tp.setIdTpu(tipou);
			
			Usuarios u = new Usuarios();
			u.setUsername(username);
			u.setPass(pass);
			u.setEstado(true);
			u.setTpUsuario(tp);
			usuarios.save(u);
			
			Personas p = new Personas();
			p.setNombres(nombre);
			p.setApelliodos(apellidos);
			p.setDui(dui);
			p.setFechaNa(date);
			p.setEstado(true);
			p.setSexo(sexo);
			p.setUsuarios(u);
			personas.save(p);
			String msj = "<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\"><strong>Holy guacamole!</strong> You should check in on some of those fields below.<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button></div>";
			model.addObject("msj", msj);
			model.setViewName("inicio");
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addObject("text", "<b style='color: red;'>Error inesperado</b>");
		}
		return model;
	}
}
