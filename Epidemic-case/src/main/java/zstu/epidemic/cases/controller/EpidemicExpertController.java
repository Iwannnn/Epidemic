package zstu.epidemic.cases.controller;

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
import zstu.epidemic.cases.domain.EpidemicExpert;
import zstu.epidemic.cases.service.IEpidemicExpertService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 专家管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/cases/expert")
public class EpidemicExpertController extends BaseController
{
    @Autowired
    private IEpidemicExpertService epidemicExpertService;

    /**
     * 查询专家管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:expert:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicExpert epidemicExpert)
    {
        startPage();
        List<EpidemicExpert> list = epidemicExpertService.selectEpidemicExpertList(epidemicExpert);
        return getDataTable(list);
    }

    /**
     * 导出专家管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:expert:export')")
    @Log(title = "专家管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicExpert epidemicExpert)
    {
        List<EpidemicExpert> list = epidemicExpertService.selectEpidemicExpertList(epidemicExpert);
        ExcelUtil<EpidemicExpert> util = new ExcelUtil<EpidemicExpert>(EpidemicExpert.class);
        util.exportExcel(response, list, "专家管理数据");
    }

    /**
     * 获取专家管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cases:expert:query')")
    @GetMapping(value = "/{expertId}")
    public AjaxResult getInfo(@PathVariable("expertId") Long expertId)
    {
        return AjaxResult.success(epidemicExpertService.selectEpidemicExpertByExpertId(expertId));
    }

    /**
     * 新增专家管理
     */
    @PreAuthorize("@ss.hasPermi('cases:expert:add')")
    @Log(title = "专家管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicExpert epidemicExpert)
    {
        return toAjax(epidemicExpertService.insertEpidemicExpert(epidemicExpert));
    }

    /**
     * 修改专家管理
     */
    @PreAuthorize("@ss.hasPermi('cases:expert:edit')")
    @Log(title = "专家管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicExpert epidemicExpert)
    {
        return toAjax(epidemicExpertService.updateEpidemicExpert(epidemicExpert));
    }

    /**
     * 删除专家管理
     */
    @PreAuthorize("@ss.hasPermi('cases:expert:remove')")
    @Log(title = "专家管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{expertIds}")
    public AjaxResult remove(@PathVariable Long[] expertIds)
    {
        return toAjax(epidemicExpertService.deleteEpidemicExpertByExpertIds(expertIds));
    }
}
