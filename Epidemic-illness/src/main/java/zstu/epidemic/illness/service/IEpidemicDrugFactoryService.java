package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicDrugFactory;

/**
 * 工厂管理Service接口
 * 
 * @author iwan
 * @date 2022-05-04
 */
public interface IEpidemicDrugFactoryService 
{
    /**
     * 查询工厂管理
     * 
     * @param drugFactoryId 工厂管理主键
     * @return 工厂管理
     */
    public EpidemicDrugFactory selectEpidemicDrugFactoryByDrugFactoryId(Long drugFactoryId);

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
     * 批量删除工厂管理
     * 
     * @param drugFactoryIds 需要删除的工厂管理主键集合
     * @return 结果
     */
    public int deleteEpidemicDrugFactoryByDrugFactoryIds(Long[] drugFactoryIds);

    /**
     * 删除工厂管理信息
     * 
     * @param drugFactoryId 工厂管理主键
     * @return 结果
     */
    public int deleteEpidemicDrugFactoryByDrugFactoryId(Long drugFactoryId);
}
