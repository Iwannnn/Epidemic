package zstu.epidemic.cases.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.mapper.EpidemicAnalysisMapper;
import zstu.epidemic.cases.service.EpidemicAnalysisService;

import java.util.ArrayList;

@Service
public class EpidemicAnalysisServiceImpl implements EpidemicAnalysisService {
	@Autowired
	private EpidemicAnalysisMapper epidemicAnalysisMapper;

	@Override
	public ArrayList<EpidemicCase> getCaseListByIllnessName(String illness_name) {
		return epidemicAnalysisMapper.getCaseListByIllnessName(illness_name);
	}

}
