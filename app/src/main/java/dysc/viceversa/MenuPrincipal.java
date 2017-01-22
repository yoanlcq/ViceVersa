package dysc.viceversa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MenuPrincipal extends Activity
        implements SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener
{

    private SeekBar dimensions_slider, nbcoups_slider, nbgrilles_slider;
    private TextView dimensions_indicateur, nbcoups_indicateur, nbgrilles_indicateur;
    private Spinner chrono_liste;
    private ArrayAdapter<CharSequence> chrono_liste_adaptateur;
    private int dimensions, nbcoups, nbgrilles, chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_principal);

        dimensions_slider = (SeekBar) findViewById(R.id.dysc_menu_dimensions_slider);
        nbcoups_slider = (SeekBar) findViewById(R.id.dysc_menu_nbcoups_slider);
        nbgrilles_slider = (SeekBar) findViewById(R.id.dysc_menu_nbgrilles_slider);
        dimensions_indicateur = (TextView) findViewById(R.id.dysc_menu_dimensions_indicateur);
        nbcoups_indicateur = (TextView) findViewById(R.id.dysc_menu_nbcoups_indicateur);
        nbgrilles_indicateur = (TextView) findViewById(R.id.dysc_menu_nbgrilles_indicateur);
        chrono_liste = (Spinner) findViewById(R.id.dysc_menu_chrono_liste);

        dimensions_slider.setOnSeekBarChangeListener(this);
        nbcoups_slider.setOnSeekBarChangeListener(this);
        nbgrilles_slider.setOnSeekBarChangeListener(this);

        chrono_liste_adaptateur = ArrayAdapter.createFromResource(this,
                R.array.dysc_menu_chrono_choix, android.R.layout.simple_spinner_item);
        chrono_liste_adaptateur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chrono_liste.setAdapter(chrono_liste_adaptateur);
        chrono_liste.setOnItemSelectedListener(this);

        dimensions_slider.setProgress(4);
        nbcoups_slider.setProgress(1);
        nbgrilles_slider.setProgress(10);
    }

    /* Appelé par le bouton. Voir XML. */
    public void jouer(View view) {
        Toast.makeText(getApplicationContext(), dimensions+" "+nbcoups+" "+nbgrilles, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        dimensions = 1+dimensions_slider.getProgress();
        nbcoups    = 1+nbcoups_slider.getProgress();
        nbgrilles  = 1+nbgrilles_slider.getProgress();
        dimensions_indicateur.setText(""+dimensions);
        nbcoups_indicateur.setText(""+nbcoups);
        nbgrilles_indicateur.setText(""+nbgrilles);
    }
    @Override public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override public void onStopTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Choix changé !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
