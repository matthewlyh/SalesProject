package cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.dao.StaffRankMapper;
import cn.service.StaffRankService;
import cn.view.StaffRank;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
@Component
public class StaffRankServiceImpl implements StaffRankService {
    @Autowired
    private StaffRankMapper staffRankMapper;

	public List<StaffRank> queryList(StaffRank record) {
		// TODO 自动生成的方法存根
		return staffRankMapper.queryList(record);
	}

   
}
