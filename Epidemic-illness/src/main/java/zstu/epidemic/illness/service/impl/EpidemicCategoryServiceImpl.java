package zstu.epidemic.illness.service.impl;

import java.util.List;
import zstu.epidemic.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.illness.mapper.EpidemicCategoryMapper;
import zstu.epidemic.illness.domain.EpidemicCategory;
import zstu.epidemic.illness.service.IEpidemicCategoryService;

/**
 * 疾病分类Service业务层处理
 * 
 * @author iwan
 * @date 2022-04-26
 */
@Service
public class EpidemicCategoryServiceImpl implements IEpidemicCategoryService 
{
    @Autowired
    private EpidemicCategoryMapper epidemicCategoryMapper;

    /**
     * 查询疾病分类
     * 
     * @param categoryId 疾病分类主键
     * @return 疾病分类
     */
    @Override
    public EpidemicCategory selectEpidemicCategoryByCategoryId(Long categoryId)
    {
        return epidemicCategoryMapper.selectEpidemicCategoryByCategoryId(categoryId);
    }

    /**
     * 查询疾病分类列表
     * 
     * @param epidemicCategory 疾病分类
     * @return 疾病分类
     */
    @Override
    public List<EpidemicCategory> selectEpidemicCategoryList(EpidemicCategory epidemicCategory)
    {
        return epidemicCategoryMapper.selectEpidemicCategoryList(epidemicCategory);
    }

    /**
     * 新增疾病分类
     * 
     * @param epidemicCategory 疾病分类
     * @return 结果
     */
    @Override
    public int insertEpidemicCategory(EpidemicCategory epidemicCategory)
    {
        epidemicCategory.setCreateTime(DateUtils.getNowDate());
        return epidemicCategoryMapper.insertEpidemicCategory(epidemicCategory);
    }

    /**
     * 修改疾病分类
     * 
     * @param epidemicCategory 疾病分类
     * @return 结果
     */
    @Override
    public int updateEpidemicCategory(EpidemicCategory epidemicCategory)
    {
        epidemicCategory.setUpdateTime(DateUtils.getNowDate());
        return epidemicCategoryMapper.updateEpidemicCategory(epidemicCategory);
    }

    /**
     * 批量删除疾病分类
     * 
     * @param categoryIds 需要删除的疾病分类主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicCategoryByCategoryIds(Long[] categoryIds)
    {
        return epidemicCategoryMapper.deleteEpidemicCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除疾病分类信息
     * 
     * @param categoryId 疾病分类主键
     * @return 结果
     */
    @Override
    public int deleteEpidemicCategoryByCategoryId(Long categoryId)
    {
        return epidemicCategoryMapper.deleteEpidemicCategoryByCategoryId(categoryId);
    }
}
