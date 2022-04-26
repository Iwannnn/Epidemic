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
import zstu.epidemic.illness.domain.EpidemicPassageContent;
import zstu.epidemic.illness.service.IEpidemicPassageContentService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 文章内容Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/content")
public class EpidemicPassageContentController extends BaseController
{
    @Autowired
    private IEpidemicPassageContentService epidemicPassageContentService;

    /**
     * 查询文章内容列表
     */
    @PreAuthorize("@ss.hasPermi('illness:content:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicPassageContent epidemicPassageContent)
    {
        startPage();
        List<EpidemicPassageContent> list = epidemicPassageContentService.selectEpidemicPassageContentList(epidemicPassageContent);
        return getDataTable(list);
    }

    /**
     * 导出文章内容列表
     */
    @PreAuthorize("@ss.hasPermi('illness:content:export')")
    @Log(title = "文章内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicPassageContent epidemicPassageContent)
    {
        List<EpidemicPassageContent> list = epidemicPassageContentService.selectEpidemicPassageContentList(epidemicPassageContent);
        ExcelUtil<EpidemicPassageContent> util = new ExcelUtil<EpidemicPassageContent>(EpidemicPassageContent.class);
        util.exportExcel(response, list, "文章内容数据");
    }

    /**
     * 获取文章内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:content:query')")
    @GetMapping(value = "/{contentId}")
    public AjaxResult getInfo(@PathVariable("contentId") Long contentId)
    {
        return AjaxResult.success(epidemicPassageContentService.selectEpidemicPassageContentByContentId(contentId));
    }

    /**
     * 新增文章内容
     */
    @PreAuthorize("@ss.hasPermi('illness:content:add')")
    @Log(title = "文章内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicPassageContent epidemicPassageContent)
    {
        return toAjax(epidemicPassageContentService.insertEpidemicPassageContent(epidemicPassageContent));
    }

    /**
     * 修改文章内容
     */
    @PreAuthorize("@ss.hasPermi('illness:content:edit')")
    @Log(title = "文章内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicPassageContent epidemicPassageContent)
    {
        return toAjax(epidemicPassageContentService.updateEpidemicPassageContent(epidemicPassageContent));
    }

    /**
     * 删除文章内容
     */
    @PreAuthorize("@ss.hasPermi('illness:content:remove')")
    @Log(title = "文章内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{contentIds}")
    public AjaxResult remove(@PathVariable Long[] contentIds)
    {
        return toAjax(epidemicPassageContentService.deleteEpidemicPassageContentByContentIds(contentIds));
    }
}
