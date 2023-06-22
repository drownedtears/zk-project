package org.wildfly.myzkapp.server.dao;

import org.wildfly.myzkapp.server.entity.pojo.CompanyHead;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CompanyHeadDao extends BaseDao {

    public List<CompanyHead> getAllEntities() {
        return getAllEntities(CompanyHead.class);
    }
}
