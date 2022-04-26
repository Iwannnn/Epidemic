package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicFactoryMapper;
import zstu.epidemic.illness.domain.EpidemicFactory;
import zstu.epidemic.illness.service.IEpidemicFactoryService;

/**
 * 工厂管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicFactoryServiceImpl implements IEpidemicFactoryService 
{
    @Autowired
    private EpidemicFactoryMapper epidemicFactoryMapper;

    /**
     * 查询工厂管理
     * 
     * @param factoryId 工厂管理主键
     * @return 工厂管理
     */
    @Override
    public EpidemicFactory selectEpidemicFactoryByFactoryId(Long factoryId)
    {
        return epidemicFactoryMapper.selectEpidemicFactoryByFactoryId(factoryId);
    }

    /**
     * 查询工厂管理列表
     * 
     * @param epidemicFactory 工厂管理
     * @return 工厂管理
     */
    @Override
    public List<EpidemicFactory> selectEpidemicFactoryList(EpidemicFactory epidemicFactory)
    {
        return epidemicFactoryMapper.selectEpidemicFactoryList(epidemicFactory);
    }

    /**
     * 新增工厂管理
     * 
     * @param epidemicFactory 工厂管理
     * @return 结果
     */
    @Override
    public int insertEpidemicFactory(EpidemicFactory epidemicFactory)
    {
        epidemicFactory.setCreateTime(DateUtils.getNowDate());
        return epidemicFactoryMapper.insertEpidemicFactory(epidemicFactory);
    }

    /**
     * 修改工厂管理
     * 
     * @param epidemicFactory 工厂管理
     * @return 结果
     */
    @Override
    public int updateEpidemicFactory(EpidemicFactory epidemicFactory)
    {
        epidemicFactory.setUpdateTime(DateUtils.getNowDate());
        return epidemicFactoryMapper.updateEpidemicFactory(epidemicFactory);
    }

    /**
     * 批量删除工厂管理
     * 
     * @param factoryIds 需要删除的工厂管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicFactoryByFactoryIds(Long[] factoryIds)
    {
        return epidemicFactoryMapper.deleteEpidemicFactoryByFactoryIds(factoryIds);
    }

    /**
     * 删除工厂管理信息
     * 
     * @param factoryId 工厂管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicFactoryByFactoryId(Long factoryId)
    {
        return epidemicFactoryMapper.deleteEpidemicFactoryByFactoryId(factoryId);
    }
}
