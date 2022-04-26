package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicDrug;

/**
 * 药品管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicDrugMapper 
{
    /**
     * 查询药品管理
     * 
     * @param drugId 药品管理主键
     * @return 药品管理
     */
    public EpidemicDrug selectEpidemicDrugByDrugId(Long drugId);

    /**
     * 查询药品管理列表
     * 
     * @param epidemicDrug 药品管理
     * @return 药品管理集合
     */
    public List<EpidemicDrug> selectEpidemicDrugList(EpidemicDrug epidemicDrug);

    /**
     * 新增药品管理
     * 
     * @param epidemicDrug 药品管理
     * @return 结果
     */
    public int insertEpidemicDrug(EpidemicDrug epidemicDrug);

    /**
     * 修改药品管理
     * 
     * @param epidemicDrug 药品管理
     * @return 结果
     */
    public int updateEpidemicDrug(EpidemicDrug epidemicDrug);

    /**
     * 删除药品管理
     * 
     * @param drugId 药品管理主键
     * @return 结果
     */
    public int deleteEpidemicDrugByDrugId(Long drugId);

    /**
     * 批量删除药品管理
     * 
     * @param drugIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicDrugByDrugIds(Long[] drugIds);
}
