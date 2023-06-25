package org.wildfly.myzkapp.server.dao;

import org.wildfly.myzkapp.server.entity.pojo.BranchCompany;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class BranchCompanyDao extends BaseDao {

    public List<BranchCompany> getAllEntities() {
        return getAllEntities(BranchCompany.class);
    }
}
