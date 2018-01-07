package cn.dao;

import cn.model.OfferProdRel;

public interface OfferProdRelMapper {
    int deleteByPrimaryKey(Integer offerProdRelId);

    int insert(OfferProdRel record);

    int insertSelective(OfferProdRel record);

    OfferProdRel selectByPrimaryKey(Integer offerProdRelId);

    int updateByPrimaryKeySelective(OfferProdRel record);

    int updateByPrimaryKey(OfferProdRel record);
}