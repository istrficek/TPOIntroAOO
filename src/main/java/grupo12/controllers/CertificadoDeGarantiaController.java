package grupo12.controllers;

import grupo12.entity.CertificadoDeGarantia;
import grupo12.request.CertificadoDeGarantiaRequest;
import grupo12.services.CertificadoDeGarantiaService;

public class CertificadoDeGarantiaController {

    private CertificadoDeGarantiaService service;

    public void crearCertificadoDeGarantia(CertificadoDeGarantiaRequest certificadoDeGarantia){
        CertificadoDeGarantia nuevo = new CertificadoDeGarantia();
        nuevo.setId(certificadoDeGarantia.getId());
        nuevo.setDescripcion(certificadoDeGarantia.getDescripcion());
        nuevo.setNumero(certificadoDeGarantia.getNumero());
        service.save(nuevo);
    }

    public CertificadoDeGarantia getById(Integer id){

        return service.getById(id);

    }



    public void editarCertificadoDeGarantia (Integer id, CertificadoDeGarantiaRequest certificadoDeGarantia){
        CertificadoDeGarantia nuevo = service.getById(id);

        nuevo.setNumero(certificadoDeGarantia.getNumero());
        nuevo.setDescripcion(certificadoDeGarantia.getDescripcion());
        service.save(nuevo);
    }

    public void delete(Integer id){
        service.delete(id);
    }
}
