package ims.dal;

import ims.dto.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NAT
 */
public class BaseDAL {

    protected Session session;
    protected SessionFactory sessionFactory;

    public BaseDAL()  {
        try {
            connect();
        } catch (Exception ex) {
            Logger.getLogger(BaseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() throws Exception {
        try {
//            Configuration configuration = new Configuration();
//            configuration.configure("hibernate.cfg.xml");
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//                 
//            sessionFactory  = configuration.buildSessionFactory(serviceRegistry);
            sessionFactory = new Configuration().configure().buildSessionFactory();						
            session = sessionFactory.openSession();
	} catch (Exception ex) {
                    ex.printStackTrace();
            throw ex;
	}
    }
	
	public void close() throws Exception {
		if (session != null) {
                    session.close();
                    sessionFactory.close();
		}
	}

	
}
    