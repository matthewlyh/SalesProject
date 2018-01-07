package cn.service;

import cn.model.CustOrder;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface CustOrderService {

    CustOrder FindCustOrderByID(int cust_order_id);
    boolean FindCustOrderId(int id);
    int updateCustOrder(CustOrder record);

}
