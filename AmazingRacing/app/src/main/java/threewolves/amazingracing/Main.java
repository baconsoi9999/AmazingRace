package threewolves.amazingracing;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main extends AppCompatActivity {
    TextView point;
    Button start;
    CheckBox checkBoxOne;
    CheckBox checkBoxTwo;
    CheckBox checkBoxThree;
    SeekBar seekBarOne;
    SeekBar seekBarTwo;
    SeekBar seekBarThree;
    private int diem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        setCheckBox();
        seekBarOne.setEnabled(false);
        seekBarTwo.setEnabled(false);
        seekBarThree.setEnabled(false);

        setClickStart(action());
    }

    private void setClickStart(CountDownTimer countDownTimer) {
        final CountDownTimer ct = countDownTimer;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBoxOne.isChecked() == true || checkBoxTwo.isChecked() == true || checkBoxThree.isChecked() == true) {
                    seekBarOne.setProgress(0);
                    seekBarTwo.setProgress(0);
                    seekBarThree.setProgress(0);
                    start.setVisibility(View.INVISIBLE);
                    ct.start();
                    setUnEnableCheckBox();
                }
                else Toast.makeText(Main.this,"Please click one of CheckBox",Toast.LENGTH_LONG).show();
            }
        });
    }

    private CountDownTimer action() {

        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            Random rd = new Random();
            @Override
            public void onTick(long l) {
                if(seekBarOne.getProgress() >= seekBarOne.getMax()){
                    if(checkBoxOne.isChecked() == true) diem += 10;
                    else diem -= 10;
                    point.setText(Integer.toString(diem));

                    start.setVisibility(View.VISIBLE);
                    this.cancel();
                    setEnableCheckBox();
                    Toast.makeText(Main.this,"Number 1 Win!",Toast.LENGTH_LONG).show();
                }
                if(seekBarTwo.getProgress() >= seekBarTwo.getMax()){
                    if(checkBoxTwo.isChecked() == true) diem += 10;
                    else diem -= 10;
                    point.setText(Integer.toString(diem));

                    start.setVisibility(View.VISIBLE);
                    this.cancel();
                    setEnableCheckBox();
                    Toast.makeText(Main.this,"Number 2 Win!",Toast.LENGTH_LONG).show();
                }
                if(seekBarThree.getProgress() >= seekBarThree.getMax()){
                    if(checkBoxThree.isChecked() == true) diem += 10;
                    else diem -= 10;
                    point.setText(Integer.toString(diem));

                    start.setVisibility(View.VISIBLE);
                    this.cancel();
                    setEnableCheckBox();
                    Toast.makeText(Main.this,"Number 3 Win!",Toast.LENGTH_LONG).show();
                }
                seekBarOne.setProgress(seekBarOne.getProgress() + rd.nextInt(10));
                seekBarTwo.setProgress(seekBarTwo.getProgress() + rd.nextInt(10));
                seekBarThree.setProgress(seekBarThree.getProgress() + rd.nextInt(10));
            }

            @Override
            public void onFinish() {
                Toast.makeText(Main.this,"Hết thời gian !!!",Toast.LENGTH_SHORT).show();
            }
        };
        return countDownTimer;
    }
    private void setEnableCheckBox(){
        checkBoxOne.setEnabled(true);
        checkBoxTwo.setEnabled(true);
        checkBoxThree.setEnabled(true);
    }
    private void setUnEnableCheckBox(){
        checkBoxOne.setEnabled(false);
        checkBoxTwo.setEnabled(false);
        checkBoxThree.setEnabled(false);
    }
    private void setCheckBox() {


        checkBoxOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBoxTwo.setChecked(false);
                checkBoxThree.setChecked(false);
            }
        });
        checkBoxTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBoxOne.setChecked(false);
                checkBoxThree.setChecked(false);
            }
        });

        checkBoxThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkBoxTwo.setChecked(false);
                checkBoxOne.setChecked(false);
            }
        });
    }

    private void AnhXa() {
        point = (TextView) findViewById(R.id.point);
        start = (Button) findViewById(R.id.buttonStar);
        checkBoxOne =(CheckBox) findViewById(R.id.checkboxOne);
        checkBoxTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        checkBoxThree = (CheckBox) findViewById(R.id.checkboxThree);
        seekBarOne = (SeekBar) findViewById(R.id.seekbarOne);
        seekBarTwo = (SeekBar) findViewById(R.id.seekbarTwo);
        seekBarThree = (SeekBar) findViewById(R.id.seekbarThree);
    }

}
