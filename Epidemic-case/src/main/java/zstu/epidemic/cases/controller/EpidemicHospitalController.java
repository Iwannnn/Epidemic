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
import zstu.epidemic.cases.domain.EpidemicHospital;
import zstu.epidemic.cases.service.IEpidemicHospitalService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 医院管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/cases/hospital")
public class EpidemicHospitalController extends BaseController
{
    @Autowired
    private IEpidemicHospitalService epidemicHospitalService;

    /**
     * 查询医院管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:hospital:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicHospital epidemicHospital)
    {
        startPage();
        List<EpidemicHospital> list = epidemicHospitalService.selectEpidemicHospitalList(epidemicHospital);
        return getDataTable(list);
    }

    /**
     * 导出医院管理列表
     */
    @PreAuthorize("@ss.hasPermi('cases:hospital:export')")
    @Log(title = "医院管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicHospital epidemicHospital)
    {
        List<EpidemicHospital> list = epidemicHospitalService.selectEpidemicHospitalList(epidemicHospital);
        ExcelUtil<EpidemicHospital> util = new ExcelUtil<EpidemicHospital>(EpidemicHospital.class);
        util.exportExcel(response, list, "医院管理数据");
    }

    /**
     * 获取医院管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('cases:hospital:query')")
    @GetMapping(value = "/{hospitalId}")
    public AjaxResult getInfo(@PathVariable("hospitalId") Long hospitalId)
    {
        return AjaxResult.success(epidemicHospitalService.selectEpidemicHospitalByHospitalId(hospitalId));
    }

    /**
     * 新增医院管理
     */
    @PreAuthorize("@ss.hasPermi('cases:hospital:add')")
    @Log(title = "医院管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicHospital epidemicHospital)
    {
        return toAjax(epidemicHospitalService.insertEpidemicHospital(epidemicHospital));
    }

    /**
     * 修改医院管理
     */
    @PreAuthorize("@ss.hasPermi('cases:hospital:edit')")
    @Log(title = "医院管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicHospital epidemicHospital)
    {
        return toAjax(epidemicHospitalService.updateEpidemicHospital(epidemicHospital));
    }

    /**
     * 删除医院管理
     */
    @PreAuthorize("@ss.hasPermi('cases:hospital:remove')")
    @Log(title = "医院管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hospitalIds}")
    public AjaxResult remove(@PathVariable Long[] hospitalIds)
    {
        return toAjax(epidemicHospitalService.deleteEpidemicHospitalByHospitalIds(hospitalIds));
    }
}
