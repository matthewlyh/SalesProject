package cn.service.impl;

import cn.dao.CustOrderMapper;
import cn.model.CustOrder;
import cn.service.CustOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/26.
 */
@Component
public class CustOrderServiceImpl implements CustOrderService {

    @Autowired
    private CustOrderMapper custOrderMapper;

    public CustOrder FindCustOrderByID(int cust_order_id)
    {
        //System.out.println("cust_order_id："+cust_order_id);
        return custOrderMapper.selectByPrimaryKey(cust_order_id);
    }

    //查看订单状态是否为1，是则反馈true，不是则反馈false
    public boolean FindCustOrderId(int cust_order_id)
    {
        boolean T=false;
        CustOrder custOrderModel=custOrderMapper.selectByPrimaryKey(cust_order_id);
        if (custOrderModel!=null)
            if (custOrderModel.getStatusCd() == 1)
                T= true;
        return T;
    }
    public int updateCustOrder(CustOrder record)
    {
    	record.setStatusCd(2);
    	return custOrderMapper.updateByPrimaryKey(record);
    }

}
