package cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import cn.dao.ProductMapper;
import cn.model.Product;
import cn.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductMapper productMapper;

	public Product selectByPrimaryKey(Integer productId) {
		// TODO 自动生成的方法存根
		return productMapper.selectByPrimaryKey(productId);
	}

	public Product selectByProductName(String productName) {
		// TODO 自动生成的方法存根
		return productMapper.selectByProductName(productName);
	}

}
