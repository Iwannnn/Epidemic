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
import zstu.epidemic.illness.domain.EpidemicDrugCompany;
import zstu.epidemic.illness.service.IEpidemicDrugCompanyService;
import zstu.epidemic.common.utils.poi.ExcelUtil;
import zstu.epidemic.common.core.page.TableDataInfo;

/**
 * 公司药品管理Controller
 * 
 * @author iwan
 * @date 2022-04-26
 */
@RestController
@RequestMapping("/illness/drug_company")
public class EpidemicDrugCompanyController extends BaseController
{
    @Autowired
    private IEpidemicDrugCompanyService epidemicDrugCompanyService;

    /**
     * 查询公司药品管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_company:list')")
    @GetMapping("/list")
    public TableDataInfo list(EpidemicDrugCompany epidemicDrugCompany)
    {
        startPage();
        List<EpidemicDrugCompany> list = epidemicDrugCompanyService.selectEpidemicDrugCompanyList(epidemicDrugCompany);
        return getDataTable(list);
    }

    /**
     * 导出公司药品管理列表
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_company:export')")
    @Log(title = "公司药品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EpidemicDrugCompany epidemicDrugCompany)
    {
        List<EpidemicDrugCompany> list = epidemicDrugCompanyService.selectEpidemicDrugCompanyList(epidemicDrugCompany);
        ExcelUtil<EpidemicDrugCompany> util = new ExcelUtil<EpidemicDrugCompany>(EpidemicDrugCompany.class);
        util.exportExcel(response, list, "公司药品管理数据");
    }

    /**
     * 获取公司药品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_company:query')")
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Long companyId)
    {
        return AjaxResult.success(epidemicDrugCompanyService.selectEpidemicDrugCompanyByCompanyId(companyId));
    }

    /**
     * 新增公司药品管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_company:add')")
    @Log(title = "公司药品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EpidemicDrugCompany epidemicDrugCompany)
    {
        return toAjax(epidemicDrugCompanyService.insertEpidemicDrugCompany(epidemicDrugCompany));
    }

    /**
     * 修改公司药品管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_company:edit')")
    @Log(title = "公司药品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EpidemicDrugCompany epidemicDrugCompany)
    {
        return toAjax(epidemicDrugCompanyService.updateEpidemicDrugCompany(epidemicDrugCompany));
    }

    /**
     * 删除公司药品管理
     */
    @PreAuthorize("@ss.hasPermi('illness:drug_company:remove')")
    @Log(title = "公司药品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Long[] companyIds)
    {
        return toAjax(epidemicDrugCompanyService.deleteEpidemicDrugCompanyByCompanyIds(companyIds));
    }
}
