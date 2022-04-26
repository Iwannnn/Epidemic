package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicRegionMapper;
import zstu.epidemic.illness.domain.EpidemicRegion;
import zstu.epidemic.illness.service.IEpidemicRegionService;

/**
 * 地区管理Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicRegionServiceImpl implements IEpidemicRegionService 
{
    @Autowired
    private EpidemicRegionMapper epidemicRegionMapper;

    /**
     * 查询地区管理
     * 
     * @param regionId 地区管理主键
     * @return 地区管理
     */
    @Override
    public EpidemicRegion selectEpidemicRegionByRegionId(Long regionId)
    {
        return epidemicRegionMapper.selectEpidemicRegionByRegionId(regionId);
    }

    /**
     * 查询地区管理列表
     * 
     * @param epidemicRegion 地区管理
     * @return 地区管理
     */
    @Override
    public List<EpidemicRegion> selectEpidemicRegionList(EpidemicRegion epidemicRegion)
    {
        return epidemicRegionMapper.selectEpidemicRegionList(epidemicRegion);
    }

    /**
     * 新增地区管理
     * 
     * @param epidemicRegion 地区管理
     * @return 结果
     */
    @Override
    public int insertEpidemicRegion(EpidemicRegion epidemicRegion)
    {
        epidemicRegion.setCreateTime(DateUtils.getNowDate());
        return epidemicRegionMapper.insertEpidemicRegion(epidemicRegion);
    }

    /**
     * 修改地区管理
     * 
     * @param epidemicRegion 地区管理
     * @return 结果
     */
    @Override
    public int updateEpidemicRegion(EpidemicRegion epidemicRegion)
    {
        epidemicRegion.setUpdateTime(DateUtils.getNowDate());
        return epidemicRegionMapper.updateEpidemicRegion(epidemicRegion);
    }

    /**
     * 批量删除地区管理
     * 
     * @param regionIds 需要删除的地区管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicRegionByRegionIds(Long[] regionIds)
    {
        return epidemicRegionMapper.deleteEpidemicRegionByRegionIds(regionIds);
    }

    /**
     * 删除地区管理信息
     * 
     * @param regionId 地区管理主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicRegionByRegionId(Long regionId)
    {
        return epidemicRegionMapper.deleteEpidemicRegionByRegionId(regionId);
    }
}
