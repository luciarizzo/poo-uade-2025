package repository;

import java.util.List;
import model.Apartamento;

public interface RepositorioApartamentos {
    List<Apartamento> obtenerTodos();
    Apartamento buscarPorNumero(int numeroApartamento);
    List<Apartamento> obtenerApartamentosDisponibles();

}
