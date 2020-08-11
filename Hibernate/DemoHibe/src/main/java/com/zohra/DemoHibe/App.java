package com.zohra.DemoHibe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Alien alien = new Alien();
       //alien.setId(1);
       alien.setName("Naveena");
       alien.setTech("Java");
       
       /* To achieve this purpose, we need to have a ServiceRegistry that holds the Services needed by Hibernate. 
        * From this registry, we can build a Metadata object that represents the application's domain model and 
        * its mapping to the database.
        */
       //Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
       
       StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
    		   configure().build();
       
       SessionFactory sf = new MetadataSources(registry).addAnnotatedClass(Alien.class).buildMetadata().buildSessionFactory();
       
       Session session = sf.openSession();
       Transaction tx = session.beginTransaction();
       session.save(alien);
       tx.commit();
       session.close();
       StandardServiceRegistryBuilder.destroy(registry);
       
       
    }
}
