package zstu.epidemic.cases.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.mapper.EpidemicAnalysisMapper;
import zstu.epidemic.cases.service.EpidemicAnalysisService;
import zstu.epidemic.cases.vo.DeathRateVo;
import zstu.epidemic.cases.vo.DiffTimeVo;
import zstu.epidemic.cases.vo.DrugVo;
import zstu.epidemic.cases.vo.IllnessTransVo;
import zstu.epidemic.cases.vo.PatHistoryVo;
import zstu.epidemic.cases.vo.PatientDataVo;
import zstu.epidemic.cases.vo.RegionPatientCountVo;
import zstu.epidemic.cases.vo.SeqCompVo;

import java.util.ArrayList;

@Service
public class EpidemicAnalysisServiceImpl implements EpidemicAnalysisService {
	@Autowired
	private EpidemicAnalysisMapper epidemicAnalysisMapper;

	@Override
	public ArrayList<EpidemicCase> getCaseListByIllnessName(String illness_name) {
		return epidemicAnalysisMapper.getCaseListByIllnessName(illness_name);
	}

	@Override
	public DeathRateVo getDeathRate(String illness_name) {
		return epidemicAnalysisMapper.getDeathRate(illness_name);
	}

	@Override
	public ArrayList<RegionPatientCountVo> getRegionInfo(String illness_name) {
		return epidemicAnalysisMapper.getRegionInfo(illness_name);
	}

	@Override
	public ArrayList<DiffTimeVo> getDiffTime(String illness_name) {
		return epidemicAnalysisMapper.getDiffTime(illness_name);
	}

	@Override
	public ArrayList<PatientDataVo> getPatientInfo(String illness_name) {
		return epidemicAnalysisMapper.getPatientInfo(illness_name);
	}

	@Override
	public ArrayList<DrugVo> getDrug(String illness_name) {
		return epidemicAnalysisMapper.getDrug(illness_name);
	}

	@Override
	public ArrayList<PatHistoryVo> getPatHistory(String patient_name) {
		return epidemicAnalysisMapper.getPatHistory(patient_name);
	}

	@Override
	public ArrayList<SeqCompVo> getSeqComp(String illness_name) {
		return epidemicAnalysisMapper.getSeqComp(illness_name);
	}

	@Override
	public ArrayList<IllnessTransVo> getIllnessTrans(String illness_name) {
		return epidemicAnalysisMapper.getIllnessTrans(illness_name);
	}
}
