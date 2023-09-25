package com.example.tiktokto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView[][] board=new ImageView[3][3];
    private boolean playerX=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board[0][0]=findViewById(R.id.one);
        board[0][1]=findViewById(R.id.two);
        board[0][2]=findViewById(R.id.three);
        board[1][0]=findViewById(R.id.four);
        board[1][1]=findViewById(R.id.five);
        board[1][2]=findViewById(R.id.six);
        board[2][0]=findViewById(R.id.seven);
        board[2][1]=findViewById(R.id.eight);
        board[2][2]=findViewById(R.id.nine);

        Button reset=findViewById(R.id.button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }

            private void resetGame() {
            }
        });
        public void onCellClick(View view){
            ImageView cell=(ImageView) view;

            if (cell.getDrawable()==null){
                if (playerX){cell.setImageResource(R.drawable.cross);}
                else {cell.setImageResource(R.drawable.zero);}

                playerX = !playerX;

            }
        }

    }
}