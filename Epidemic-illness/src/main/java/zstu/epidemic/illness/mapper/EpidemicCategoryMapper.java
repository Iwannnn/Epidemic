package zstu.epidemic.illness.mapper;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicCategory;

/**
 * 疾病分类Mapper接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface EpidemicCategoryMapper 
{
    /**
     * 查询疾病分类
     * 
     * @param categoryId 疾病分类主键
     * @return 疾病分类
     */
    public EpidemicCategory selectEpidemicCategoryByCategoryId(Long categoryId);

    /**
     * 查询疾病分类列表
     * 
     * @param epidemicCategory 疾病分类
     * @return 疾病分类集合
     */
    public List<EpidemicCategory> selectEpidemicCategoryList(EpidemicCategory epidemicCategory);

    /**
     * 新增疾病分类
     * 
     * @param epidemicCategory 疾病分类
     * @return 结果
     */
    public int insertEpidemicCategory(EpidemicCategory epidemicCategory);

    /**
     * 修改疾病分类
     * 
     * @param epidemicCategory 疾病分类
     * @return 结果
     */
    public int updateEpidemicCategory(EpidemicCategory epidemicCategory);

    /**
     * 删除疾病分类
     * 
     * @param categoryId 疾病分类主键
     * @return 结果
     */
    public int deleteEpidemicCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除疾病分类
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEpidemicCategoryByCategoryIds(Long[] categoryIds);
}
