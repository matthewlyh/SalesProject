package cn.dao;

import cn.model.ProdOffer;

public interface ProdOfferMapper {
    int deleteByPrimaryKey(Integer prodOfferId);

    int insert(ProdOffer record);

    int insertSelective(ProdOffer record);

    ProdOffer selectByPrimaryKey(Integer prodOfferId);

    int updateByPrimaryKeySelective(ProdOffer record);

    int updateByPrimaryKey(ProdOffer record);
}