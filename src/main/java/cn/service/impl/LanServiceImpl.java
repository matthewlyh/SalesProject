package cn.service.impl;

import cn.dao.LanMapper;
import cn.model.Lan;
import cn.service.LanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/26.
 */
@Component
public class LanServiceImpl implements LanService {

    @Autowired
    LanMapper lanMapper;

    public Lan FindLanByID(int lanId)
    {
       return  lanMapper.selectByPrimaryKey(lanId);
    }

}
