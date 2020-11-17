package grupo12.services;


import grupo12.entity.CertificadoDeGarantia;

import java.util.List;

public interface CertificadoDeGarantiaService {

	CertificadoDeGarantia getById(Integer id);


    void save(CertificadoDeGarantia nuevo);

    void delete(Integer id);
}
