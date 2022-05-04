package zstu.epidemic.cases.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.domain.EpidemicPatient;
import zstu.epidemic.cases.service.EpidemicAnalysisService;
import zstu.epidemic.cases.service.IEpidemicPatientService;
import zstu.epidemic.cases.vo.CureTimeVo;
import zstu.epidemic.cases.vo.DeathRateVo;
import zstu.epidemic.cases.vo.PatientDataVo;
import zstu.epidemic.cases.vo.RegionPatientCountVo;
import zstu.epidemic.common.core.controller.BaseController;
import zstu.epidemic.common.core.domain.AjaxResult;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/cases/analysis")
public class EpidemicAnalysisController extends BaseController {
	@Autowired
	private EpidemicAnalysisService epidemicAnalysisService;
	@Autowired
	private IEpidemicPatientService epidemicPatientService;

	// get_death_rate
	@GetMapping("/get_death_rate/{illnessName}")
	// @Cacheable(value = "get_death_rate")
	public AjaxResult get_death_rate(@PathVariable String illnessName) {
		System.out.println(illnessName);
		ArrayList<EpidemicCase> list = epidemicAnalysisService.getCaseListByIllnessName(illnessName);
		int death_number = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIsDie() == 1)
				death_number++;
		}
		DeathRateVo deathRateVo = new DeathRateVo();
		deathRateVo.setAll_number(list.size());
		deathRateVo.setDeath_number(death_number);
		return AjaxResult.success("death_rateVoByIllnessName", deathRateVo);
	}

	// get_diff_time
	@GetMapping("get_diff_time/{illnessName}")
	// @Cacheable(value = "get_diff_time")
	public AjaxResult get_diff_time(@PathVariable String illnessName) {
		ArrayList<EpidemicCase> list = epidemicAnalysisService.getCaseListByIllnessName(illnessName);
		ArrayList<CureTimeVo> finalList = new ArrayList<>();
		// <days,peopleCount>
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			EpidemicCase case1 = list.get(i);
			if (case1.getIsCure() == 1) {
				// 计算两个date之间的的日子数差
				Date date1 = case1.getInfectTime();
				Date date2 = case1.getCureTime();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date1);
				long timeInMillis1 = calendar.getTimeInMillis();
				calendar.setTime(date2);
				long timeInMillis2 = calendar.getTimeInMillis();

				int betweenDays = (int) ((timeInMillis2 - timeInMillis1) / (1000L * 3600L * 24L));
				if (!map.containsKey(betweenDays)) {
					map.put(betweenDays, 1);
				} else {
					Integer peopleCount = map.get(betweenDays) + 1;
					map.remove(betweenDays);
					map.put(betweenDays, peopleCount);
				}
			}
		}
		for (HashMap.Entry<Integer, Integer> map_ : map.entrySet()) {
			CureTimeVo cureTimeVo = new CureTimeVo();
			cureTimeVo.setCureTime(map_.getKey());
			cureTimeVo.setCuredCount(map_.getValue());
			finalList.add(cureTimeVo);
		}
		return AjaxResult.success("cureTimeList", finalList);
	}

	// get_patient_info
	@GetMapping("get_patient_info/{illnessName}")
	// @Cacheable(value = "get_patient_info")
	public AjaxResult get_patient_info(@PathVariable String illnessName) {
		ArrayList<EpidemicPatient> list = epidemicPatientService.getPatientListByIllnessName(illnessName);
		ArrayList<PatientDataVo> finalList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			EpidemicPatient patient = list.get(i);
			PatientDataVo patientDataVo = new PatientDataVo();
			patientDataVo.setHeight(patient.getHeight());
			patientDataVo.setWeight(patient.getWeight());
			patientDataVo.setFat(patient.getFat());
			patientDataVo.setAge(patient.getPatientAge());
			finalList.add(patientDataVo);
		}
		return AjaxResult.success("patientDataList", finalList);
	}

	// get_region_info
	@GetMapping("get_region_info/{illnessName}")
	// @Cacheable(value = "get_region_info")
	public AjaxResult get_region_info(@PathVariable String illnessName) {
		ArrayList<EpidemicPatient> patientList = epidemicPatientService.getPatientListByIllnessName(illnessName);
		ArrayList<RegionPatientCountVo> finalList = new ArrayList<>();
		// <regionID,peopleCount>
		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < patientList.size(); i++) {
			EpidemicPatient case1 = patientList.get(i);
			Long regionId = case1.getLiveRegionId();
			if (!map.containsKey(regionId)) {
				map.put(regionId, 1);
			} else {
				Integer peopleCount = map.get(regionId) + 1;
				map.remove(regionId);
				map.put(regionId, peopleCount);
			}
		}
		for (HashMap.Entry<Long, Integer> map_ : map.entrySet()) {
			RegionPatientCountVo regionPatientCountVo = new RegionPatientCountVo();
			regionPatientCountVo.setRegionId(map_.getKey());
			regionPatientCountVo.setCount(map_.getValue());
			finalList.add(regionPatientCountVo);
		}
		return AjaxResult.success("RegionPatientList", finalList);
	}

}
