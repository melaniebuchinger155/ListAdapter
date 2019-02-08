package buchinger.melanie.listadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById( R.id.listView );

       // Erstelle die Personen

        Person John = new Person ( "John", "12-20-1991",  "Female","drawable://" + R.drawable.kaktus3);
        Person Melanie = new Person ("Melanie", "12-20-1991", "Male","drawable://" + R.drawable.kaktus1);
        Person Annika = new Person ("Annika", "12-20-1994", "Male","drawable://" + R.drawable.orchidee);
        Person Christoph = new Person ("Christoph", "12-20-1998", "Female","drawable://" + R.drawable.basilikumpic);
        Person Herbert = new Person ("Herbert", "12-20-1458", "Male","drawable://" + R.drawable.primelpic);
        Person Martina = new Person ("Martina", "12-20-1988", "Female","drawable://" + R.drawable.kaktus3);
        Person Richard = new Person ("Richard", "12-20-1458", "Male","drawable://" + R.drawable.gummibaum);
        Person Lukas = new Person ("Lukas", "12-20-1958", "Male","drawable://" + R.drawable.bonsaibaum);
        Person Julia = new Person ("Julia", "12-20-1963", "Female","drawable://" + R.drawable.pflanze);
        Person Peter = new Person ("Peter", "12-20-1954", "Male","drawable://" + R.drawable.palme);
        Person Isabel = new Person ("Martina", "12-20-1988", "Female","drawable://" + R.drawable.kaktus3);
        Person Nathalie = new Person ("Richard", "12-20-1458", "Male","drawable://" + R.drawable.gummibaum);
        Person Hans = new Person ("Lukas", "12-20-1958", "Male","drawable://" + R.drawable.bonsaibaum);
        Person Emma = new Person ("Julia", "12-20-1963", "Female","drawable://" + R.drawable.pflanze);
        Person Toni = new Person ("Peter", "12-20-1954", "Male","drawable://" + R.drawable.palme);


        //Hinzufügen der Personen in eine ArrayList
        ArrayList<Person> peopleList = new ArrayList<>();


        peopleList.add(John);
        peopleList.add(Melanie);
        peopleList.add(Annika);
        peopleList.add(Christoph);
        peopleList.add(Herbert);
        peopleList.add(Martina);
        peopleList.add(Richard);
        peopleList.add(Lukas);
        peopleList.add(Julia);
        peopleList.add(Peter);
        peopleList.add(Isabel);
        peopleList.add(Nathalie);
        peopleList.add(Hans);
        peopleList.add(Emma);
        peopleList.add(Toni);
        peopleList.add(John);
        peopleList.add(Melanie);
        peopleList.add(Annika);
        peopleList.add(Christoph);
        peopleList.add(Herbert);
        peopleList.add(Martina);
        peopleList.add(Richard);
        peopleList.add(Lukas);
        peopleList.add(Julia);
        peopleList.add(Peter);
        peopleList.add(Isabel);
        peopleList.add(Nathalie);
        peopleList.add(Hans);
        peopleList.add(Emma);
        peopleList.add(Toni);
        peopleList.add(John);
        peopleList.add(Melanie);
        peopleList.add(Annika);
        peopleList.add(Christoph);
        peopleList.add(Herbert);
        peopleList.add(Martina);
        peopleList.add(Richard);
        peopleList.add(Lukas);
        peopleList.add(Julia);
        peopleList.add(Peter);
        peopleList.add(Isabel);
        peopleList.add(Nathalie);
        peopleList.add(Hans);
        peopleList.add(Emma);
        peopleList.add(Toni);


        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList  );
        mListView.setAdapter( adapter );





    }
}
