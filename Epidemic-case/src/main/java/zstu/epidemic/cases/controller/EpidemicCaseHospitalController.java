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
import zstu.epidemic.cases.domain.EpidemicCaseHospital;
import zstu.epidemic.cases.service.IEpidemicCaseHospitalService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 病例医院管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/cases/case_hospital")
public class EpidemicCaseHospitalController extends BaseController
{
    @Autowired
    private IEpidemicCaseHospitalService epidemicCaseHospitalService;

    /**
     * 查询病例医院管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:case_hospital:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicCaseHospital epidemicCaseHospital)
    {
        startPage();
        List<EpidemicCaseHospital> list = epidemicCaseHospitalService.selectEpidemicCaseHospitalList(epidemicCaseHospital);
        return getDataTable(list);
    }

    /**
     * 导出病例医院管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:case_hospital:export')")
    @Log(title = "病例医院管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicCaseHospital epidemicCaseHospital)
    {
        List<EpidemicCaseHospital> list = epidemicCaseHospitalService.selectEpidemicCaseHospitalList(epidemicCaseHospital);
        ExcelUtil<EpidemicCaseHospital> util = new ExcelUtil<EpidemicCaseHospital>(EpidemicCaseHospital.class);
        util.exportExcel(response, list, "病例医院管理数据");
    }

    /**
     * 获取病例医院管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cases:case_hospital:query')")
    @GetMapping(value = "/{caseHospitalId}")
    public AjaxResult getInfo(@PathVariable("caseHospitalId") Long caseHospitalId)
    {
        return AjaxResult.success(epidemicCaseHospitalService.selectEpidemicCaseHospitalByCaseHospitalId(caseHospitalId));
    }

    /**
     * 新增病例医院管理
     */
    @PreAuthorize("@ss.hasPermi('cases:case_hospital:add')")
    @Log(title = "病例医院管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicCaseHospital epidemicCaseHospital)
    {
        return toAjax(epidemicCaseHospitalService.insertEpidemicCaseHospital(epidemicCaseHospital));
    }

    /**
     * 修改病例医院管理
     */
    @PreAuthorize("@ss.hasPermi('cases:case_hospital:edit')")
    @Log(title = "病例医院管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicCaseHospital epidemicCaseHospital)
    {
        return toAjax(epidemicCaseHospitalService.updateEpidemicCaseHospital(epidemicCaseHospital));
    }

    /**
     * 删除病例医院管理
     */
    @PreAuthorize("@ss.hasPermi('cases:case_hospital:remove')")
    @Log(title = "病例医院管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{caseHospitalIds}")
    public AjaxResult remove(@PathVariable Long[] caseHospitalIds)
    {
        return toAjax(epidemicCaseHospitalService.deleteEpidemicCaseHospitalByCaseHospitalIds(caseHospitalIds));
    }
}
