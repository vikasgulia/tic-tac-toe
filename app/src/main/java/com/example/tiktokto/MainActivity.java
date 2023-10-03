package com.example.tiktokto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
        private ImageView[][] board = new ImageView[3][3];
        private boolean playerX = true;
        private boolean gameOver = false;
        private TextView statusText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            statusText = findViewById(R.id.textview);
            board[0][0] = findViewById(R.id.one);
            board[0][1] = findViewById(R.id.two);
            board[0][2] = findViewById(R.id.three);
            board[1][0] = findViewById(R.id.four);
            board[1][1] = findViewById(R.id.five);
            board[1][2] = findViewById(R.id.six);
            board[2][0] = findViewById(R.id.seven);
            board[2][1] = findViewById(R.id.eight);
            board[2][2] = findViewById(R.id.nine);

            Button reset = findViewById(R.id.button);
            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetGame();
                }
            });
        }

        private void resetGame() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j].setImageResource(0);
                }
            }
            playerX = true;
            gameOver = false;
            updateStatusText("Tic Tac Toe");
        }

        private void updateStatusText(String message) {
            statusText.setText(message);
        }

        public void onCellClick(View view) {
            ImageView cell = (ImageView) view;

            if (!gameOver && cell.getDrawable() == null) {
                if (playerX) {
                    cell.setImageResource(R.drawable.cross);
                } else {
                    cell.setImageResource(R.drawable.zero);
                }

                if (checkForWin()) {
                    gameOver = true;
                    updateStatusText("Player " + (playerX ? "X" : "O") + " wins!");
                } else if (checkForDraw()) {
                    gameOver = true;
                    updateStatusText("It's a draw!");
                } else {
                    playerX = !playerX;
                    updateStatusText("Player " + (playerX ? "X" : "O") + "'s turn");
                }
            }
        }

        private boolean checkForWin() {
            // Check  for a win
            for (int i = 0; i < 3; i++) {
                // Check rows
                if (board[i][0].getDrawable() != null &&
                        board[i][0].getDrawable().getConstantState() == board[i][1].getDrawable().getConstantState() &&
                        board[i][0].getDrawable().getConstantState() == board[i][2].getDrawable().getConstantState()) {
                    return true;
                }

                // columns
                if (board[0][i].getDrawable() != null &&
                        board[0][i].getDrawable().getConstantState() == board[1][i].getDrawable().getConstantState() &&
                        board[0][i].getDrawable().getConstantState() == board[2][i].getDrawable().getConstantState()) {
                    return true;
                }
            }

            //  diagonals
            if (board[0][0].getDrawable() != null &&
                    board[0][0].getDrawable().getConstantState() == board[1][1].getDrawable().getConstantState() &&
                    board[0][0].getDrawable().getConstantState() == board[2][2].getDrawable().getConstantState()) {
                return true;
            }
            if (board[0][2].getDrawable() != null &&
                    board[0][2].getDrawable().getConstantState() == board[1][1].getDrawable().getConstantState() &&
                    board[0][2].getDrawable().getConstantState() == board[2][0].getDrawable().getConstantState()) {
                return true;
            }

            return false;
        }

        private boolean checkForDraw() {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j].getDrawable() == null) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

