package br.com.cwi.reset.arielgustavo;

import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) {

    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) {

        return null;
    }

    public Ator consultarAtor(Integer id) {

        return null;
    }

    public List<Ator> consultarAtores() {

        return null;
    }
}
