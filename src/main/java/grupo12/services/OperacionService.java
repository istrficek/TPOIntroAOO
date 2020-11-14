package grupo12.services;

import grupo12.entity.Tipo1;
import grupo12.entity.Tipo2;
import grupo12.entity.Tipo3;
import grupo12.request.OperacionRequest;

import java.util.List;

public interface OperacionService {

	OperacionRequest getById(Integer id, Integer tipo);

    void savet1(Tipo1 op1);

	void savet2(Tipo2 op2);

	void savet3(Tipo3 op3);

	Float getMontoT1ById(Integer id);

	Float getMontoT2ById(Integer id);

	Float getMontoT3ById(Integer id);

	Float obtenerComision(Integer id, Integer tipoOperacion);

	List<OperacionRequest> getAllOperaciones();

	Tipo1 getByIdT1(Integer id);

	Tipo2 getByIdT2(Integer id);

	Tipo3 getByIdT3(Integer id);

	void deleteById(Integer id, Integer tipo);
}
