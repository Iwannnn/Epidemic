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
import zstu.epidemic.cases.domain.EpidemicPatientHistory;
import zstu.epidemic.cases.service.IEpidemicPatientHistoryService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 病史管理Controller
 * 
 * @author iwan
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/cases/history")
public class EpidemicPatientHistoryController extends BaseController
{
    @Autowired
    private IEpidemicPatientHistoryService epidemicPatientHistoryService;

    /**
     * 查询病史管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicPatientHistory epidemicPatientHistory)
    {
        startPage();
        List<EpidemicPatientHistory> list = epidemicPatientHistoryService.selectEpidemicPatientHistoryList(epidemicPatientHistory);
        return getDataTable(list);
    }

    /**
     * 导出病史管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:history:export')")
    @Log(title = "病史管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicPatientHistory epidemicPatientHistory)
    {
        List<EpidemicPatientHistory> list = epidemicPatientHistoryService.selectEpidemicPatientHistoryList(epidemicPatientHistory);
        ExcelUtil<EpidemicPatientHistory> util = new ExcelUtil<EpidemicPatientHistory>(EpidemicPatientHistory.class);
        util.exportExcel(response, list, "病史管理数据");
    }

    /**
     * 获取病史管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cases:history:query')")
    @GetMapping(value = "/{patientHistoryId}")
    public AjaxResult getInfo(@PathVariable("patientHistoryId") Long patientHistoryId)
    {
        return AjaxResult.success(epidemicPatientHistoryService.selectEpidemicPatientHistoryByPatientHistoryId(patientHistoryId));
    }

    /**
     * 新增病史管理
     */
    @PreAuthorize("@ss.hasPermi('cases:history:add')")
    @Log(title = "病史管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicPatientHistory epidemicPatientHistory)
    {
        return toAjax(epidemicPatientHistoryService.insertEpidemicPatientHistory(epidemicPatientHistory));
    }

    /**
     * 修改病史管理
     */
    @PreAuthorize("@ss.hasPermi('cases:history:edit')")
    @Log(title = "病史管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicPatientHistory epidemicPatientHistory)
    {
        return toAjax(epidemicPatientHistoryService.updateEpidemicPatientHistory(epidemicPatientHistory));
    }

    /**
     * 删除病史管理
     */
    @PreAuthorize("@ss.hasPermi('cases:history:remove')")
    @Log(title = "病史管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{patientHistoryIds}")
    public AjaxResult remove(@PathVariable Long[] patientHistoryIds)
    {
        return toAjax(epidemicPatientHistoryService.deleteEpidemicPatientHistoryByPatientHistoryIds(patientHistoryIds));
    }
}
