package com.a.imp;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.a.models.TpUsuario;
import com.a.utils.AbstractFacade;
import com.a.utils.Dao;
import com.a.utils.HibernateUtil;

@Repository
public class TpUsuarioImp extends AbstractFacade<TpUsuario> implements Dao<TpUsuario>{
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	public TpUsuarioImp() {
		super(TpUsuario.class);
	}
}
