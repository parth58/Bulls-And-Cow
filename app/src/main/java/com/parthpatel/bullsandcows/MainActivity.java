package com.parthpatel.bullsandcows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView bullsT,cowsT,output,attempts,ans,ansout;
    EditText number;
    Button start,check;
    String secret;
    int bulls,cows;
    int attempt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bullsT=(TextView)findViewById(R.id.bulls);
        cowsT=(TextView)findViewById(R.id.cows);
        output=(TextView)findViewById(R.id.output);
        number=(EditText)findViewById(R.id.editText);
        start=(Button)findViewById(R.id.button);
        check=(Button)findViewById(R.id.check);
        attempts=(TextView)findViewById(R.id.tryTime);
        ans=(TextView)findViewById(R.id.ans);
        ansout=(TextView)findViewById(R.id.ansout);
        bullsT.setText("");
        cowsT.setText("");
        cows=0;
        bulls=0;
        attempt=0;
        bullsT.setText(String.valueOf(bulls));
        cowsT.setText(String.valueOf(cows));
        attempts.setText("No.of attempts:-"+attempt);
        Random rand = new Random();

        int x;
        do {
            x = rand.nextInt(9000)+1000;
        } while (containsRepeatingDigits(x));

        DecimalFormat df = new DecimalFormat("####");
        secret= df.format(x);
        System.out.println("button outside secret="+secret);
        start.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                return false;
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ansout.setText("Guess The 4 Digit Number");
                output.setText("");
                number.setText("");
                cows=0;
                bulls=0;
                attempt=0;
                attempts.setText("No.of attempts:-"+attempt);
                bullsT.setText(String.valueOf(bulls));
                cowsT.setText(String.valueOf(cows));
                System.out.println("button inside");
                Random rand = new Random();

                int x;       // = rand.nextInt(10000);
                do {
                    x = rand.nextInt(9000)+1000;
                } while (containsRepeatingDigits(x));

                DecimalFormat df = new DecimalFormat("####");
                secret= df.format(x);

                System.out.println("button listener secret"+secret);
            }


        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number.getText().toString() != null) {
                    attempt++;
                    setUI();
                    if (bulls == 4) {
                        System.out.println("inside setUI() bulls=" + bulls + "cows=" + cows);
                        output.setText("You Win!!!");
                        bullsT.setText("");
                        cowsT.setText("");
                    } else {
                        System.out.println("inside setUI() bulls=" + bulls + "cows=" + cows);
                        bullsT.setText(String.valueOf(bulls));
                        cowsT.setText(String.valueOf(cows));

                    }
                    attempts.setText("No.of attempts:-" + attempt);
                    number.setText("");
                }else{
                    output.setText("");
                    number.setText("");
                    bullsT.setText("");
                    cowsT.setText("");
                }

            }
        });
        ans.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                ansout.setText(secret);
            }
        });



    }
    static boolean containsRepeatingDigits(int n) {
        final boolean digits[] = new boolean[10];
        for (char c : String.valueOf(n).toCharArray()) {
            final int i = c - '0';
            if (digits[i]) {
                return true;
            }
            digits[i] = true;
        }
        return false;
    }
    void setUI(){
        cows=0;
        bulls=0;
        System.out.println("inside setUI()");
        String t=number.getText().toString();
        int x=Integer.parseInt(t);
        System.out.println("inside setUI() x="+x+"t="+t);
        DecimalFormat df = new DecimalFormat("####");
        String inputString = df.format(x);
        System.out.println("inside setUI() input="+inputString+"secret="+secret);
        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0; j < inputString.length(); j++) {
                if (secret.charAt(i) == inputString.charAt(j)) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }

            }
        }


    }

}
