package cn.dao;

import cn.model.Lan;

public interface LanMapper {
    int deleteByPrimaryKey(Integer lanId);

    int insert(Lan record);

    int insertSelective(Lan record);

    Lan selectByPrimaryKey(Integer lanId);

    int updateByPrimaryKeySelective(Lan record);

    int updateByPrimaryKey(Lan record);
}