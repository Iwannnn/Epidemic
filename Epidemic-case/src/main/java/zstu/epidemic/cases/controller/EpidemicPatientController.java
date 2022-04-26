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
import zstu.epidemic.cases.domain.EpidemicPatient;
import zstu.epidemic.cases.service.IEpidemicPatientService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 病人管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/cases/patient")
public class EpidemicPatientController extends BaseController
{
    @Autowired
    private IEpidemicPatientService epidemicPatientService;

    /**
     * 查询病人管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:patient:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicPatient epidemicPatient)
    {
        startPage();
        List<EpidemicPatient> list = epidemicPatientService.selectEpidemicPatientList(epidemicPatient);
        return getDataTable(list);
    }

    /**
     * 导出病人管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:patient:export')")
    @Log(title = "病人管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicPatient epidemicPatient)
    {
        List<EpidemicPatient> list = epidemicPatientService.selectEpidemicPatientList(epidemicPatient);
        ExcelUtil<EpidemicPatient> util = new ExcelUtil<EpidemicPatient>(EpidemicPatient.class);
        util.exportExcel(response, list, "病人管理数据");
    }

    /**
     * 获取病人管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cases:patient:query')")
    @GetMapping(value = "/{patientId}")
    public AjaxResult getInfo(@PathVariable("patientId") Long patientId)
    {
        return AjaxResult.success(epidemicPatientService.selectEpidemicPatientByPatientId(patientId));
    }

    /**
     * 新增病人管理
     */
    @PreAuthorize("@ss.hasPermi('cases:patient:add')")
    @Log(title = "病人管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicPatient epidemicPatient)
    {
        return toAjax(epidemicPatientService.insertEpidemicPatient(epidemicPatient));
    }

    /**
     * 修改病人管理
     */
    @PreAuthorize("@ss.hasPermi('cases:patient:edit')")
    @Log(title = "病人管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicPatient epidemicPatient)
    {
        return toAjax(epidemicPatientService.updateEpidemicPatient(epidemicPatient));
    }

    /**
     * 删除病人管理
     */
    @PreAuthorize("@ss.hasPermi('cases:patient:remove')")
    @Log(title = "病人管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{patientIds}")
    public AjaxResult remove(@PathVariable Long[] patientIds)
    {
        return toAjax(epidemicPatientService.deleteEpidemicPatientByPatientIds(patientIds));
    }
}
