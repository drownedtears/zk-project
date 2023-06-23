package org.wildfly.myzkapp.server.dao;

import org.wildfly.myzkapp.server.entity.pojo.Company;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CompanyDao extends BaseDao {

    public List<Company> getAllEntities() {
        return getAllEntities(Company.class);
    }
}
