package by.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

/**
 * Created by a.evstratiev on 9/1/2014.
 */
public class BaseDao {

    @Autowired
    protected SqlMapClientTemplate sqlMapClientTemplate;


}
