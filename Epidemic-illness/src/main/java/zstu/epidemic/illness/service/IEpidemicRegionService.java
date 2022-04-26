package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicRegion;

/**
 * 地区管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicRegionService 
{
    /**
     * 查询地区管理
     * 
     * @param regionId 地区管理主键
     * @return 地区管理
     */
    public EpidemicRegion selectEpidemicRegionByRegionId(Long regionId);

    /**
     * 查询地区管理列表
     * 
     * @param epidemicRegion 地区管理
     * @return 地区管理集合
     */
    public List<EpidemicRegion> selectEpidemicRegionList(EpidemicRegion epidemicRegion);

    /**
     * 新增地区管理
     * 
     * @param epidemicRegion 地区管理
     * @return 结果
     */
    public int insertEpidemicRegion(EpidemicRegion epidemicRegion);

    /**
     * 修改地区管理
     * 
     * @param epidemicRegion 地区管理
     * @return 结果
     */
    public int updateEpidemicRegion(EpidemicRegion epidemicRegion);

    /**
     * 批量删除地区管理
     * 
     * @param regionIds 需要删除的地区管理主键集合
     * @return 结果
     */
    public int deleteEpidemicRegionByRegionIds(Long[] regionIds);

    /**
     * 删除地区管理信息
     * 
     * @param regionId 地区管理主键
     * @return 结果
     */
    public int deleteEpidemicRegionByRegionId(Long regionId);
}
