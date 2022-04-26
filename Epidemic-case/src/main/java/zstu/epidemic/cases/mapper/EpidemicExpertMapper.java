package zstu.epidemic.cases.mapper;

import java.util.List;
import zstu.epidemic.cases.domain.EpidemicExpert;

/**
 * 专家管理Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicExpertMapper 
{
    /**
     * 查询专家管理
     * 
     * @param expertId 专家管理主键
     * @return 专家管理
     */
    public EpidemicExpert selectEpidemicExpertByExpertId(Long expertId);

    /**
     * 查询专家管理列表
     * 
     * @param epidemicExpert 专家管理
     * @return 专家管理集合
     */
    public List<EpidemicExpert> selectEpidemicExpertList(EpidemicExpert epidemicExpert);

    /**
     * 新增专家管理
     * 
     * @param epidemicExpert 专家管理
     * @return 结果
     */
    public int insertEpidemicExpert(EpidemicExpert epidemicExpert);

    /**
     * 修改专家管理
     * 
     * @param epidemicExpert 专家管理
     * @return 结果
     */
    public int updateEpidemicExpert(EpidemicExpert epidemicExpert);

    /**
     * 删除专家管理
     * 
     * @param expertId 专家管理主键
     * @return 结果
     */
    public int deleteEpidemicExpertByExpertId(Long expertId);

    /**
     * 批量删除专家管理
     * 
     * @param expertIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicExpertByExpertIds(Long[] expertIds);
}
