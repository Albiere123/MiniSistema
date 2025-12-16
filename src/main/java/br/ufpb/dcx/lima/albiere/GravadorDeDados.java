package br.ufpb.dcx.lima.albiere;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVO_CONTATOS = "contatos.dat";

    public HashMap<String, Contato> recuperarContatos() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS))) {
            return (HashMap<String, Contato>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Erro: Classe não encontrada ao ler o arquivo", e);
        } catch (FileNotFoundException e) {
            // Se o arquivo não existir, retorna um mapa novo vazio
            return new HashMap<>();
        }
    }

    public void salvarContatos(Map<String, Contato> contatos) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS))) {
            out.writeObject(contatos);
        }
    }
}
