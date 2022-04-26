package zstu.epidemic.illness.service;

import java.util.List;
import zstu.epidemic.illness.domain.EpidemicCategory;

/**
 * 疾病分类Service接口
 * 
 * @author iwan
 * @date 2022-04-26
 */
public interface IEpidemicCategoryService 
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
     * 批量删除疾病分类
     * 
     * @param categoryIds 需要删除的疾病分类主键集合
     * @return 结果
     */
    public int deleteEpidemicCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除疾病分类信息
     * 
     * @param categoryId 疾病分类主键
     * @return 结果
     */
    public int deleteEpidemicCategoryByCategoryId(Long categoryId);
}
