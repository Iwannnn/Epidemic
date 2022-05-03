package zstu.epidemic.cases.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.domain.EpidemicPatient;
import zstu.epidemic.cases.mapper.EpidemicAnalysisMapper;
import zstu.epidemic.cases.mapper.EpidemicCaseHospitalMapper;
import zstu.epidemic.cases.service.EpidemicAnalysisService;
import zstu.epidemic.cases.vo.PatientDataVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class EpidemicAnalysisServiceImpl implements EpidemicAnalysisService {
    @Autowired
    private EpidemicAnalysisMapper epidemicAnalysisMapper;

    @Override
    public ArrayList<EpidemicCase> getCaseListByIllnessName(String illness_name){
        return epidemicAnalysisMapper.getCaseListByIllnessName(illness_name);
    }
    @Override
    public ArrayList<PatientDataVo> get_patient_info(String illness_name){
        return epidemicAnalysisMapper.get_patient_info(illness_name);
    }
    @Override
    public ArrayList<EpidemicPatient> getPatientListByIllnessName(String illness_name){
        return epidemicAnalysisMapper.getPatientListByIllnessName(illness_name);
    }
}
