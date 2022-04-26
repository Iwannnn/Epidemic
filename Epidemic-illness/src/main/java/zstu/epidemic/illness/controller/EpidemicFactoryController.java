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
import zstu.epidemic.illness.domain.EpidemicFactory;
import zstu.epidemic.illness.service.IEpidemicFactoryService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 工厂管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/factory")
public class EpidemicFactoryController extends BaseController
{
    @Autowired
    private IEpidemicFactoryService epidemicFactoryService;

    /**
     * 查询工厂管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:factory:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicFactory epidemicFactory)
    {
        startPage();
        List<EpidemicFactory> list = epidemicFactoryService.selectEpidemicFactoryList(epidemicFactory);
        return getDataTable(list);
    }

    /**
     * 导出工厂管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:factory:export')")
    @Log(title = "工厂管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicFactory epidemicFactory)
    {
        List<EpidemicFactory> list = epidemicFactoryService.selectEpidemicFactoryList(epidemicFactory);
        ExcelUtil<EpidemicFactory> util = new ExcelUtil<EpidemicFactory>(EpidemicFactory.class);
        util.exportExcel(response, list, "工厂管理数据");
    }

    /**
     * 获取工厂管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:factory:query')")
    @GetMapping(value = "/{factoryId}")
    public AjaxResult getInfo(@PathVariable("factoryId") Long factoryId)
    {
        return AjaxResult.success(epidemicFactoryService.selectEpidemicFactoryByFactoryId(factoryId));
    }

    /**
     * 新增工厂管理
     */
    @PreAuthorize("@ss.hasPermi('illness:factory:add')")
    @Log(title = "工厂管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicFactory epidemicFactory)
    {
        return toAjax(epidemicFactoryService.insertEpidemicFactory(epidemicFactory));
    }

    /**
     * 修改工厂管理
     */
    @PreAuthorize("@ss.hasPermi('illness:factory:edit')")
    @Log(title = "工厂管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicFactory epidemicFactory)
    {
        return toAjax(epidemicFactoryService.updateEpidemicFactory(epidemicFactory));
    }

    /**
     * 删除工厂管理
     */
    @PreAuthorize("@ss.hasPermi('illness:factory:remove')")
    @Log(title = "工厂管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{factoryIds}")
    public AjaxResult remove(@PathVariable Long[] factoryIds)
    {
        return toAjax(epidemicFactoryService.deleteEpidemicFactoryByFactoryIds(factoryIds));
    }
}
