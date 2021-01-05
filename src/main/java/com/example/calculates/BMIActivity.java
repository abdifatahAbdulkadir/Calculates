package com.example.calculates;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculates.Dialogs.BMIResultDialog;

import java.util.Objects;

public class BMIActivity extends AppCompatActivity {
    private Spinner weight_sp;
    private Spinner height_sp;
    private TextView weight_tv;
    private TextView kg_lbs_tv;
    private TextView height_tv;
    private TextView cm_m_tv;
    private TextView result_tv, weight_type_tv;


    private Button seven, eight, nine, four, five, six, three, two, one, zero, dot;
    private Button ac, back_space,info_button;

    private String weighIsSelected;
    private String heightIsSelected;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        findViewByIds();

        ArrayAdapter<CharSequence> adapterWeight = ArrayAdapter.createFromResource(this, R.array.Weight, android.R.layout.simple_spinner_item);
        adapterWeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weight_sp.setAdapter(adapterWeight);

        ArrayAdapter<CharSequence> adapterHeight = ArrayAdapter.createFromResource(this, R.array.Height, android.R.layout.simple_spinner_item);
        adapterHeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        height_sp.setAdapter(adapterHeight);

        weight_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                weighIsSelected = parent.getItemAtPosition(position).toString();
                itemList(weighIsSelected);
                System.out.println(weighIsSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        height_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                heightIsSelected = parent.getItemAtPosition(position).toString();
                itemList(heightIsSelected);
                System.out.println(heightIsSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        keypad();
    }

    public String itemList(String text) {
        switch (text) {
            case "Kilograms":
                kg_lbs_tv.setText(text);
                break;
            case "Pounds":
                kg_lbs_tv.setText(text);
                break;
            case "Centimeters":
                cm_m_tv.setText(text);
                break;
            case "Meters":
                cm_m_tv.setText(text);
                break;
            case "Feet":
                cm_m_tv.setText(text);
                break;
            case "Inches":
                cm_m_tv.setText(text);
                break;
            default:
                System.out.println("Not available");
                break;
        }
        if (kg_lbs_tv.isSelected() || cm_m_tv.isSelected()) {
            return "selected";
        } else {
            return "Not Selected";
        }
    }

    public void findViewByIds() {
        weight_sp = findViewById(R.id.weight_sp);
        height_sp = findViewById(R.id.height_sp);
        weight_tv = findViewById(R.id.weight_tv);
        kg_lbs_tv = findViewById(R.id.kg_lbs_tv);
        height_tv = findViewById(R.id.height_tv);
        cm_m_tv = findViewById(R.id.cm_m_tv);
        result_tv = findViewById(R.id.result_tv);
        weight_type_tv = findViewById(R.id.weight_type_tv);

        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        three = findViewById(R.id.three);
        two = findViewById(R.id.two);
        one = findViewById(R.id.one);
        zero = findViewById(R.id.zero);
        dot = findViewById(R.id.dot);

        ac = findViewById(R.id.ac);
        back_space = findViewById(R.id.back_space);
        info_button = findViewById(R.id.info_button);

    }

    // Assign custom number to each button
    public void keypad() {

        weight_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "7");
                    }
                });

                eight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "8");
                    }
                });

                nine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "9");
                    }
                });

                four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "4");
                    }
                });

                five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "5");
                    }
                });

                six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "6");
                    }
                });

                three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "3");
                    }
                });

                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "2");
                    }
                });

                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "1");
                    }
                });

                dot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + ".");
                    }
                });

                zero.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText(weight_tv.getText() + "0");
                    }
                });

                ac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        weight_tv.setText("");
                    }
                });


            }
        });

        height_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "7");
                    }
                });

                eight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "8");
                    }
                });

                nine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "9");
                    }
                });

                four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "4");
                    }
                });

                five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "5");
                    }
                });

                six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "6");
                    }
                });

                three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "3");
                    }
                });

                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "2");
                    }
                });

                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "1");
                    }
                });

                dot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + ".");
                    }
                });

                zero.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText(height_tv.getText() + "0");
                    }
                });

                ac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        height_tv.setText("");
                    }
                });


            }
        });
    }

    //Onclick listener for input and display the output
    public void calc(View v) {
        String weightStr = weight_tv.getText().toString();
        String heightStr = height_tv.getText().toString();

        if (!weightStr.equals("") && !heightStr.equals("") && weighIsSelected.equals("Kilograms") && heightIsSelected.equals("Centimeters")) {
            float results = BMICalculation(Float.parseFloat(weightStr), Float.parseFloat(heightStr));
            result_tv.setText(String.format("%.1f", results));
            System.out.println(results);
        }else if (!weightStr.equals("") && !heightStr.equals("") && weighIsSelected.equals("Pounds") && heightIsSelected.equals("Feet")){
            float poundResult = feet(Float.parseFloat(weightStr),Float.parseFloat(heightStr));
            result_tv.setText(String.format("%.1f", poundResult));
            System.out.println(poundResult);
        }
    }


    //return kilograms and Centimeter result
    public float BMICalculation(float weight, float height) {
        float BMI = weight / (height * height);
        float result = BMI * 10000;
        returnResultOnTextView(result);
        return result;
    }

    public float feetToCentimeter(int centimeter) {
        float feetResult = (float) (0.0328 * centimeter);
        returnResultOnTextView(feetResult);
        return feetResult;
    }

    //return pound and feet result
    public float feet(float weightPound, float heightFeet ){
        float result = ((weightPound/heightFeet)/heightFeet) * 703;
        returnResultOnTextView(result);
        return result;
    }


    public float returnResultOnTextView(float result){
        if (result < 16) {
            weight_type_tv.setTextColor(Color.rgb(93, 173, 226));
            weight_type_tv.setText("Extreme Underweight");
        } else if (result > 16 && result < 18.5) {
            weight_type_tv.setTextColor(Color.rgb(46, 134, 193));
            weight_type_tv.setText("Underweight");
        } else if (result > 18.5 && result < 25) {
            weight_type_tv.setTextColor(Color.rgb(139, 195, 74));
            weight_type_tv.setText("Normal");
        } else if (result > 25) {
            weight_type_tv.setTextColor(Color.rgb(200, 67, 67));
            weight_type_tv.setText("Overweight");
        }
        return result;
    }

    //Delete the elements one by one on textView
    public void backSpace(View view) {

        if (!weight_tv.getText().equals("") ) {
            String weightStr = weight_tv.getText().toString();
            if (weightStr.length() > 0) {
                weightStr = weightStr.substring(0, weightStr.length() - 1);
                weight_tv.setText(weightStr);
            }
        }

        if (!height_tv.getText().equals("")) {
            String heightStr = height_tv.getText().toString();
            if ( heightStr.length() > 0) {
                heightStr = heightStr.substring(0, heightStr.length() - 1);
                height_tv.setText(heightStr);
            }
        }
    }


    //Provides an overview of the weight information on button clicked
    public void infoProvider(View view) {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.bmi_result_dialog);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}