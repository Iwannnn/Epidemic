package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicFactory;

/**
 * 工厂管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicFactoryMapper 
{
    /**
     * 查询工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 工厂管理
     */
    public EpidemicFactory selectEpidemicFactoryByFactoryId(Long factoryId);

    /**
     * 查询工厂管理列表
     * 
     * @param epidemicFactory 工厂管理
     * @return 工厂管理集合
     */
    public List<EpidemicFactory> selectEpidemicFactoryList(EpidemicFactory epidemicFactory);

    /**
     * 新增工厂管理
     * 
     * @param epidemicFactory 工厂管理
     * @return 结果
     */
    public int insertEpidemicFactory(EpidemicFactory epidemicFactory);

    /**
     * 修改工厂管理
     * 
     * @param epidemicFactory 工厂管理
     * @return 结果
     */
    public int updateEpidemicFactory(EpidemicFactory epidemicFactory);

    /**
     * 删除工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 结果
     */
    public int deleteEpidemicFactoryByFactoryId(Long factoryId);

    /**
     * 批量删除工厂管理
     * 
     * @param factoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicFactoryByFactoryIds(Long[] factoryIds);
}
