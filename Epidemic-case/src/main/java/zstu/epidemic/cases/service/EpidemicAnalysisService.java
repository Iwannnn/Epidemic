package zstu.epidemic.cases.service;

import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.vo.DeathRateVo;
import zstu.epidemic.cases.vo.DiffTimeVo;
import zstu.epidemic.cases.vo.DrugVo;
import zstu.epidemic.cases.vo.IllnessTransVo;
import zstu.epidemic.cases.vo.PatHistoryVo;
import zstu.epidemic.cases.vo.PatientDataVo;
import zstu.epidemic.cases.vo.RegionPatientCountVo;
import zstu.epidemic.cases.vo.SeqCompVo;

import java.util.ArrayList;

public interface EpidemicAnalysisService {
	ArrayList<EpidemicCase> getCaseListByIllnessName(String illness_name);

	DeathRateVo getDeathRate(String illness_name);

	ArrayList<RegionPatientCountVo> getRegionInfo(String illness_name);

	ArrayList<DiffTimeVo> getDiffTime(String illness_name);

	ArrayList<PatientDataVo> getPatientInfo(String illness_name);

	ArrayList<DrugVo> getDrug(String illness_name);

	ArrayList<PatHistoryVo> getPatHistory(String patient_name);

	ArrayList<SeqCompVo> getSeqComp(String illness_name);

	ArrayList<IllnessTransVo> getIllnessTrans(String illness_name);
}
