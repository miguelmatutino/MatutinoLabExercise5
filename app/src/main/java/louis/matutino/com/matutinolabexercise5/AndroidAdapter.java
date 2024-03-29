package louis.matutino.com.matutinolabexercise5;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;

public class AndroidAdapter extends ArrayAdapter<AndroidVersion> {

    private Context context;
    private int resource;

    public AndroidAdapter(Context context, int resource, List<AndroidVersion> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }



    @NonNull
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        int logo = getItem(i).getLogo();
        String version = getItem(i).getName();
        String rCountry = getItem(i).getVarCountry();
        String rIndustry = getItem(i).getVarIndustry();
        String rCEO = getItem(i).getVarCEO();


        //Implement a LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(context);
        //Layout consumed by convertView
        convertView = inflater.inflate(resource, parent, false);


        ImageView img = convertView.findViewById(R.id.image1);
        TextView verName = convertView.findViewById(R.id.text3);
        TextView veCountry = convertView.findViewById(R.id.text1);
        TextView verIndustry = convertView.findViewById(R.id.text2);
        TextView verCEO = convertView.findViewById(R.id.text4);

        img.setImageResource(logo);
        verName.setText(version);
        veCountry.setText(rCountry);
        verIndustry.setText(rIndustry);
        verCEO.setText(rCEO);


        return convertView;
    }
}