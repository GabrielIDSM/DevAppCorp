package DAO;

import DTO.SystemVariableTypeDTO;
import Factory.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class SystemVariableTypeDAO implements DAO<SystemVariableTypeDTO> {
    @Override
    public Boolean create(SystemVariableTypeDTO object) {
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
    public SystemVariableTypeDTO read(Integer Id) {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        SystemVariableTypeDTO object = null;
        try {
            object = entityManager.find(SystemVariableTypeDTO.class, Id);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            entityManager.close();
        }
        return object;
    }

    @Override
    public Boolean update(SystemVariableTypeDTO object) {
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
        SystemVariableTypeDTO object;
        Boolean operationResult;
        try {
            object = entityManager.find(SystemVariableTypeDTO.class, Id);
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
    public List<SystemVariableTypeDTO> all() {
        EntityManager entityManager = new ConnectionFactory().getConnection();
        List<SystemVariableTypeDTO> list = null;
        try {
            list = entityManager.createQuery("from SystemVariableTypeDTO dto").getResultList();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            entityManager.close();
        }
        return list;
    }
}