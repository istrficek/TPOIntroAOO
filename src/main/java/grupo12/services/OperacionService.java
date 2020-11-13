package grupo12.services;

import grupo12.entity.Tipo1;
import grupo12.entity.Tipo2;
import grupo12.entity.Tipo3;

public interface OperacionService {
	
	Tipo1 getByIdT1(Integer id);

	Tipo2 getByIdT2(Integer id);

	Tipo3 getByIdT3(Integer id);

	void deleteT1ById(Integer id);

	void deleteT2ById(Integer id);

	void deleteT3ById(Integer id);

    void savet1(Tipo1 op1);

	void savet2(Tipo2 op2);

	void savet3(Tipo3 op3);

	Float getMontoT1ById(Integer id);

	Float getMontoT2ById(Integer id);

	Float getMontoT3ById(Integer id);
}
