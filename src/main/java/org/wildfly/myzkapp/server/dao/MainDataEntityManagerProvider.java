package org.wildfly.myzkapp.server.dao;

import lombok.Getter;
import org.wildfly.myzkapp.server.util.ServerStringData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Getter
public class MainDataEntityManagerProvider {

    @PersistenceContext(unitName = ServerStringData.PersistenceUnitName.MAIN)
    private EntityManager entityManager;
}

