package com.example.toolboxproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private boolean isCreative = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch toggleImage = (Switch) findViewById(R.id.switch1);
        final ImageView image = (ImageView) findViewById(R.id.imageView);

        toggleImage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    image.setVisibility(View.INVISIBLE);
                }
                else{
                    image.setVisibility(View.VISIBLE);
                }
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinnerImage);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerChoices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View v, int position, long id){
        ImageView image = (ImageView) findViewById(R.id.imageView) ;
        Resources res = getResources();
        String[] themeArray = res.getStringArray(R.array.spinnerChoices);
        if(themeArray[position].equals("Summer")){
            image.setImageResource(R.drawable.summer);
        }
        else if(themeArray[position].equals("Winter")){
            image.setImageResource(R.drawable.winter);
        }
        else if(themeArray[position].equals("Fall")){
            image.setImageResource(R.drawable.fall);
        }
        else if(themeArray[position].equals("Spring")){
            image.setImageResource(R.drawable.spring);
        }
        else{
            image.setImageResource(R.drawable.whole_brain);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0){
        setTheme(R.style.AppTheme);
    }

    public void onCheckboxChecked(View v){
        TextView textView = (TextView) findViewById(R.id.wowTextView);
        boolean isChecked = ((CheckBox) v).isChecked();

        if(isChecked){
            textView.setText(R.string.checkText);
        }
        else {
            textView.setText(R.string.wowText);
        }
    }

    public void onRadioButtonClicked(View v){
        TextView textView = (TextView) findViewById(R.id.wowTextView);
        boolean isChecked = ((RadioButton) v).isChecked();

        switch (v.getId()){
            case R.id.radioBlue:
                if(isChecked){
                    textView.setTextColor(getResources().getColor(R.color.colorBlue));
                }
                break;
            case R.id.radioRed:
                if(isChecked){
                    textView.setTextColor(getResources().getColor(R.color.colorRed));
                }
                break;
            case R.id.radioGreen:
                if(isChecked){
                    textView.setTextColor(getResources().getColor(R.color.colorGreen));
                }
                break;
            case R.id.radioBlack:
                if(isChecked){
                    textView.setTextColor((getResources().getColor(R.color.colorBlack)));
                }
                break;
        }
    }

    public void onClick(View v){
        ImageView image = (ImageView) findViewById(R.id.imageView);
        TextView surpriseText = (TextView) findViewById(R.id.creativeText);
        if(!isCreative) {
            Toast.makeText(this, "plz rate 5 stars on apple store", Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.doge);
            surpriseText.setVisibility(View.VISIBLE);
            isCreative = true;
        }
        else{
            image.setImageResource(R.drawable.whole_brain);
            surpriseText.setVisibility(View.INVISIBLE);
            isCreative = false;
        }
    }



}
