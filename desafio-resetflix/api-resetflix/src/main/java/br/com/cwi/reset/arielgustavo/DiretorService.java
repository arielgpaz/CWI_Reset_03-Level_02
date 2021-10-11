package br.com.cwi.reset.arielgustavo;

import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void cadastrarDiretor(DiretorRequest diretorRequest) {

    }

    public List<Diretor> listarDiretores(String filtroNome) {

        return null;
    }

    public Diretor consultarDiretor(Integer id) {

        return null;
    }

    public List<Ator> consultarAtores() {

        return null;
    }
}
