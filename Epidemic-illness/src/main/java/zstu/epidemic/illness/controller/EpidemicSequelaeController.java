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
import zstu.epidemic.illness.domain.EpidemicSequelae;
import zstu.epidemic.illness.service.IEpidemicSequelaeService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 后遗症Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/sequelae")
public class EpidemicSequelaeController extends BaseController
{
    @Autowired
    private IEpidemicSequelaeService epidemicSequelaeService;

    /**
     * 查询后遗症列表
     */
    @PreAuthorize("@ss.hasPermi('illness:sequelae:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicSequelae epidemicSequelae)
    {
        startPage();
        List<EpidemicSequelae> list = epidemicSequelaeService.selectEpidemicSequelaeList(epidemicSequelae);
        return getDataTable(list);
    }

    /**
     * 导出后遗症列表
     */
    @PreAuthorize("@ss.hasPermi('illness:sequelae:export')")
    @Log(title = "后遗症", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicSequelae epidemicSequelae)
    {
        List<EpidemicSequelae> list = epidemicSequelaeService.selectEpidemicSequelaeList(epidemicSequelae);
        ExcelUtil<EpidemicSequelae> util = new ExcelUtil<EpidemicSequelae>(EpidemicSequelae.class);
        util.exportExcel(response, list, "后遗症数据");
    }

    /**
     * 获取后遗症详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:sequelae:query')")
    @GetMapping(value = "/{sequelaeId}")
    public AjaxResult getInfo(@PathVariable("sequelaeId") Long sequelaeId)
    {
        return AjaxResult.success(epidemicSequelaeService.selectEpidemicSequelaeBySequelaeId(sequelaeId));
    }

    /**
     * 新增后遗症
     */
    @PreAuthorize("@ss.hasPermi('illness:sequelae:add')")
    @Log(title = "后遗症", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicSequelae epidemicSequelae)
    {
        return toAjax(epidemicSequelaeService.insertEpidemicSequelae(epidemicSequelae));
    }

    /**
     * 修改后遗症
     */
    @PreAuthorize("@ss.hasPermi('illness:sequelae:edit')")
    @Log(title = "后遗症", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicSequelae epidemicSequelae)
    {
        return toAjax(epidemicSequelaeService.updateEpidemicSequelae(epidemicSequelae));
    }

    /**
     * 删除后遗症
     */
    @PreAuthorize("@ss.hasPermi('illness:sequelae:remove')")
    @Log(title = "后遗症", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sequelaeIds}")
    public AjaxResult remove(@PathVariable Long[] sequelaeIds)
    {
        return toAjax(epidemicSequelaeService.deleteEpidemicSequelaeBySequelaeIds(sequelaeIds));
    }
}
