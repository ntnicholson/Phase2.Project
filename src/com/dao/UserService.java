package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.entity.User;
import com.interfaces.IUserInterface;

public class UserService implements IUserInterface {

	@Override
	public boolean Register(User register) {
		boolean created = false;

		try {
			Configuration config = new Configuration().configure();
			config.addAnnotatedClass(com.entity.User.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties());

			SessionFactory f = config.buildSessionFactory(builder.build());
			Session s = f.openSession();
			Transaction tx = s.beginTransaction();

			s.save(register);
			tx.commit();
			s.close();
			created = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return created;
	}

	@Override
	public boolean Login(User find) {
		boolean created = false;

		try {
			Configuration config = new Configuration().configure();
			config.addAnnotatedClass(com.entity.User.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties());

			SessionFactory f = config.buildSessionFactory(builder.build());
			Session s = f.openSession();
			Transaction tx = s.beginTransaction();

			User login = s.load(User.class, find.getEmail());
			find.setUserName(login.getUserName());
			//System.out.println(login.toString());
			s.close();
			created = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return created;
	}

}
