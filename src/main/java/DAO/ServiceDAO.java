package DAO;

import DTO.ServiceDTO;
import Factory.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ServiceDAO implements DAO<ServiceDTO> {
    @Override
    public Boolean create(ServiceDTO object) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Boolean operationResult;
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            operationResult = Boolean.TRUE;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            System.err.println(e.getMessage());
            operationResult = Boolean.FALSE;
        }finally{
            entityManager.close();
        }
        return operationResult;
    }

    @Override
    public ServiceDTO read(Integer Id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        ServiceDTO object = null;
        try {
            object = entityManager.find(ServiceDTO.class, Id);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            entityManager.close();
        }
        return object;
    }

    @Override
    public Boolean update(ServiceDTO object) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        Boolean operationResult;
        try {
            entityManager.getTransaction().begin();
            if(object.getId() == null){
                entityManager.persist(object);
            }else{
                entityManager.merge(object);
            }   
            entityManager.getTransaction().commit();
            operationResult = Boolean.TRUE;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            System.err.println(e.getMessage());
            operationResult = Boolean.FALSE;
        }finally{
            entityManager.close();
        }
        return operationResult;
    }

    @Override
    public Boolean delete(Integer Id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        ServiceDTO object;
        Boolean operationResult;
        try {
            object = entityManager.find(ServiceDTO.class, Id);
            entityManager.getTransaction().begin();
            entityManager.remove(object);
            entityManager.getTransaction().commit();
            operationResult = Boolean.TRUE;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            System.err.println(e.getMessage());
            operationResult = Boolean.FALSE;
        }finally{
            entityManager.close();
        }
        return operationResult;
    }
    
    @Override
    public List<ServiceDTO> all() {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<ServiceDTO> list = null;
        try {
            list = entityManager.createQuery("from ServiceDTO dto").getResultList();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            entityManager.close();
        }
        return list;
    }

}