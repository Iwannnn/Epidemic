package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicDrugFactory;

/**
 * 工厂管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicDrugFactoryMapper 
{
    /**
     * 查询工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 工厂管理
     */
    public EpidemicDrugFactory selectEpidemicDrugFactoryByFactoryId(Long factoryId);

    /**
     * 查询工厂管理列表
     * 
     * @param epidemicDrugFactory 工厂管理
     * @return 工厂管理集合
     */
    public List<EpidemicDrugFactory> selectEpidemicDrugFactoryList(EpidemicDrugFactory epidemicDrugFactory);

    /**
     * 新增工厂管理
     * 
     * @param epidemicDrugFactory 工厂管理
     * @return 结果
     */
    public int insertEpidemicDrugFactory(EpidemicDrugFactory epidemicDrugFactory);

    /**
     * 修改工厂管理
     * 
     * @param epidemicDrugFactory 工厂管理
     * @return 结果
     */
    public int updateEpidemicDrugFactory(EpidemicDrugFactory epidemicDrugFactory);

    /**
     * 删除工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 结果
     */
    public int deleteEpidemicDrugFactoryByFactoryId(Long factoryId);

    /**
     * 批量删除工厂管理
     * 
     * @param factoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicDrugFactoryByFactoryIds(Long[] factoryIds);
}
