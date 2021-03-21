package com.example.calculates;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DiscountActivity extends AppCompatActivity {

    private TextView original_price_tv, discount_percent_tv, final_price_tv, discount_saved;
    private Button disco_seven, disco_eight, disco_nine, disco_four, disco_five, disco_six, disco_three, disco_two, disco_one, disco_zero, disco_dot;
    private Button disco_ac, disco_back_space, disco_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);
        findViewByIds();
        keypad();
        disco_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResult();
            }
        });
    }

    public void findViewByIds() {
        original_price_tv = findViewById(R.id.original_price__tv);
        discount_percent_tv = findViewById(R.id.discount_percent_tv);
        final_price_tv = findViewById(R.id.final_price__tv);
        discount_saved = findViewById(R.id.discount_saved);

        disco_seven = findViewById(R.id.disco_seven);
        disco_eight = findViewById(R.id.disco_eight);
        disco_nine = findViewById(R.id.disco_nine);
        disco_four = findViewById(R.id.disco_four);
        disco_five = findViewById(R.id.disco_five);
        disco_six = findViewById(R.id.disco_six);
        disco_three = findViewById(R.id.disco_three);
        disco_two = findViewById(R.id.disco_two);
        disco_one = findViewById(R.id.disco_one);
        disco_zero = findViewById(R.id.disco_zero);
        disco_dot = findViewById(R.id.disco_dot);

        disco_ac = findViewById(R.id.disco_ac);
        disco_back_space = findViewById(R.id.disco_back_space);
        disco_go = findViewById(R.id.disco_go);

    }

    public void keypad() {

        original_price_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disco_seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "7");
                    }
                });

                disco_eight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "8");
                    }
                });

                disco_nine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "9");
                    }
                });

                disco_four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "4");
                    }
                });

                disco_five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "5");
                    }
                });

                disco_six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "6");
                    }
                });

                disco_three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "3");
                    }
                });

                disco_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "2");
                    }
                });

                disco_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "1");
                    }
                });

                disco_dot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + ".");
                    }
                });

                disco_zero.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        original_price_tv.setText(original_price_tv.getText() + "0");
                    }
                });

                disco_ac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!original_price_tv.getText().equals("")) {
                            original_price_tv.setText("");
                        }
                    }
                });

                disco_back_space.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!original_price_tv.getText().toString().equals("")) {
                            String discountOriginalValue = original_price_tv.getText().toString();
                            if (discountOriginalValue.length() > 0) {
                                discountOriginalValue = discountOriginalValue.substring(0, discountOriginalValue.length() - 1);
                                original_price_tv.setText(discountOriginalValue);
                            }
                        }
                    }
                });

            }
        });

        discount_percent_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disco_seven.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "7");
                    }
                });

                disco_eight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "8");
                    }
                });

                disco_nine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "9");
                    }
                });

                disco_four.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "4");
                    }
                });

                disco_five.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "5");
                    }
                });

                disco_six.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "6");
                    }
                });

                disco_three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "3");
                    }
                });

                disco_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "2");
                    }
                });

                disco_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "1");
                    }
                });

                disco_dot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + ".");
                    }
                });

                disco_zero.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discount_percent_tv.setText(discount_percent_tv.getText() + "0");
                    }
                });

                disco_ac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!discount_percent_tv.getText().equals("")) {
                            discount_percent_tv.setText("");
                        }
                    }
                });

                disco_back_space.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!discount_percent_tv.getText().toString().equals("")) {
                            String discountPercentValue = discount_percent_tv.getText().toString();
                            if (discountPercentValue.length() > 0) {
                                discountPercentValue = discountPercentValue.substring(0, discountPercentValue.length() - 1);
                                discount_percent_tv.setText(discountPercentValue);
                            }
                        }
                    }
                });
            }
        });


    }

    public void showResult() {
        String fPrice = original_price_tv.getText().toString();
        String percentage = discount_percent_tv.getText().toString();

        if (!fPrice.equals("") && !percentage.equals("")) {
            float finalPriceResult = getFinalPrice(Float.parseFloat(fPrice), Float.parseFloat(percentage));
            float finalDiscountSavedResult = getDiscountSaved(Float.parseFloat(fPrice), Float.parseFloat(percentage));
            final_price_tv.setText(String.valueOf(finalPriceResult));
            discount_saved.setText("Saved " + String.valueOf(finalDiscountSavedResult) + " kr");
        } else {
            Toast.makeText(this, "Field is Empty", Toast.LENGTH_SHORT).show();
        }
    }

    public float getDiscountSaved(float percent, float fulPrice) {
        return (percent / 100) * fulPrice;
    }

    public float getFinalPrice(float fulPrice, float percent) {
        //Subtract input percentage by 100
        float p = 100 - percent;
        return p / 100 * fulPrice;
    }
}