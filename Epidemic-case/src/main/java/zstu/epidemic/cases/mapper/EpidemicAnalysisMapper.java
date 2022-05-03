package zstu.epidemic.cases.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.domain.EpidemicPatient;
import zstu.epidemic.cases.vo.PatientDataVo;

import java.util.ArrayList;
import java.util.List;
@Mapper
@Repository
public interface EpidemicAnalysisMapper {
    ArrayList<EpidemicCase> getCaseListByIllnessName(String illness_name);
}
