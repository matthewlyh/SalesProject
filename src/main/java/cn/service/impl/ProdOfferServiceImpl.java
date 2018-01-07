package cn.service.impl;

import cn.dao.ProdOfferMapper;
import cn.model.ProdOffer;
import cn.service.ProdOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/26.
 */
@Component
public class ProdOfferServiceImpl implements ProdOfferService {

    @Autowired
    private ProdOfferMapper prodOfferMapper;

    public ProdOffer FindProdOfferById(int prod_offer_id)
    {
        //System.out.println("FindProdOfferById:"+prod_offer_id);
        return prodOfferMapper.selectByPrimaryKey(prod_offer_id);
       
    }
}
