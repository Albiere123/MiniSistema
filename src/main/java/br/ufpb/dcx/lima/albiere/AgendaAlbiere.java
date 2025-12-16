package br.ufpb.dcx.lima.albiere;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaAlbiere implements Agenda{
    private Map<String, Contato> contatos;
    private GravadorDeDados gravador;

    public AgendaAlbiere() {
        this.contatos = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if (!contatos.containsKey(nome)) {
            this.contatos.put(nome, new Contato(nome, dia, mes));
            return true;
        }
        return false;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        Collection<Contato> aniversariantes = new ArrayList<>();
        for (Contato c : contatos.values()) {
            if (c.getDiaAniversario() == dia && c.getMesAniversario() == mes) {
                aniversariantes.add(c);
            }
        }
        return aniversariantes;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if (!contatos.containsKey(nome)) {
            throw new ContatoInexistenteException("Contato não existe: " + nome);
        }
        contatos.remove(nome);
        return true;
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.salvarContatos(this.contatos);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.contatos = gravador.recuperarContatos();
    }
}
