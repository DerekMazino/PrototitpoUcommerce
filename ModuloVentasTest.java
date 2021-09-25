

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ModuloVentasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ModuloVentasTest
{
    /**
     * Default constructor for test class ModuloVentasTest
     */
    public ModuloVentasTest()
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
    public void agrega_Seccmisclasificados()
    {
        Usuario usuario1 = new Usuario();
        Sesion sesion1 = new Sesion();
        DataSource dataSour1 = new DataSource();
        ModuloUsuario moduloUs1 = new ModuloUsuario(dataSour1, sesion1, usuario1);
        moduloUs1.IniciarSesion();
        assertEquals(true, moduloUs1.PasarModoVendedor());
        ModuloVentas moduloVe1 = new ModuloVentas(dataSour1, usuario1);
        Categoria categori1 = new Categoria("", "");
        Clasificado clasific1 = new Clasificado("Vendo Perro", "Vendo perro bien bonito", categori1, 300000, true);
        assertEquals(false, moduloVe1.agregarClasificado(clasific1));
    }
}

