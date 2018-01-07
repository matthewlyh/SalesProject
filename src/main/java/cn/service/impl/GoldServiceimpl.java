package cn.service.impl;

import cn.dao.GoldMapper;
import cn.model.Gold;
import cn.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/26.
 */
@Component
public class GoldServiceimpl implements GoldService{
    @Autowired
    private GoldMapper goldMapper;


	public int insertGold(Gold record) {
		// TODO 自动生成的方法存根
		return goldMapper.insert(record);
	}
}
