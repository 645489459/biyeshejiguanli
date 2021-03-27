package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.SystemContent;
import cn.zcbigdata.mybits_demo.mapper.SystemContentMapper;
import cn.zcbigdata.mybits_demo.service.SystemContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemContentServiceimpl implements SystemContentService {
    @Resource
    private SystemContentMapper systemContentMapper;
    /**
     * 查询公告
     *
     * @return SystemContentMapper类型数据
     */
    @Override
    public List<SystemContent> selectSys() {
        return this.systemContentMapper.selectSys();
    }

    /**
     * 添加公告
     *
     * @param systemContent
     * @return Integer类型
     */
    @Override
    public Integer insertSys(SystemContent systemContent) {
        return this.systemContentMapper.insertSys(systemContent);
    }
}
