package org.example.service;

import org.example.model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.*;

public class CustomerService implements ICustomerService {

    @Override
    public List<Customer> findAll() {
        Session session = null;
        List<Customer> customerList = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            customerList = session.createQuery("FROM Customer").getResultList();
        }finally {
            if(session != null){
                session.close();
            }
        }
        return customerList;
    }
    Map<Integer,Customer> customers = new LinkedHashMap<>();

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }
    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);

    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }


}
