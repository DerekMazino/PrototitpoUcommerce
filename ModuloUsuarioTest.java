

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ModuloUsuarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ModuloUsuarioTest
{
    /**
     * Default constructor for test class ModuloUsuarioTest
     */
    public ModuloUsuarioTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void noiniciarvendedor()
    {
        Usuario usuario1 = new Usuario();
        Sesion sesion1 = new Sesion();
        DataSource dataSour1 = new DataSource();
        ModuloUsuario moduloUs1 = new ModuloUsuario(dataSour1, sesion1, usuario1);
        assertEquals(false, moduloUs1.PasarModoVendedor());
    }

    @Test
    public void iniciarvendedor()
    {
        Usuario usuario1 = new Usuario();
        Sesion sesion1 = new Sesion();
        DataSource dataSour1 = new DataSource();
        ModuloUsuario moduloUs1 = new ModuloUsuario(dataSour1, sesion1, usuario1);
        moduloUs1.RegistroUsuario();
        moduloUs1.IniciarSesion();
        assertEquals(true, moduloUs1.PasarModoVendedor());
    }
}


