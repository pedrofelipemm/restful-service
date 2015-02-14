package pmoreira.model.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pmoreira.model.Cerveja;

@XmlRootElement
public class Cervejas {

    private List<Cerveja> cervejas = new ArrayList<>();

    public Cervejas() {
    }

    public Cervejas(List<Cerveja> cervejas) {
        this.cervejas = cervejas;
        sortCervejas();
    }

    private void sortCervejas() {
        Collections.sort(cervejas, new Comparator<Cerveja>() {
            @Override
            public int compare(Cerveja c1, Cerveja c2) {
                return c1.getNome().compareTo(c2.getNome());
            }
        });
    }

    @XmlElement(name = "cerveja")
    public List<Cerveja> getCervejas() {
        return cervejas;
    }

    public void setCervejas(List<Cerveja> cervejas) {
        this.cervejas = cervejas;
    }
}