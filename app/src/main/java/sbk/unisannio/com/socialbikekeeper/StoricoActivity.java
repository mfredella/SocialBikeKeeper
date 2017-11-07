package sbk.unisannio.com.socialbikekeeper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class StoricoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storico);

        fillStorico();
    }

    public void fillStorico(){

        TableLayout tl = (TableLayout) findViewById(R.id.main_table);
        TableRow tr_head = new TableRow(this);
        tr_head.setId(View.generateViewId());
        tr_head.setBackgroundColor(Color.GRAY);
        tr_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        TextView label_data = new TextView(this);
        label_data.setId(View.generateViewId());
        label_data.setText("Data");
        label_data.setTextColor(Color.WHITE);
        label_data.setPadding(5, 5, 5, 5);
        tr_head.addView(label_data);
        TextView label_calorie = new TextView(this);
        label_calorie.setId(View.generateViewId());
        label_calorie.setText("Calorie");
        label_calorie.setTextColor(Color.WHITE);
        label_calorie.setPadding(5, 5, 5, 5);
        tr_head.addView(label_calorie);// add the column to the table row here

        TextView label_km = new TextView(this);
        label_km.setId(View.generateViewId());// define id that must be unique
        label_km.setText("KM"); // set the text for the header
        label_km.setTextColor(Color.WHITE); // set the color
        label_km.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(label_km); // add the column to the table row here

        TextView label_tempo = new TextView(this);
        label_tempo.setId(View.generateViewId());// define id that must be unique
        label_tempo.setText("Tempo(min)"); // set the text for the header
        label_tempo.setTextColor(Color.WHITE); // set the color
        label_tempo.setPadding(5, 5, 5, 5); // set the padding (if required)
        tr_head.addView(label_tempo); // add the column to the table row here
        tl.addView(tr_head, new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        Invia getResults = new Invia("http://socialbikeeper.altervista.org/getresults.php?email="+TrainingActivity.getEmail());
        String results = getResults.doInBackground();

        String[] result = results.split("_");

        for(int i=0; i<result.length-1; i++) {

            TableRow tr = new TableRow(this);
            tr.setId(i);
            tr.setBackgroundColor(Color.GRAY);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            TextView labelDate = new TextView(this);
            labelDate.setText(result[i].split("\\*")[0]);
            labelDate.setPadding(2, 0, 5, 0);
            labelDate.setTextColor(Color.WHITE);
            tr.addView(labelDate);
            TextView labelCalorie = new TextView(this);
            labelCalorie.setText(result[i].split("\\*")[1]);
            labelCalorie.setPadding(2, 0, 5, 0);
            labelCalorie.setTextColor(Color.WHITE);
            tr.addView(labelCalorie);
            TextView labelKM = new TextView(this);
            labelKM.setText(result[i].split("\\*")[2]);
            labelKM.setPadding(2, 0, 5, 0);
            labelKM.setTextColor(Color.WHITE);
            tr.addView(labelKM);
            TextView labelTempo = new TextView(this);
            labelTempo.setText(result[i].split("\\*")[3]);
            labelTempo.setPadding(2, 0, 5, 0);
            labelTempo.setTextColor(Color.WHITE);
            tr.addView(labelTempo);

            tl.addView(tr, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }

    }
}
