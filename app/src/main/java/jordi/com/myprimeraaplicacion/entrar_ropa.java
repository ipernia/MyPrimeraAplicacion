package jordi.com.myprimeraaplicacion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import jordi.com.myprimeraaplicacion.datamodel.Ropa;
import jordi.com.myprimeraaplicacion.datamodel.Talla;
import jordi.com.myprimeraaplicacion.datamodel.RoperoControlador;

public class entrar_ropa extends AppCompatActivity {

    EditText editNombre;
    EditText editMarca;
    Spinner spinnerTallas;
    EditText editPrecio;
    EditText editModelo;
    CheckBox checkboxMeGusta;

    RoperoControlador rc = new RoperoControlador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar_ropa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editNombre = (EditText) findViewById(R.id.edit_nombre);

        editMarca = (EditText) findViewById(R.id.edit_marca);
        spinnerTallas = (Spinner) findViewById(R.id.spinner_tallas);

        spinnerTallas.setAdapter(new ArrayAdapter<Talla>(this, android.R.layout.simple_spinner_item, Talla.values()));
        spinnerTallas.setSelection(2);

        editPrecio = (EditText) findViewById(R.id.edit_precio);
        editModelo = (EditText) findViewById(R.id.edit_modelo);
        checkboxMeGusta = (CheckBox) findViewById(R.id.checkBox_megusta);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editNombre.getText().toString();
                if (nombre.matches("")) {
                    Toast.makeText(getApplicationContext(), "Tienes que introducir nombre!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String marca = editMarca.getText().toString();
                if (marca.matches("")) {
                    Toast.makeText(getApplicationContext(), "Tienes que introducir la marca!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Talla talla = Talla.valueOf(spinnerTallas.getSelectedItem().toString());

                if (editPrecio.getText().toString().matches("")){
                    editPrecio.setText("0.0");
                }
                Float precio = Float.valueOf(editPrecio.getText().toString());

                String modelo = editModelo.getText().toString();
                if (modelo.matches("")) {
                    Toast.makeText(getApplicationContext(), "Tienes que introducir el modelo!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Boolean meGusta = checkboxMeGusta.isChecked();

                Ropa r = new Ropa(nombre, R.drawable.ropa3, talla, marca, precio, meGusta);

                editNombre.setText("");
                editMarca.setText("");
                editModelo.setText("");
                editPrecio.setText("0");
                checkboxMeGusta.setChecked(false);
                spinnerTallas.setSelection(2);

                rc.anadirRopa(r);
                rc.litarRopa();
                rc.listarPorMarca("ar");

                Toast.makeText(getApplicationContext(), "Elemento guardado", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
