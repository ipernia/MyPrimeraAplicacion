package jordi.com.myprimeraaplicacion.datamodel;

import com.orm.SugarRecord;

/**
 * Created by Admin on 03/11/2016.
 */

public class Ropa extends SugarRecord {

    public int Imagen;

    public String Nombre;

    public Talla tallaRopa;

    public String Marca;

    public Float Precio;

    public boolean meGusta;

    public Ropa()
    {
        this.Imagen  = 0;
        this.Nombre = "";
        this.tallaRopa = Talla.M;
        this.Marca = "";
        this.Precio = (float)0;
        this.meGusta = false;
    }

    public Ropa(String nombre, int imagen, Talla talla, String marca, Float precio, boolean megusta)
    {
        this.Imagen  = imagen;
        this.Nombre = nombre;
        this.tallaRopa = talla;
        this.Marca = marca;
        this.Precio = precio;
        this.meGusta = megusta;
    }

}
