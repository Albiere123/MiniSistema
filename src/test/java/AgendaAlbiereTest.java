import static org.junit.jupiter.api.Assertions.*;

import br.ufpb.dcx.lima.albiere.AgendaAlbiere;
import br.ufpb.dcx.lima.albiere.Contato;
import br.ufpb.dcx.lima.albiere.ContatoInexistenteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collection;

public class AgendaAlbiereTest {

    AgendaAlbiere agenda;

    @BeforeEach
    public void setUp() {
        agenda = new AgendaAlbiere();
    }

    @Test
    public void testCicloDeVidaContato() {
        boolean cadastrou = agenda.cadastraContato("Albiere", 5, 8);
        assertTrue(cadastrou);

        Collection<Contato> achados = agenda.pesquisaAniversariantes(5, 8);
        assertEquals(1, achados.size());
        assertTrue(achados.iterator().next().getNome().equals("Albiere"));

        try {
            boolean removeu = agenda.removeContato("Albiere");
            assertTrue(removeu);

            achados = agenda.pesquisaAniversariantes(5, 8);
            assertTrue(achados.isEmpty());

        } catch (ContatoInexistenteException e) {
            fail("Não deveria lançar exceção ao remover contato existente");
        }
    }
}