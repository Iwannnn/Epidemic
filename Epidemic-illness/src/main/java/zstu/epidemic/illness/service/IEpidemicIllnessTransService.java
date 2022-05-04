package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicIllnessTrans;

/**
 * 疾病传播方式Service接口
 * 
 * @author iwan
 * @date 2022-05-04
 */
public interface IEpidemicIllnessTransService 
{
    /**
     * 查询疾病传播方式
     * 
     * @param illnessTransId 疾病传播方式主键
     * @return 疾病传播方式
     */
    public EpidemicIllnessTrans selectEpidemicIllnessTransByIllnessTransId(Long illnessTransId);

    /**
     * 查询疾病传播方式列表
     * 
     * @param epidemicIllnessTrans 疾病传播方式
     * @return 疾病传播方式集合
     */
    public List<EpidemicIllnessTrans> selectEpidemicIllnessTransList(EpidemicIllnessTrans epidemicIllnessTrans);

    /**
     * 新增疾病传播方式
     * 
     * @param epidemicIllnessTrans 疾病传播方式
     * @return 结果
     */
    public int insertEpidemicIllnessTrans(EpidemicIllnessTrans epidemicIllnessTrans);

    /**
     * 修改疾病传播方式
     * 
     * @param epidemicIllnessTrans 疾病传播方式
     * @return 结果
     */
    public int updateEpidemicIllnessTrans(EpidemicIllnessTrans epidemicIllnessTrans);

    /**
     * 批量删除疾病传播方式
     * 
     * @param illnessTransIds 需要删除的疾病传播方式主键集合
     * @return 结果
     */
    public int deleteEpidemicIllnessTransByIllnessTransIds(Long[] illnessTransIds);

    /**
     * 删除疾病传播方式信息
     * 
     * @param illnessTransId 疾病传播方式主键
     * @return 结果
     */
    public int deleteEpidemicIllnessTransByIllnessTransId(Long illnessTransId);
}
