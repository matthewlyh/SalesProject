package cn.service.impl;

import cn.dao.InterViewMapper;
import cn.service.InterViewService;
import cn.view.InterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/26.
 */
@Component
public class InterViewServiceImpl implements InterViewService {

    @Autowired
    private InterViewMapper interViewMapper;


    public InterView findInterViewById(int id)
    {
        return interViewMapper.findViewById(id);

    }
}
