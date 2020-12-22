package ua.kpi.comsys.iv7312;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList();
    ListView countriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        countriesList = (ListView) findViewById(R.id.moviesList);
        // создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);
        // устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " +
                                selectedState.getTitle(), Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
        toActivityItem2();
    }

    private void toActivityItem2(){
        Button nextActivity = (Button) findViewById(R.id.buttonToNext);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    private void setInitialData(){

        states.add(new State ("Star Wars: Episode IV - A New Hope Star Wars: Episode IV - A" +
                " New Hope ", "1977", "movie", R.drawable.poster01));
        states.add(new State ("Star Wars: Episode V - The Empire Strikes Back",
                "1980", "movie", R.drawable.poster02));
        states.add(new State ("Star Wars: Episode VI - Return of the Jedi",
                "1983", "movie", R.drawable.poster03));
        states.add(new State ("Star Wars: Episode VII - The Force Awakens",
                "", "movie", R.drawable.poster_null));
        states.add(new State ("Star Wars: Episode I - The Phantom Menace",
                "1999", "movie", R.drawable.poster05));
        states.add(new State ("Star Wars: Episode III - Revenge of the Sith",
                "2005", "movie", R.drawable.poster06));
        states.add(new State ("Star Wars: Episode II - Attack of the Clones",
                "2002", "movie", R.drawable.poster07));
        states.add(new State ("Star Trek", "2009", "movie", R.drawable.poster08));
        states.add(new State ("Star Wars: Episode VIII - The Last Jedi", "2017",
                "", R.drawable.poster_null));
        states.add(new State ("Rogue One: A Star Wars Story", "2016",
                "movie", R.drawable.poster10));
    }

}