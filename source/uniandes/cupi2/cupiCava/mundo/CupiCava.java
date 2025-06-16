package uniandes.cupi2.cupiCava.mundo;

import java.util.ArrayList;

/**
 * Clase que representa la Cupi-Cava. <br>
 * <b>inv: </b> vinos != null
 */
public class CupiCava
{
    private ArrayList<Vino> vinos;

    public CupiCava( )
    {
        vinos = new ArrayList<Vino>( );
        verificarInvariante();
    }

    public ArrayList<Vino> darVinos( )
    {
        return vinos;
    }

    public Vino buscarVino( String pNombre )
    {
        Vino buscado = null;
        boolean encontre = false;

        for( int i = 0; i < vinos.size( ) && !encontre; i++ )
        {
            Vino vinoActual = vinos.get( i );
            if( vinoActual.darNombre( ).equalsIgnoreCase( pNombre ) )
            {
                buscado = vinoActual;
                encontre = true;
            }
        }

        return buscado;
    }

    public Vino buscarBinarioPorNombre( String pNombre )
    {
        int izquierda = 0;
        int derecha = vinos.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            Vino actual = vinos.get(medio);
            int comparacion = actual.darNombre().compareToIgnoreCase(pNombre);

            if (comparacion == 0) {
                return actual;
            } else if (comparacion < 0) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return null;
    }

    public Vino buscarVinoMasDulce( )
    {
        if (vinos.isEmpty()) return null;

        Vino masDulce = vinos.get(0);

        for (Vino v : vinos) {
            if (v.darContenidoAzucar() > masDulce.darContenidoAzucar()) {
                masDulce = v;
            }
        }

        return masDulce;
    }

    public Vino buscarVinoMasSeco( )
    {
        if (vinos.isEmpty()) return null;

        Vino masSeco = vinos.get(0);

        for (Vino v : vinos) {
            if (v.darContenidoAzucar() < masSeco.darContenidoAzucar()) {
                masSeco = v;
            }
        }

        return masSeco;
    }

    public ArrayList<Vino> buscarVinosDeTipo( String pTipo )
    {
        ArrayList<Vino> resultado = new ArrayList<>();

        for (Vino v : vinos) {
            if (v.darTipo().equalsIgnoreCase(pTipo)) {
                resultado.add(v);
            }
        }

        return resultado;
    }

    public boolean agregarVino( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pColor, String pLugarOrigen, String pImagen )
    {
        Vino buscado = buscarVino( pNombre );
        boolean agregada = false;

        if( buscado == null )
        {
            Vino vino = new Vino( pNombre, pPresentacion, pAnhoElaboracion, pContenidoAzucar, pTipo, pColor, pLugarOrigen, pImagen );
            vinos.add( vino );
            agregada = true;
        }

        return agregada;
    }

    public void ordenarVinosPorNombre( )
    {
        for (int i = 0; i < vinos.size() - 1; i++) {
            for (int j = 0; j < vinos.size() - 1 - i; j++) {
                Vino actual = vinos.get(j);
                Vino siguiente = vinos.get(j + 1);
                if (actual.darNombre().compareToIgnoreCase(siguiente.darNombre()) > 0) {
                    vinos.set(j, siguiente);
                    vinos.set(j + 1, actual);
                }
            }
        }
    }

    public void ordenarVinosPorAnhoElaboracion( )
    {
        for (int i = 0; i < vinos.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < vinos.size(); j++) {
                if (vinos.get(j).darAnhoElaboracion() > vinos.get(maxIndex).darAnhoElaboracion()) {
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                Vino temp = vinos.get(i);
                vinos.set(i, vinos.get(maxIndex));
                vinos.set(maxIndex, temp);
            }
        }
    }

    public void ordenarVinosPorLugarOrigen( )
    {
        for (int i = 1; i < vinos.size(); i++) {
            Vino actual = vinos.get(i);
            int j = i - 1;

            while (j >= 0 && vinos.get(j).darLugarOrigen().compareToIgnoreCase(actual.darLugarOrigen()) > 0) {
                vinos.set(j + 1, vinos.get(j));
                j--;
            }
            vinos.set(j + 1, actual);
        }
    }

    private void verificarInvariante() {
        assert vinos != null;
    }

    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}
