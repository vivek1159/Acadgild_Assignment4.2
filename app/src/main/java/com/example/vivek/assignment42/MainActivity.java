package com.example.vivek.assignment42;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String [] contactName = {"ABCD", "Vivek", "Harish","Paati", "Mummy", "Papa"};
    String [] number = {"8971533344", "8197616611", "8956674663", "9388446378", "6466466464",
            "1234567890"};
    Integer [] img1 = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic1,
            R.drawable.pic2, R.drawable.pic3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        CAdapter customAdapter = new CAdapter(this, contactName, number, img1);

        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringBuilder text3 = new StringBuilder().append(contactName[position]).append("  ").append(number[position]);
                Toast.makeText(MainActivity.this, text3, Toast.LENGTH_LONG).show();
            }
        });

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
