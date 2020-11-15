package grupo12.services;

import grupo12.entity.CertificadoDeGarantia;
import grupo12.repository.CertificadoDeGarantiaRepository;

public class CertificadoDeGarantiaServiceImp implements CertificadoDeGarantiaService{

    private CertificadoDeGarantiaRepository repo = new CertificadoDeGarantiaRepository();

    @Override
    public CertificadoDeGarantia getById(Integer id) {
        return repo.getById(id);
    }

    @Override
    public void save(CertificadoDeGarantia nuevo) {
        repo.save(nuevo);
    }

    @Override
    public void delete(Integer id) {
        repo.delete(id);
    }
}
