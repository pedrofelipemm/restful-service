package pmoreira.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import pmoreira.exception.CervejaJaExisteException;
import pmoreira.model.Cerveja.Tipo;

public class Estoque {

    private static final Random RANDOM = new Random();
    private Map<String, Cerveja> cervejas = new HashMap<>();

    public Estoque() {
        Cerveja primeiraCerveja = new Cerveja("Stella Artois", "A cerveja belga mais francesa do mundo :)", "Artois",
                Cerveja.Tipo.LAGER);
        Cerveja segundaCerveja = new Cerveja("Erdinger Weissbier", "Cerveja de trigo alemã", "Erdinger Weissbräu",
                Cerveja.Tipo.WEIZEN);

        cervejas.put(primeiraCerveja.getNome(), primeiraCerveja);
        cervejas.put(segundaCerveja.getNome(), segundaCerveja);

        addCervejas(cervejas, 3);
    }

    private void addCervejas(Map<String, Cerveja> cervejas, int amount) {
        Cerveja cerveja;
        for (int i = 1; i <= amount; i++) {
            cerveja = new Cerveja("Nome " + i, "Descrição " + i, "Cervejaria " + i, getRandomTipo());
            cervejas.put(cerveja.getNome(), cerveja);
        }
    }

    private Tipo getRandomTipo() {

        Tipo[] tipos = Cerveja.Tipo.values();
        List<Tipo> list = Arrays.asList(tipos);

        return list.get(RANDOM.nextInt(tipos.length));
    }

    public List<Cerveja> listarCervejas() {

        return new ArrayList<>(cervejas.values());
    }

    public List<Cerveja> listarCervejas(int numeroPagina, int tamanhoPagina) {

        int indiceInicial = (numeroPagina - 1) * tamanhoPagina;
        int indiceFinal = indiceInicial + tamanhoPagina;
        List<Cerveja> cervejas = listarCervejas();
        if (cervejas.size() > indiceInicial) {
            if (cervejas.size() > indiceFinal) {
                cervejas = cervejas.subList(indiceInicial, indiceFinal);
            } else {
                cervejas = cervejas.subList(indiceInicial, cervejas.size());
            }
        } else {
            cervejas = new ArrayList<>();
        }
        return cervejas;
    }

    public void adicionarCerveja(Cerveja cerveja) throws CervejaJaExisteException {
        if (cervejas.containsKey(cerveja.getNome())) {
            throw new CervejaJaExisteException();
        }
        cervejas.put(cerveja.getNome(), cerveja);
    }

    public Cerveja recuperarCervejaPeloNome(String nome) {
        return cervejas.get(nome);
    }

    public void atualizarCerveja(Cerveja cerveja) {
        // TODO Auto-generated method stub

    }

    public void apagarCerveja(String nome) {
        cervejas.remove(nome);
    }

}
