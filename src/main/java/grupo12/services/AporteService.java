package grupo12.services;

import grupo12.entity.Aporte;

import java.util.List;

public interface AporteService {
    boolean save(Aporte aporte);

    boolean update(Aporte a);

    List<Aporte> getAportes();

    boolean eliminarAporte(int id);
}
