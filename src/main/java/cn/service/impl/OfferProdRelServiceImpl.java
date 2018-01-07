package cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.dao.OfferProdRelMapper;
import cn.model.OfferProdRel;
import cn.service.OfferProdRelService;
@Component
public class OfferProdRelServiceImpl implements OfferProdRelService {

	@Autowired
	OfferProdRelMapper offerProdRelMapper;
	
	public OfferProdRel selectByPrimaryKey(Integer prodofferid) {
		// TODO 自动生成的方法存根
		return offerProdRelMapper.selectByPrimaryKey(prodofferid);
		 
	}

}
