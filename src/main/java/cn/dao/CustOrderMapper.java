package cn.dao;

import cn.model.CustOrder;

public interface CustOrderMapper {
    int deleteByPrimaryKey(Integer custOrderId);

    int insert(CustOrder record);

    int insertSelective(CustOrder record);

    CustOrder selectByPrimaryKey(Integer custOrderId);

    int updateByPrimaryKeySelective(CustOrder record);

    int updateByPrimaryKey(CustOrder record);
}