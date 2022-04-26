package zstu.epidemic.cases.service;

import java.util.List;
import zstu.epidemic.cases.domain.EpidemicExpert;

/**
 * 专家管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicExpertService 
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
     * 批量删除专家管理
     * 
     * @param expertIds 需要删除的专家管理主键集合
     * @return 结果
     */
    public int deleteEpidemicExpertByExpertIds(Long[] expertIds);

    /**
     * 删除专家管理信息
     * 
     * @param expertId 专家管理主键
     * @return 结果
     */
    public int deleteEpidemicExpertByExpertId(Long expertId);
}
