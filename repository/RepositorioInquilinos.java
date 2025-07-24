package repository;

import model.Inquilino;

public interface RepositorioInquilinos {
    Inquilino buscarPorLibreta(int numeroLibreta);
}
