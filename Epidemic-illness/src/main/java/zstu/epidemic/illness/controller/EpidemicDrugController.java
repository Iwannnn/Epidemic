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
import zstu.epidemic.illness.domain.EpidemicDrug;
import zstu.epidemic.illness.service.IEpidemicDrugService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 药品管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/drug")
public class EpidemicDrugController extends BaseController
{
    @Autowired
    private IEpidemicDrugService epidemicDrugService;

    /**
     * 查询药品管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:drug:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicDrug epidemicDrug)
    {
        startPage();
        List<EpidemicDrug> list = epidemicDrugService.selectEpidemicDrugList(epidemicDrug);
        return getDataTable(list);
    }

    /**
     * 导出药品管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:drug:export')")
    @Log(title = "药品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicDrug epidemicDrug)
    {
        List<EpidemicDrug> list = epidemicDrugService.selectEpidemicDrugList(epidemicDrug);
        ExcelUtil<EpidemicDrug> util = new ExcelUtil<EpidemicDrug>(EpidemicDrug.class);
        util.exportExcel(response, list, "药品管理数据");
    }

    /**
     * 获取药品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:drug:query')")
    @GetMapping(value = "/{drugId}")
    public AjaxResult getInfo(@PathVariable("drugId") Long drugId)
    {
        return AjaxResult.success(epidemicDrugService.selectEpidemicDrugByDrugId(drugId));
    }

    /**
     * 新增药品管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug:add')")
    @Log(title = "药品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicDrug epidemicDrug)
    {
        return toAjax(epidemicDrugService.insertEpidemicDrug(epidemicDrug));
    }

    /**
     * 修改药品管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug:edit')")
    @Log(title = "药品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicDrug epidemicDrug)
    {
        return toAjax(epidemicDrugService.updateEpidemicDrug(epidemicDrug));
    }

    /**
     * 删除药品管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug:remove')")
    @Log(title = "药品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{drugIds}")
    public AjaxResult remove(@PathVariable Long[] drugIds)
    {
        return toAjax(epidemicDrugService.deleteEpidemicDrugByDrugIds(drugIds));
    }
}
