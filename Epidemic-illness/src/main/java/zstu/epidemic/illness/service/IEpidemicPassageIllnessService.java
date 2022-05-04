package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicPassageIllness;

/**
 * 文章疾病Service接口
 * 
 * @author iwan
 * @date 2022-05-04
 */
public interface IEpidemicPassageIllnessService 
{
    /**
     * 查询文章疾病
     * 
     * @param passageIllnessId 文章疾病主键
     * @return 文章疾病
     */
    public EpidemicPassageIllness selectEpidemicPassageIllnessByPassageIllnessId(Long passageIllnessId);

    /**
     * 查询文章疾病列表
     * 
     * @param epidemicPassageIllness 文章疾病
     * @return 文章疾病集合
     */
    public List<EpidemicPassageIllness> selectEpidemicPassageIllnessList(EpidemicPassageIllness epidemicPassageIllness);

    /**
     * 新增文章疾病
     * 
     * @param epidemicPassageIllness 文章疾病
     * @return 结果
     */
    public int insertEpidemicPassageIllness(EpidemicPassageIllness epidemicPassageIllness);

    /**
     * 修改文章疾病
     * 
     * @param epidemicPassageIllness 文章疾病
     * @return 结果
     */
    public int updateEpidemicPassageIllness(EpidemicPassageIllness epidemicPassageIllness);

    /**
     * 批量删除文章疾病
     * 
     * @param passageIllnessIds 需要删除的文章疾病主键集合
     * @return 结果
     */
    public int deleteEpidemicPassageIllnessByPassageIllnessIds(Long[] passageIllnessIds);

    /**
     * 删除文章疾病信息
     * 
     * @param passageIllnessId 文章疾病主键
     * @return 结果
     */
    public int deleteEpidemicPassageIllnessByPassageIllnessId(Long passageIllnessId);
}
