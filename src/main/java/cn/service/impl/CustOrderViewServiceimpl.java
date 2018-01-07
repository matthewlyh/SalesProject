package cn.service.impl;

import cn.service.CustOrderViewService;
import cn.view.CustOrderView;
import cn.dao.CustOrderViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
@Component
public class CustOrderViewServiceimpl implements CustOrderViewService {

    @Autowired
    CustOrderViewMapper custOrderViewMapper;

    
    public List<CustOrderView> queryList(CustOrderView record)
    {
    	return custOrderViewMapper.QueryByCustOrderView(record);
    }
    
    
}
