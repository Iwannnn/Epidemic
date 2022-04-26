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
import zstu.epidemic.illness.domain.EpidemicTransmission;
import zstu.epidemic.illness.service.IEpidemicTransmissionService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 传播管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/transmission")
public class EpidemicTransmissionController extends BaseController
{
    @Autowired
    private IEpidemicTransmissionService epidemicTransmissionService;

    /**
     * 查询传播管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:transmission:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicTransmission epidemicTransmission)
    {
        startPage();
        List<EpidemicTransmission> list = epidemicTransmissionService.selectEpidemicTransmissionList(epidemicTransmission);
        return getDataTable(list);
    }

    /**
     * 导出传播管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:transmission:export')")
    @Log(title = "传播管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicTransmission epidemicTransmission)
    {
        List<EpidemicTransmission> list = epidemicTransmissionService.selectEpidemicTransmissionList(epidemicTransmission);
        ExcelUtil<EpidemicTransmission> util = new ExcelUtil<EpidemicTransmission>(EpidemicTransmission.class);
        util.exportExcel(response, list, "传播管理数据");
    }

    /**
     * 获取传播管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:transmission:query')")
    @GetMapping(value = "/{transmissionId}")
    public AjaxResult getInfo(@PathVariable("transmissionId") Long transmissionId)
    {
        return AjaxResult.success(epidemicTransmissionService.selectEpidemicTransmissionByTransmissionId(transmissionId));
    }

    /**
     * 新增传播管理
     */
    @PreAuthorize("@ss.hasPermi('illness:transmission:add')")
    @Log(title = "传播管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicTransmission epidemicTransmission)
    {
        return toAjax(epidemicTransmissionService.insertEpidemicTransmission(epidemicTransmission));
    }

    /**
     * 修改传播管理
     */
    @PreAuthorize("@ss.hasPermi('illness:transmission:edit')")
    @Log(title = "传播管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicTransmission epidemicTransmission)
    {
        return toAjax(epidemicTransmissionService.updateEpidemicTransmission(epidemicTransmission));
    }

    /**
     * 删除传播管理
     */
    @PreAuthorize("@ss.hasPermi('illness:transmission:remove')")
    @Log(title = "传播管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transmissionIds}")
    public AjaxResult remove(@PathVariable Long[] transmissionIds)
    {
        return toAjax(epidemicTransmissionService.deleteEpidemicTransmissionByTransmissionIds(transmissionIds));
    }
}
