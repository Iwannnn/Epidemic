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
import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.service.IEpidemicCaseService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 病例管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/cases/cases")
public class EpidemicCaseController extends BaseController
{
    @Autowired
    private IEpidemicCaseService epidemicCaseService;

    /**
     * 查询病例管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:cases:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicCase epidemicCase)
    {
        startPage();
        List<EpidemicCase> list = epidemicCaseService.selectEpidemicCaseList(epidemicCase);
        return getDataTable(list);
    }

    /**
     * 导出病例管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:cases:export')")
    @Log(title = "病例管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicCase epidemicCase)
    {
        List<EpidemicCase> list = epidemicCaseService.selectEpidemicCaseList(epidemicCase);
        ExcelUtil<EpidemicCase> util = new ExcelUtil<EpidemicCase>(EpidemicCase.class);
        util.exportExcel(response, list, "病例管理数据");
    }

    /**
     * 获取病例管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cases:cases:query')")
    @GetMapping(value = "/{caseId}")
    public AjaxResult getInfo(@PathVariable("caseId") Long caseId)
    {
        return AjaxResult.success(epidemicCaseService.selectEpidemicCaseByCaseId(caseId));
    }

    /**
     * 新增病例管理
     */
    @PreAuthorize("@ss.hasPermi('cases:cases:add')")
    @Log(title = "病例管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicCase epidemicCase)
    {
        return toAjax(epidemicCaseService.insertEpidemicCase(epidemicCase));
    }

    /**
     * 修改病例管理
     */
    @PreAuthorize("@ss.hasPermi('cases:cases:edit')")
    @Log(title = "病例管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicCase epidemicCase)
    {
        return toAjax(epidemicCaseService.updateEpidemicCase(epidemicCase));
    }

    /**
     * 删除病例管理
     */
    @PreAuthorize("@ss.hasPermi('cases:cases:remove')")
    @Log(title = "病例管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{caseIds}")
    public AjaxResult remove(@PathVariable Long[] caseIds)
    {
        return toAjax(epidemicCaseService.deleteEpidemicCaseByCaseIds(caseIds));
    }
}
