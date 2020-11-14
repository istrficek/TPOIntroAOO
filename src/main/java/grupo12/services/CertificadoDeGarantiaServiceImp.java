package grupo12.services;

import grupo12.entity.CertificadoDeGarantia;
import grupo12.repository.CertificadoDeGarantiaRepository;

public class CertificadoDeGarantiaServiceImp implements CertificadoDeGarantiaService{

    private CertificadoDeGarantiaRepository repo = new CertificadoDeGarantiaRepository();

    @Override
    public CertificadoDeGarantia getById(Integer id) {
        return repo.getById(id);
    }
}
