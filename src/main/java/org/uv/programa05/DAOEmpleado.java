/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa05;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ivan
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long>{

    @Override
    public Empleado create(Empleado p) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction t =session.beginTransaction();
            
            session.save(p);
            Logger.getLogger (DAOEmpleado.class.getName()).
                    log(Level.INFO, "Se guardo Empleado");
            t.commit();
        }
        return p;
    }

    @Override
    public boolean delete(Long id) {
        boolean res;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t =session.beginTransaction();
            res = false;
            Empleado empleado=findById(id);
            if (empleado==null)
                res= false;
            else{
                session.delete(empleado);
                res= true;
            }   t.commit();
        }
        return res;
    }

    @Override
    public Empleado update(Empleado p, Long id) {      
        Empleado empleado;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t =session.beginTransaction();
            empleado = findById(id);
            if (empleado==null)
                session.update(empleado);
            t.commit();  
        }
        return empleado;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> lstRes=null;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t =session.beginTransaction();
            lstRes=session.createQuery("from empleado").list();
            t.commit();
        }
        return lstRes;  
    }

    @Override
    public Empleado findById(Long id) {
        Empleado empleado=null;
        try (Session session = HibernateUtil.getSession()) {
            Transaction t =session.beginTransaction();
            empleado=session.get(Empleado.class, id);
            t.commit();
        }
        return empleado;  
    }
    
}
