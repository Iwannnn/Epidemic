package zstu.epidemic.cases.service;

import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.domain.EpidemicPatient;
import zstu.epidemic.cases.vo.PatientDataVo;

import java.util.ArrayList;
import java.util.List;

public interface EpidemicAnalysisService {
    ArrayList<EpidemicCase> getCaseListByIllnessName(String illness_name);

}
