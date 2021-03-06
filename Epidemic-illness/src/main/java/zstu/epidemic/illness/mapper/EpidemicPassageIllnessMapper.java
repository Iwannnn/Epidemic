package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicPassageIllness;

/**
 * 文章疾病Mapper接口
 * 
 * @author iwan
 * @date 2022-05-04
 */
public interface EpidemicPassageIllnessMapper 
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
     * 删除文章疾病
     * 
     * @param passageIllnessId 文章疾病主键
     * @return 结果
     */
    public int deleteEpidemicPassageIllnessByPassageIllnessId(Long passageIllnessId);

    /**
     * 批量删除文章疾病
     * 
     * @param passageIllnessIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicPassageIllnessByPassageIllnessIds(Long[] passageIllnessIds);
}
