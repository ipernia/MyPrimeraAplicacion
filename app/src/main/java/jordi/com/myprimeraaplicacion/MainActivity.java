package jordi.com.myprimeraaplicacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import jordi.com.myprimeraaplicacion.datamodel.Ropa;
import jordi.com.myprimeraaplicacion.datamodel.RoperoControlador;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    RoperoControlador rc;

//    ArrayList<Ropa> miArmario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //todo añadir ropa
//        miArmario.add(new Ropa("Calconcillo Elefante", R.drawable.ropa3));
//        miArmario.add(new Ropa("Ropa Nadal",  R.drawable.ropa1));
//        miArmario.add(new Ropa("Ropa Federer",  R.drawable.ropa2));


        FloatingActionButton fab_entrar_ropa = (FloatingActionButton) findViewById(R.id.fab_entrar_ropa);
        fab_entrar_ropa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), entrar_ropa.class);
                startActivity(intent);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        rc = new RoperoControlador();
        mRecyclerView.setAdapter(new AdaptorRopa(rc.litarRopa()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        else if (id == R.id.action_nuevaRopa) {
            Intent i = new Intent(this, entrar_ropa.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
