package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.SystemContent;
import cn.zcbigdata.mybits_demo.mapper.SystemContentMapper;

import java.util.List;

public interface SystemContentService {
    /**
     *查询公告
     * @return SystemContentMapper类型数据
     */
    List<SystemContent> selectSys();

    /**
     * 添加公告
     * @param systemContent
     * @return Integer类型
     */
    Integer insertSys(SystemContent systemContent);
}
