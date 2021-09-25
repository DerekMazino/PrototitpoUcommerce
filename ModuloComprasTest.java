

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ModuloComprasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ModuloComprasTest
{
    /**
     * Default constructor for test class ModuloComprasTest
     */
    public ModuloComprasTest()
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
    public void novercarrito()
    {
        Usuario usuario1 = new Usuario();
        Sesion sesion1 = new Sesion();
        DataSource dataSour1 = new DataSource();
        ModuloCompras moduloCo1 = new ModuloCompras(dataSour1, usuario1, sesion1);
        assertEquals(false, moduloCo1.verCarrito());
    }
}

