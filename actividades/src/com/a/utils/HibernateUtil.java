package com.a.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.a.models.Actividades;
import com.a.models.Estados;
import com.a.models.Faces;
import com.a.models.FechasEspeciales;
import com.a.models.Personas;
import com.a.models.TipoFace;
import com.a.models.TpUsuario;
import com.a.models.Usuarios;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://usam-sql.sv.cds:3306/gestion_atv?useSSL=false");
				settings.put(Environment.USER, "kz");
				settings.put(Environment.PASS, "kzroot");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				// settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Actividades.class);
				configuration.addAnnotatedClass(Estados.class);
				configuration.addAnnotatedClass(Faces.class);
				configuration.addAnnotatedClass(FechasEspeciales.class);
				configuration.addAnnotatedClass(Personas.class);
				configuration.addAnnotatedClass(TipoFace.class);
				configuration.addAnnotatedClass(TpUsuario.class);
				configuration.addAnnotatedClass(Usuarios.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}