package com.a.imp;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.a.models.Personas;
import com.a.utils.AbstractFacade;
import com.a.utils.Dao;
import com.a.utils.HibernateUtil;

@Repository
public class PersonasImp extends AbstractFacade<Personas> implements Dao<Personas>{
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	public PersonasImp() {
		super(Personas.class);
	}
}
