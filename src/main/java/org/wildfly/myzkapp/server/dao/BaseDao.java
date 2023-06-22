package org.wildfly.myzkapp.server.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class BaseDao {
    @Inject
    private MainDataEntityManagerProvider mainDataEntityManagerProvider;

    public EntityManager getEntityManagerInstance() {
        return mainDataEntityManagerProvider.getEntityManager();
    }
    public <T> T add(T object) {
        return getEntityManagerInstance().merge(object);
    }

    public void delete(Object entity) {
        getEntityManagerInstance().remove(entity);
    }

    public <T> T update(T object) {
        return add(object);
    }

    public <T> T get(Class<T> clazz, Object id) {
        return getEntityManagerInstance().find(clazz, id);
    }
    public <T> List<T> getAllEntities(Class<T> clazz) {
        CriteriaQuery<T> cq = getCriteriaBuilder().createQuery(clazz);
        Root<T> root = cq.from(clazz);
        CriteriaQuery<T> allEntities = cq.select(root);
        return getEntityManagerInstance().createQuery(allEntities).getResultList();
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        return getEntityManagerInstance().getCriteriaBuilder();
    }
}
