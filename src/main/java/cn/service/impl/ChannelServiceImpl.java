package cn.service.impl;

import cn.dao.ChannelMapper;
import cn.model.Channel;
import cn.service.ChannelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/26.
 */
@Component
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelmapper;

    public Channel FindChannelById(int channelId)
    {
        return channelmapper.selectByPrimaryKey(channelId);
    }
}
