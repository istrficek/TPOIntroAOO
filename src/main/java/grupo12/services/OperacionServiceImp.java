package grupo12.services;

import grupo12.entity.Tipo1;
import grupo12.entity.Tipo2;
import grupo12.entity.Tipo3;
import grupo12.repository.Tipo1Repository;
import grupo12.repository.Tipo2Repository;
import grupo12.repository.Tipo3Repository;

public class OperacionServiceImp implements OperacionService {

	Tipo1Repository repot1;
	Tipo2Repository repot2;
	Tipo3Repository repot3;

	public Tipo1 getByIdT1(Integer id) {
		
		//
		
		return null;
	}

	public Tipo2 getByIdT2(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tipo3 getByIdT3(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteT1ById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteT2ById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteT3ById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savet1(Tipo1 op1) {
		repot1.save(op1);
	}

	@Override
	public void savet2(Tipo2 op2) {
		repot2.save(op2);

	}

	@Override
	public void savet3(Tipo3 op3) {
		repot3.save(op3);

	}

	@Override
	public Float getMontoT1ById(Integer id) {
		return repot1.getByMontoT1(id);
	}

	@Override
	public Float getMontoT2ById(Integer id) {
		return repot2.getByMontoT2(id);
	}

	@Override
	public Float getMontoT3ById(Integer id) {
		return repot3.getByMontoT3(id);
	}

}
