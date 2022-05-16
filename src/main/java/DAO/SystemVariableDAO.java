package DAO;

import DTO.SystemVariableDTO;
import Factory.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class SystemVariableDAO implements DAO<SystemVariableDTO> {
    @Override
    public Boolean create(SystemVariableDTO object) {
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
    public SystemVariableDTO read(Integer Id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        SystemVariableDTO object = null;
        try {
            object = entityManager.find(SystemVariableDTO.class, Id);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            entityManager.close();
        }
        return object;
    }

    @Override
    public Boolean update(SystemVariableDTO object) {
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
        SystemVariableDTO object;
        Boolean operationResult;
        try {
            object = entityManager.find(SystemVariableDTO.class, Id);
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
    public List<SystemVariableDTO> all() {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<SystemVariableDTO> list = null;
        try {
            list = entityManager.createQuery("from SystemVariableDTO dto").getResultList();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            entityManager.close();
        }
        return list;
    }
}