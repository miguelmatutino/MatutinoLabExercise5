package louis.matutino.com.matutinolabexercise5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] verNames, country, industry, ceo, info;
    int[] logo = {R.drawable.icbc
            ,R.drawable.jpmorgan,R.drawable.chinaconstruction,
            R.drawable.agricultural,R.drawable.america,R.drawable.apple,R.drawable.pingan,R.drawable.bankofchina,
            R.drawable.royaldutch,R.drawable.wellsfargo,R.drawable.exxonmobil,R.drawable.att,R.drawable.samsung,R.drawable.citigroup};
    ArrayList<AndroidVersion> versions=new ArrayList<>();

    ListView lstVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verNames = getResources().getStringArray(R.array.VerName);
        country = getResources().getStringArray(R.array.varCountry);
        industry = getResources().getStringArray(R.array.varIndustry);
        ceo = getResources().getStringArray(R.array.varCEO);
        info = getResources().getStringArray(R.array.varInfo);

        for(int i = 0; i < verNames.length; i++){
            versions.add(new AndroidVersion(logo[i], verNames[i], country[i], industry[i], ceo[i]));

        }


        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.row, versions);
        lstVersions = findViewById(R.id.lvAndroid);
        lstVersions.setAdapter(adapter);
        lstVersions.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "bank.txt");
        File read = new File(folder, "show.txt");
        try {
            final FileOutputStream fos = new FileOutputStream(file);
            final FileOutputStream show = new FileOutputStream(read);
        //    FileOutputStream fos = new FileOutputStream(file);
            //        String choice = colleges.get(i).getName();
            //      fos.write(choice.getBytes());
            final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            String choice = versions.get(i).getName() + "\n"
                    + versions.get(i).getVarCountry() + "\n"
                    + versions.get(i).getVarIndustry() + "\n"
                    + versions.get(i).getVarCEO() + "\n";
            String sChoice = versions.get(i).getName() + "\n" + versions.get(i).getVarCountry() + "\n" + versions.get(i).getVarIndustry()
                    + "\n" + versions.get(i).getVarCEO();
            show.write(sChoice.getBytes());
            fos.write(choice.getBytes());
            dialog.setTitle(versions.get(i).getName());
            dialog.setIcon(versions.get(i).getLogo());

            dialog.setMessage(info[i]);


            dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    try {
                        FileInputStream fin;
                        fin = new FileInputStream(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/show.txt"));
                        int i;
                        String str = "";
                        while ((i = fin.read()) != -1) {
                            str += Character.toString((char) i);
                        }
                        fin.close();
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            dialog.create().show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "File not found.", Toast.LENGTH_LONG ).show();
        } catch (IOException e) {
            Toast.makeText(this, "Unable to write", Toast.LENGTH_SHORT).show();
        }

    }
}