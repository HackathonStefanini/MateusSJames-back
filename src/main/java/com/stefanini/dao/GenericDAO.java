package com.stefanini.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Essa classe não precisa de modificações!
 */
public class GenericDAO<T, I>  {

    @PersistenceContext(unitName = "PU")
    EntityManager em;
    
    Class<T> clazz;

    public GenericDAO() {
        clazz = ((Class) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Transactional
    public void save(T t){
        em.persist(t);
    }

    public T findById(I id){
        return em.find(clazz, id);
    }
    
    public T findByName(String name){
        return em.find(clazz, name);
    }

    public List<T> listAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        query.from(clazz);
        return em.createQuery(query).getResultList();
    }

    public T findByLogin(String nick, String senha) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root).where(builder.and(
            builder.equal(root.get("nickname"), nick),
            builder.equal(root.get("password"), senha)
        ));
        TypedQuery<T> typedQuery = em.createQuery(query);
        return typedQuery.getSingleResult();
    }
    
    @Transactional
    public T update(T t){
        return em.merge(t);
    }

    @Transactional
    public void delete(I id){
        T t = findById(id);
        em.remove(t);
    }

    public TypedQuery<T> createQuery(String query) {
        return em.createQuery(query, clazz);
    }
    
    public <J> TypedQuery<J> createQuery(String query, Class<J> classe) {
        return em.createQuery(query, classe);
    }
    

    public Query createNativeQuery(String query) {
        return em.createNativeQuery(query, clazz);
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
