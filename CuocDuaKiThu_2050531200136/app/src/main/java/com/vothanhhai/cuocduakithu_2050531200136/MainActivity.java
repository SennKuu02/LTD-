package com.vothanhhai.cuocduakithu_2050531200136;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    ImageButton ibtPlay;
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);


        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number   = 10;
                Random random = new Random();
                int one     = random.nextInt(number);
                int two     = random.nextInt(number);
                int three   = random.nextInt(number);

                // kiểm tra WIN 1
                if(sb1.getProgress() >= sb1.getMax()){
                    this.cancel();
                    ibtPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "THREE WIN", Toast.LENGTH_SHORT).show();
                    // Kiểm tra đặt cược
                    if(cb1.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán hên đấy!", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán tệ thật!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                // kiểm tra WIN 2
                if(sb2.getProgress() >= sb2.getMax()){
                    this.cancel();
                    ibtPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "TWO WIN", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán cũng ghê đấy!", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán tệ thế!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                // kiểm tra WIN 3
                if(sb3.getProgress() >= sb3.getMax()){
                    this.cancel();
                    ibtPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "ONE WIN", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán hay đấy!", Toast.LENGTH_SHORT).show();
                    }else {
                        soDiem -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }

                sb1.setProgress(sb1.getProgress() +one);
                sb2.setProgress(sb2.getProgress() +two);
                sb3.setProgress(sb3.getProgress() +three);
            }

            @Override
            public void onFinish() {

            }
        };

        ibtPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked() || cb2.isChecked() || cb3.isChecked() ) {

                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);

                    ibtPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    DisableCheckBox();
                }else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bỏ check 2,3
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bỏ check 1,3
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // bỏ check 1,2
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }
            }
        });

    }

    private void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    private void DisableCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }

    private void AnhXa(){
        txtDiem     = (TextView)  findViewById(R.id.txtDiem);
        ibtPlay     = (ImageButton) findViewById(R.id.ibtPlay);
        cb1         = (CheckBox) findViewById(R.id.cb1);
        cb2         = (CheckBox) findViewById(R.id.cb2);
        cb3         = (CheckBox) findViewById(R.id.cb3);
        sb1         = (SeekBar) findViewById(R.id.sb1);
        sb2         = (SeekBar) findViewById(R.id.sb2);
        sb3         = (SeekBar) findViewById(R.id.sb3);
    }

}