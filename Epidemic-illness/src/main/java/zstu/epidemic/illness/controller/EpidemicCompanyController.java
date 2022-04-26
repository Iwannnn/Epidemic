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
import zstu.epidemic.illness.domain.EpidemicCompany;
import zstu.epidemic.illness.service.IEpidemicCompanyService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 公司管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/company")
public class EpidemicCompanyController extends BaseController
{
    @Autowired
    private IEpidemicCompanyService epidemicCompanyService;

    /**
     * 查询公司管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicCompany epidemicCompany)
    {
        startPage();
        List<EpidemicCompany> list = epidemicCompanyService.selectEpidemicCompanyList(epidemicCompany);
        return getDataTable(list);
    }

    /**
     * 导出公司管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:company:export')")
    @Log(title = "公司管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicCompany epidemicCompany)
    {
        List<EpidemicCompany> list = epidemicCompanyService.selectEpidemicCompanyList(epidemicCompany);
        ExcelUtil<EpidemicCompany> util = new ExcelUtil<EpidemicCompany>(EpidemicCompany.class);
        util.exportExcel(response, list, "公司管理数据");
    }

    /**
     * 获取公司管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:company:query')")
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Long companyId)
    {
        return AjaxResult.success(epidemicCompanyService.selectEpidemicCompanyByCompanyId(companyId));
    }

    /**
     * 新增公司管理
     */
    @PreAuthorize("@ss.hasPermi('illness:company:add')")
    @Log(title = "公司管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicCompany epidemicCompany)
    {
        return toAjax(epidemicCompanyService.insertEpidemicCompany(epidemicCompany));
    }

    /**
     * 修改公司管理
     */
    @PreAuthorize("@ss.hasPermi('illness:company:edit')")
    @Log(title = "公司管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicCompany epidemicCompany)
    {
        return toAjax(epidemicCompanyService.updateEpidemicCompany(epidemicCompany));
    }

    /**
     * 删除公司管理
     */
    @PreAuthorize("@ss.hasPermi('illness:company:remove')")
    @Log(title = "公司管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Long[] companyIds)
    {
        return toAjax(epidemicCompanyService.deleteEpidemicCompanyByCompanyIds(companyIds));
    }
}
