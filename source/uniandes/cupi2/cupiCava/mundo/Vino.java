package uniandes.cupi2.cupiCava.mundo;

/**
 * Clase que representa un vino almacenado en la Cupi-Cava.<br>
 * <b>inv: </b> nombre != null && !nombre.equals("") &&
 * presentacion != null && !presentacion.equals("") &&
 * anhoElaboracion > 0 && contenidoAzucar >= 0 &&
 * tipo != null && !tipo.equals("") &&
 * color != null && !color.equals("") &&
 * lugarOrigen != null && !lugarOrigen.equals("") &&
 * imagen != null && !imagen.equals("")
 */
public class Vino
{
    public final static String BARRIL = "Barril";
    public final static String BOTELLA = "Botella";
    public final static String TINTO = "Tinto";
    public final static String ROSADO = "Rosado";
    public final static String BLANCO = "Blanco";
    public final static String SECO = "Seco";
    public static final String ABOCADO = "Abocado";
    public static final String SEMI_SECO = "Semi-seco";
    public static final String SEMI_DULCE = "Semi-dulce";
    public static final String DULCE = "Dulce";

    private String nombre;
    private String presentacion;
    private int anhoElaboracion;
    private double contenidoAzucar;
    private String tipo;
    private String color;
    private String lugarOrigen;
    private String imagen;

    public Vino(String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen)
    {
        nombre = pNombre;
        presentacion = pPresentacion;
        anhoElaboracion = pAnhoElaboracion;
        contenidoAzucar = pContenidoAzucar;
        tipo = pTipo;
        color = pColor;
        lugarOrigen = pLugarOrigen;
        imagen = pImagen;

        verificarInvariante();
    }

    public String darNombre() { return nombre; }
    public String darPresentacion() { return presentacion; }
    public int darAnhoElaboracion() { return anhoElaboracion; }
    public double darContenidoAzucar() { return contenidoAzucar; }
    public String darTipo() { return tipo; }
    public String darColor() { return color; }
    public String darLugarOrigen() { return lugarOrigen; }
    public String darImagen() { return imagen; }

    public int compararPorNombre(Vino pVino) {
        return nombre.compareToIgnoreCase(pVino.darNombre());
    }

    public int compararPorPresentacion(Vino pVino) {
        return presentacion.compareToIgnoreCase(pVino.darPresentacion());
    }

    public int compararPorAnhoElaboracion(Vino pVino) {
        return Integer.compare(anhoElaboracion, pVino.darAnhoElaboracion());
    }

    public int compararPorContenidoAzucar(Vino pVino) {
        return Double.compare(contenidoAzucar, pVino.darContenidoAzucar());
    }

    public int compararPorTipo(Vino pVino) {
        return tipo.compareToIgnoreCase(pVino.darTipo());
    }

    public int compararPorColor(Vino pVino) {
        return color.compareToIgnoreCase(pVino.darColor());
    }

    public int compararPorLugarOrigen(Vino pVino) {
        return lugarOrigen.compareToIgnoreCase(pVino.darLugarOrigen());
    }

    public String toString() {
        return nombre;
    }

    private void verificarInvariante() {
        assert nombre != null && !nombre.equals("");
        assert presentacion != null && !presentacion.equals("");
        assert anhoElaboracion > 0;
        assert contenidoAzucar >= 0;
        assert tipo != null && !tipo.equals("");
        assert color != null && !color.equals("");
        assert lugarOrigen != null && !lugarOrigen.equals("");
        assert imagen != null && !imagen.equals("");
    }
}
