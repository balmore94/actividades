package com.a.imp;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.a.models.Usuarios;
import com.a.utils.AbstractFacade;
import com.a.utils.Dao;
import com.a.utils.HibernateUtil;

@Repository
public class UsuariosImp extends AbstractFacade<Usuarios> implements Dao<Usuarios>{
	private Session session = HibernateUtil.getSessionFactory().openSession();
	
	public UsuariosImp() {
		super(Usuarios.class);
	}
}
