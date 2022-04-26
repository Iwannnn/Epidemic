package zstu.epidemic.illness.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zstu.epidemic.common.annotation.Log;
import zstu.epidemic.common.core.controller.BaseController;
import zstu.epidemic.common.core.domain.AjaxResult;
import zstu.epidemic.common.enums.BusinessType;
import zstu.epidemic.illness.domain.EpidemicCategory;
import zstu.epidemic.illness.service.IEpidemicCategoryService;
import zstu.epidemic.common.utils.poi.ExcelUtil;

/**
 * 疾病分类Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/category")
public class EpidemicCategoryController extends BaseController
{
    @Autowired
    private IEpidemicCategoryService epidemicCategoryService;

    /**
     * 查询疾病分类列表
     */
    @PreAuthorize("@ss.hasPermi('illness:category:list')")
    @GetMapping("/list")
    public AjaxResult list(EpidemicCategory epidemicCategory)
    {
        List<EpidemicCategory> list = epidemicCategoryService.selectEpidemicCategoryList(epidemicCategory);
        return AjaxResult.success(list);
    }

    /**
     * 导出疾病分类列表
     */
    @PreAuthorize("@ss.hasPermi('illness:category:export')")
    @Log(title = "疾病分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicCategory epidemicCategory)
    {
        List<EpidemicCategory> list = epidemicCategoryService.selectEpidemicCategoryList(epidemicCategory);
        ExcelUtil<EpidemicCategory> util = new ExcelUtil<EpidemicCategory>(EpidemicCategory.class);
        util.exportExcel(response, list, "疾病分类数据");
    }

    /**
     * 获取疾病分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return AjaxResult.success(epidemicCategoryService.selectEpidemicCategoryByCategoryId(categoryId));
    }

    /**
     * 新增疾病分类
     */
    @PreAuthorize("@ss.hasPermi('illness:category:add')")
    @Log(title = "疾病分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicCategory epidemicCategory)
    {
        return toAjax(epidemicCategoryService.insertEpidemicCategory(epidemicCategory));
    }

    /**
     * 修改疾病分类
     */
    @PreAuthorize("@ss.hasPermi('illness:category:edit')")
    @Log(title = "疾病分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicCategory epidemicCategory)
    {
        return toAjax(epidemicCategoryService.updateEpidemicCategory(epidemicCategory));
    }

    /**
     * 删除疾病分类
     */
    @PreAuthorize("@ss.hasPermi('illness:category:remove')")
    @Log(title = "疾病分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(epidemicCategoryService.deleteEpidemicCategoryByCategoryIds(categoryIds));
    }
}
