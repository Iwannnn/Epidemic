package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicIllnessTrans;

/**
 * 疾病传播方式Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicIllnessTransService 
{
    /**
     * 查询疾病传播方式
     * 
     * @param transId 疾病传播方式主键
     * @return 疾病传播方式
     */
    public EpidemicIllnessTrans selectEpidemicIllnessTransByTransId(Long transId);

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
     * @param transIds 需要删除的疾病传播方式主键集合
     * @return 结果
     */
    public int deleteEpidemicIllnessTransByTransIds(Long[] transIds);

    /**
     * 删除疾病传播方式信息
     * 
     * @param transId 疾病传播方式主键
     * @return 结果
     */
    public int deleteEpidemicIllnessTransByTransId(Long transId);
}
