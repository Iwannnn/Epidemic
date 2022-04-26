package zstu.epidemic.illness.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicDrugFactoryMapper;
import zstu.epidemic.illness.domain.EpidemicDrugFactory;
import zstu.epidemic.illness.service.IEpidemicDrugFactoryService;

/**
 * 工厂管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicDrugFactoryServiceImpl implements IEpidemicDrugFactoryService 
{
    @Autowired
    private EpidemicDrugFactoryMapper epidemicDrugFactoryMapper;

    /**
     * 查询工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 工厂管理
     */
    @Override
    public EpidemicDrugFactory selectEpidemicDrugFactoryByFactoryId(Long factoryId)
    {
        return epidemicDrugFactoryMapper.selectEpidemicDrugFactoryByFactoryId(factoryId);
    }

    /**
     * 查询工厂管理列表
     * 
     * @param epidemicDrugFactory 工厂管理
     * @return 工厂管理
     */
    @Override
    public List<EpidemicDrugFactory> selectEpidemicDrugFactoryList(EpidemicDrugFactory epidemicDrugFactory)
    {
        return epidemicDrugFactoryMapper.selectEpidemicDrugFactoryList(epidemicDrugFactory);
    }

    /**
     * 新增工厂管理
     * 
     * @param epidemicDrugFactory 工厂管理
     * @return 结果
     */
    @Override
    public int insertEpidemicDrugFactory(EpidemicDrugFactory epidemicDrugFactory)
    {
        return epidemicDrugFactoryMapper.insertEpidemicDrugFactory(epidemicDrugFactory);
    }

    /**
     * 修改工厂管理
     * 
     * @param epidemicDrugFactory 工厂管理
     * @return 结果
     */
    @Override
    public int updateEpidemicDrugFactory(EpidemicDrugFactory epidemicDrugFactory)
    {
        return epidemicDrugFactoryMapper.updateEpidemicDrugFactory(epidemicDrugFactory);
    }

    /**
     * 批量删除工厂管理
     * 
     * @param factoryIds 需要删除的工厂管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugFactoryByFactoryIds(Long[] factoryIds)
    {
        return epidemicDrugFactoryMapper.deleteEpidemicDrugFactoryByFactoryIds(factoryIds);
    }

    /**
     * 删除工厂管理信息
     * 
     * @param factoryId 工厂管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugFactoryByFactoryId(Long factoryId)
    {
        return epidemicDrugFactoryMapper.deleteEpidemicDrugFactoryByFactoryId(factoryId);
    }
}
