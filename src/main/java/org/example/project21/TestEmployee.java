package org.example.project21;

import org.example.project21.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Artem", "Ostapenko",
                    "IT", 1000);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
