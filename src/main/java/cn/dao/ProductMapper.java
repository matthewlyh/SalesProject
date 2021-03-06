package cn.dao;

import cn.model.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);
    
    Product selectByProductName(String productName);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}