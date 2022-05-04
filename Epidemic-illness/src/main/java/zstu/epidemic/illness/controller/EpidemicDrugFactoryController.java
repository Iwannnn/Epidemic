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
import zstu.epidemic.illness.domain.EpidemicDrugFactory;
import zstu.epidemic.illness.service.IEpidemicDrugFactoryService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 工厂管理Controller
 * 
 * @author iwan
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/illness/drug_factory")
public class EpidemicDrugFactoryController extends BaseController
{
    @Autowired
    private IEpidemicDrugFactoryService epidemicDrugFactoryService;

    /**
     * 查询工厂管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_factory:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicDrugFactory epidemicDrugFactory)
    {
        startPage();
        List<EpidemicDrugFactory> list = epidemicDrugFactoryService.selectEpidemicDrugFactoryList(epidemicDrugFactory);
        return getDataTable(list);
    }

    /**
     * 导出工厂管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_factory:export')")
    @Log(title = "工厂管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicDrugFactory epidemicDrugFactory)
    {
        List<EpidemicDrugFactory> list = epidemicDrugFactoryService.selectEpidemicDrugFactoryList(epidemicDrugFactory);
        ExcelUtil<EpidemicDrugFactory> util = new ExcelUtil<EpidemicDrugFactory>(EpidemicDrugFactory.class);
        util.exportExcel(response, list, "工厂管理数据");
    }

    /**
     * 获取工厂管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_factory:query')")
    @GetMapping(value = "/{drugFactoryId}")
    public AjaxResult getInfo(@PathVariable("drugFactoryId") Long drugFactoryId)
    {
        return AjaxResult.success(epidemicDrugFactoryService.selectEpidemicDrugFactoryByDrugFactoryId(drugFactoryId));
    }

    /**
     * 新增工厂管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_factory:add')")
    @Log(title = "工厂管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicDrugFactory epidemicDrugFactory)
    {
        return toAjax(epidemicDrugFactoryService.insertEpidemicDrugFactory(epidemicDrugFactory));
    }

    /**
     * 修改工厂管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_factory:edit')")
    @Log(title = "工厂管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicDrugFactory epidemicDrugFactory)
    {
        return toAjax(epidemicDrugFactoryService.updateEpidemicDrugFactory(epidemicDrugFactory));
    }

    /**
     * 删除工厂管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_factory:remove')")
    @Log(title = "工厂管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{drugFactoryIds}")
    public AjaxResult remove(@PathVariable Long[] drugFactoryIds)
    {
        return toAjax(epidemicDrugFactoryService.deleteEpidemicDrugFactoryByDrugFactoryIds(drugFactoryIds));
    }
}
