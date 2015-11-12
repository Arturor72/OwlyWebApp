import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.owly.persistence.dao.EspecialidadDao;
import com.owly.persistence.model.Especialidad;


public class DaoEspecialidadTest {

	@Autowired
	EspecialidadDao especialidadDao;
	
	
	@Test
	public void test() {
		List<Especialidad> especialidades=especialidadDao.getEspecialidades();
		for (Especialidad especialidad : especialidades) {
			System.out.println(especialidad.getEspDen());
		}
		
		assertEquals(especialidades.size(),10);
	}

}
