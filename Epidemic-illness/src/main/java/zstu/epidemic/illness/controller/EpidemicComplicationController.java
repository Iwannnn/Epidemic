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
import zstu.epidemic.illness.domain.EpidemicComplication;
import zstu.epidemic.illness.service.IEpidemicComplicationService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 并发症管理Controller
 * 
 * @author iwan
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/illness/complication")
public class EpidemicComplicationController extends BaseController
{
    @Autowired
    private IEpidemicComplicationService epidemicComplicationService;

    /**
     * 查询并发症管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:complication:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicComplication epidemicComplication)
    {
        startPage();
        List<EpidemicComplication> list = epidemicComplicationService.selectEpidemicComplicationList(epidemicComplication);
        return getDataTable(list);
    }

    /**
     * 导出并发症管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:complication:export')")
    @Log(title = "并发症管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicComplication epidemicComplication)
    {
        List<EpidemicComplication> list = epidemicComplicationService.selectEpidemicComplicationList(epidemicComplication);
        ExcelUtil<EpidemicComplication> util = new ExcelUtil<EpidemicComplication>(EpidemicComplication.class);
        util.exportExcel(response, list, "并发症管理数据");
    }

    /**
     * 获取并发症管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:complication:query')")
    @GetMapping(value = "/{infectCompId}")
    public AjaxResult getInfo(@PathVariable("infectCompId") Long infectCompId)
    {
        return AjaxResult.success(epidemicComplicationService.selectEpidemicComplicationByInfectCompId(infectCompId));
    }

    /**
     * 新增并发症管理
     */
    @PreAuthorize("@ss.hasPermi('illness:complication:add')")
    @Log(title = "并发症管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicComplication epidemicComplication)
    {
        return toAjax(epidemicComplicationService.insertEpidemicComplication(epidemicComplication));
    }

    /**
     * 修改并发症管理
     */
    @PreAuthorize("@ss.hasPermi('illness:complication:edit')")
    @Log(title = "并发症管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicComplication epidemicComplication)
    {
        return toAjax(epidemicComplicationService.updateEpidemicComplication(epidemicComplication));
    }

    /**
     * 删除并发症管理
     */
    @PreAuthorize("@ss.hasPermi('illness:complication:remove')")
    @Log(title = "并发症管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{infectCompIds}")
    public AjaxResult remove(@PathVariable Long[] infectCompIds)
    {
        return toAjax(epidemicComplicationService.deleteEpidemicComplicationByInfectCompIds(infectCompIds));
    }
}
