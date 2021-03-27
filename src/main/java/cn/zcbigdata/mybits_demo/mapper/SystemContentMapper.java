package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.SystemContent;

import java.util.List;

/**
 * @author admin
 */
public interface SystemContentMapper {
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
