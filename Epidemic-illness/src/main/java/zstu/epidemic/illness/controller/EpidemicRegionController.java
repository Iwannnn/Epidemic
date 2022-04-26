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
import zstu.epidemic.illness.domain.EpidemicRegion;
import zstu.epidemic.illness.service.IEpidemicRegionService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 地区管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/region")
public class EpidemicRegionController extends BaseController
{
    @Autowired
    private IEpidemicRegionService epidemicRegionService;

    /**
     * 查询地区管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:region:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicRegion epidemicRegion)
    {
        startPage();
        List<EpidemicRegion> list = epidemicRegionService.selectEpidemicRegionList(epidemicRegion);
        return getDataTable(list);
    }

    /**
     * 导出地区管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:region:export')")
    @Log(title = "地区管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicRegion epidemicRegion)
    {
        List<EpidemicRegion> list = epidemicRegionService.selectEpidemicRegionList(epidemicRegion);
        ExcelUtil<EpidemicRegion> util = new ExcelUtil<EpidemicRegion>(EpidemicRegion.class);
        util.exportExcel(response, list, "地区管理数据");
    }

    /**
     * 获取地区管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:region:query')")
    @GetMapping(value = "/{regionId}")
    public AjaxResult getInfo(@PathVariable("regionId") Long regionId)
    {
        return AjaxResult.success(epidemicRegionService.selectEpidemicRegionByRegionId(regionId));
    }

    /**
     * 新增地区管理
     */
    @PreAuthorize("@ss.hasPermi('illness:region:add')")
    @Log(title = "地区管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicRegion epidemicRegion)
    {
        return toAjax(epidemicRegionService.insertEpidemicRegion(epidemicRegion));
    }

    /**
     * 修改地区管理
     */
    @PreAuthorize("@ss.hasPermi('illness:region:edit')")
    @Log(title = "地区管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicRegion epidemicRegion)
    {
        return toAjax(epidemicRegionService.updateEpidemicRegion(epidemicRegion));
    }

    /**
     * 删除地区管理
     */
    @PreAuthorize("@ss.hasPermi('illness:region:remove')")
    @Log(title = "地区管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{regionIds}")
    public AjaxResult remove(@PathVariable Long[] regionIds)
    {
        return toAjax(epidemicRegionService.deleteEpidemicRegionByRegionIds(regionIds));
    }
}
