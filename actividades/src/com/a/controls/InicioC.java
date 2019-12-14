package com.a.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.a.models.TpUsuario;
import com.a.utils.Dao;

@Controller
public class InicioC {
	
	ModelAndView model = new ModelAndView();
	
	@Autowired
	private Dao<TpUsuario> tpusuario;
	
	@RequestMapping(value = "/inicio" , method = RequestMethod.GET)
	public ModelAndView inicio() {
		List<TpUsuario> tipos = tpusuario.findAll();
		model.addObject("tipos", tipos);
		
		System.out.println(tipos.size());
		model.setViewName("inicio");
		return model;
	}


}
