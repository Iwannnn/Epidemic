package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicPassageIllness;

/**
 * 文章疾病Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicPassageIllnessService 
{
    /**
     * 查询文章疾病
     * 
     * @param passageId 文章疾病主键
     * @return 文章疾病
     */
    public EpidemicPassageIllness selectEpidemicPassageIllnessByPassageId(Long passageId);

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
     * @param passageIds 需要删除的文章疾病主键集合
     * @return 结果
     */
    public int deleteEpidemicPassageIllnessByPassageIds(Long[] passageIds);

    /**
     * 删除文章疾病信息
     * 
     * @param passageId 文章疾病主键
     * @return 结果
     */
    public int deleteEpidemicPassageIllnessByPassageId(Long passageId);
}
