package DAO;

import DTO.ServiceHistoryDTO;
import Factory.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ServiceHistoryDAO implements DAO<ServiceHistoryDTO> {
    @Override
    public Boolean create(ServiceHistoryDTO object) {
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
    public ServiceHistoryDTO read(Integer Id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        ServiceHistoryDTO object = null;
        try {
            object = entityManager.find(ServiceHistoryDTO.class, Id);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            entityManager.close();
        }
        return object;
    }

    @Override
    public Boolean update(ServiceHistoryDTO object) {
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
        ServiceHistoryDTO object;
        Boolean operationResult;
        try {
            object = entityManager.find(ServiceHistoryDTO.class, Id);
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
    public List<ServiceHistoryDTO> all() {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<ServiceHistoryDTO> list = null;
        try {
            list = entityManager.createQuery("from ServiceHistoryDTO dto").getResultList();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            entityManager.close();
        }
        return list;
    }

}