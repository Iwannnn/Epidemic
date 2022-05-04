package zstu.epidemic;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zstu.epidemic.cases.domain.EpidemicCase;
import zstu.epidemic.cases.domain.EpidemicPatient;
import zstu.epidemic.cases.service.EpidemicAnalysisService;
import zstu.epidemic.cases.service.IEpidemicPatientService;

import java.util.ArrayList;

@SpringBootTest
@Ignore
public class AnalysisTest {
	@Autowired
	private EpidemicAnalysisService epidemicAnalysisService;
	@Autowired
	private IEpidemicPatientService epidemicPatientService;

	@Test
	void analysisTest() {
		ArrayList<EpidemicCase> list = epidemicAnalysisService.getCaseListByIllnessName("新冠疫情");
		System.out.println(list);
	}

	@Test
	void PatientTest() {
		ArrayList<EpidemicPatient> list = epidemicPatientService.getPatientListByIllnessName("新冠疫情");
		System.out.println(list);
	}

}
