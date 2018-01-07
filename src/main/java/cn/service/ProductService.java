package cn.service;

import cn.model.Product;

public interface ProductService {
	Product selectByPrimaryKey(Integer productId);
}
