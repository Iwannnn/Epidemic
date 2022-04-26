package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicIllness;

/**
 * 疾病管理Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicIllnessService 
{
    /**
     * 查询疾病管理
     * 
     * @param illnessId 疾病管理主键
     * @return 疾病管理
     */
    public EpidemicIllness selectEpidemicIllnessByIllnessId(Long illnessId);

    /**
     * 查询疾病管理列表
     * 
     * @param epidemicIllness 疾病管理
     * @return 疾病管理集合
     */
    public List<EpidemicIllness> selectEpidemicIllnessList(EpidemicIllness epidemicIllness);

    /**
     * 新增疾病管理
     * 
     * @param epidemicIllness 疾病管理
     * @return 结果
     */
    public int insertEpidemicIllness(EpidemicIllness epidemicIllness);

    /**
     * 修改疾病管理
     * 
     * @param epidemicIllness 疾病管理
     * @return 结果
     */
    public int updateEpidemicIllness(EpidemicIllness epidemicIllness);

    /**
     * 批量删除疾病管理
     * 
     * @param illnessIds 需要删除的疾病管理主键集合
     * @return 结果
     */
    public int deleteEpidemicIllnessByIllnessIds(Long[] illnessIds);

    /**
     * 删除疾病管理信息
     * 
     * @param illnessId 疾病管理主键
     * @return 结果
     */
    public int deleteEpidemicIllnessByIllnessId(Long illnessId);
}
