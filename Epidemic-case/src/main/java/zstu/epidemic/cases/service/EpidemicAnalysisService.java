package zstu.epidemic.cases.service;

import zstu.epidemic.cases.domain.EpidemicCase;

import java.util.ArrayList;

public interface EpidemicAnalysisService {
	ArrayList<EpidemicCase> getCaseListByIllnessName(String illness_name);

}
