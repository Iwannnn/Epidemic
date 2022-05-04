package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicDrugIllness;

/**
 * 疾病药品Service接口
 * 
 * @author iwan
 * @date 2022-05-04
 */
public interface IEpidemicDrugIllnessService 
{
    /**
     * 查询疾病药品
     * 
     * @param drugIllnessId 疾病药品主键
     * @return 疾病药品
     */
    public EpidemicDrugIllness selectEpidemicDrugIllnessByDrugIllnessId(Long drugIllnessId);

    /**
     * 查询疾病药品列表
     * 
     * @param epidemicDrugIllness 疾病药品
     * @return 疾病药品集合
     */
    public List<EpidemicDrugIllness> selectEpidemicDrugIllnessList(EpidemicDrugIllness epidemicDrugIllness);

    /**
     * 新增疾病药品
     * 
     * @param epidemicDrugIllness 疾病药品
     * @return 结果
     */
    public int insertEpidemicDrugIllness(EpidemicDrugIllness epidemicDrugIllness);

    /**
     * 修改疾病药品
     * 
     * @param epidemicDrugIllness 疾病药品
     * @return 结果
     */
    public int updateEpidemicDrugIllness(EpidemicDrugIllness epidemicDrugIllness);

    /**
     * 批量删除疾病药品
     * 
     * @param drugIllnessIds 需要删除的疾病药品主键集合
     * @return 结果
     */
    public int deleteEpidemicDrugIllnessByDrugIllnessIds(Long[] drugIllnessIds);

    /**
     * 删除疾病药品信息
     * 
     * @param drugIllnessId 疾病药品主键
     * @return 结果
     */
    public int deleteEpidemicDrugIllnessByDrugIllnessId(Long drugIllnessId);
}
