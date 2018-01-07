package cn.dao;

import cn.model.Gold;

public interface GoldMapper {
    int deleteByPrimaryKey(Integer goldId);

    int insert(Gold record);

    int insertSelective(Gold record);

    Gold selectByPrimaryKey(Integer goldId);

    int updateByPrimaryKeySelective(Gold record);

    int updateByPrimaryKey(Gold record);
}