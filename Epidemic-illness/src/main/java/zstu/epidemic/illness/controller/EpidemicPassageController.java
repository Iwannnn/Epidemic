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
import zstu.epidemic.illness.domain.EpidemicPassage;
import zstu.epidemic.illness.service.IEpidemicPassageService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 文章管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/passage")
public class EpidemicPassageController extends BaseController
{
    @Autowired
    private IEpidemicPassageService epidemicPassageService;

    /**
     * 查询文章管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:passage:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicPassage epidemicPassage)
    {
        startPage();
        List<EpidemicPassage> list = epidemicPassageService.selectEpidemicPassageList(epidemicPassage);
        return getDataTable(list);
    }

    /**
     * 导出文章管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:passage:export')")
    @Log(title = "文章管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicPassage epidemicPassage)
    {
        List<EpidemicPassage> list = epidemicPassageService.selectEpidemicPassageList(epidemicPassage);
        ExcelUtil<EpidemicPassage> util = new ExcelUtil<EpidemicPassage>(EpidemicPassage.class);
        util.exportExcel(response, list, "文章管理数据");
    }

    /**
     * 获取文章管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:passage:query')")
    @GetMapping(value = "/{passageId}")
    public AjaxResult getInfo(@PathVariable("passageId") Long passageId)
    {
        return AjaxResult.success(epidemicPassageService.selectEpidemicPassageByPassageId(passageId));
    }

    /**
     * 新增文章管理
     */
    @PreAuthorize("@ss.hasPermi('illness:passage:add')")
    @Log(title = "文章管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicPassage epidemicPassage)
    {
        return toAjax(epidemicPassageService.insertEpidemicPassage(epidemicPassage));
    }

    /**
     * 修改文章管理
     */
    @PreAuthorize("@ss.hasPermi('illness:passage:edit')")
    @Log(title = "文章管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicPassage epidemicPassage)
    {
        return toAjax(epidemicPassageService.updateEpidemicPassage(epidemicPassage));
    }

    /**
     * 删除文章管理
     */
    @PreAuthorize("@ss.hasPermi('illness:passage:remove')")
    @Log(title = "文章管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{passageIds}")
    public AjaxResult remove(@PathVariable Long[] passageIds)
    {
        return toAjax(epidemicPassageService.deleteEpidemicPassageByPassageIds(passageIds));
    }
}
