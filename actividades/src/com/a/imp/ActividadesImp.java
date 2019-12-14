package com.a.imp;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.a.models.Actividades;
import com.a.utils.AbstractFacade;
import com.a.utils.Dao;
import com.a.utils.HibernateUtil;

@Repository
public class ActividadesImp extends AbstractFacade<Actividades> implements Dao<Actividades>{
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	public ActividadesImp() {
		super(Actividades.class);
	}
}
