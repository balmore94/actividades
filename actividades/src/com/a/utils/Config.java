package com.a.utils;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.a.imp.ActividadesImp;
import com.a.imp.EstadosImp;
import com.a.imp.PersonasImp;
import com.a.imp.TpUsuarioImp;
import com.a.imp.UsuariosImp;
import com.a.models.Actividades;
import com.a.models.Estados;
import com.a.models.Personas;
import com.a.models.TpUsuario;
import com.a.models.Usuarios;


@Configuration
@EnableWebMvc
@ComponentScan("com.a")
@EnableTransactionManagement(proxyTargetClass = true)
public class Config {

	@Bean
	InternalResourceViewResolver viewRes() {
		InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setPrefix("/WEB-INF/views/");
		r.setSuffix(".jsp");
		return r;
	}

	@Bean
	public SessionFactory getConex() {
		return HibernateUtil.getSessionFactory();
	}
	
	@Bean
	public Dao<Personas> personas(){
		return new PersonasImp();
	}
	
	@Bean
	public Dao<Usuarios> usuarios(){
		return new UsuariosImp();
	} 
	
	@Bean
	public Dao<TpUsuario> tpusuario(){
		return new TpUsuarioImp();
	}
	
	@Bean
	public Dao<Actividades> actividades(){
		return new ActividadesImp();
	}
	
	@Bean
	public Dao<Estados> estados(){
		return new EstadosImp();
	}

}
