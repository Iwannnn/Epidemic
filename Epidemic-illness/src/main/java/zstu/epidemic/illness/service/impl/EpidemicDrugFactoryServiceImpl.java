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
 * @date 2022-05-04
 */
@Service
public class EpidemicDrugFactoryServiceImpl implements IEpidemicDrugFactoryService 
{
    @Autowired
    private EpidemicDrugFactoryMapper epidemicDrugFactoryMapper;

    /**
     * 查询工厂管理
     * 
     * @param drugFactoryId 工厂管理主键
     * @return 工厂管理
     */
    @Override
    public EpidemicDrugFactory selectEpidemicDrugFactoryByDrugFactoryId(Long drugFactoryId)
    {
        return epidemicDrugFactoryMapper.selectEpidemicDrugFactoryByDrugFactoryId(drugFactoryId);
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
     * @param drugFactoryIds 需要删除的工厂管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugFactoryByDrugFactoryIds(Long[] drugFactoryIds)
    {
        return epidemicDrugFactoryMapper.deleteEpidemicDrugFactoryByDrugFactoryIds(drugFactoryIds);
    }

    /**
     * 删除工厂管理信息
     * 
     * @param drugFactoryId 工厂管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicDrugFactoryByDrugFactoryId(Long drugFactoryId)
    {
        return epidemicDrugFactoryMapper.deleteEpidemicDrugFactoryByDrugFactoryId(drugFactoryId);
    }
}
