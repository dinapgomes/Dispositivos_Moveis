package com.example.adivinhacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView instructionTextView;
    private TextView textView;
    private EditText editText;
    private Button sendButton;
    private Button resultsButton;
    private int randomNumber;
    private int numberofattemps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setPadding(16, 16, 16, 16);

        instructionTextView = new TextView(this);
        instructionTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        instructionTextView.setText("Insira um número:");
        mainLayout.addView(instructionTextView);

        textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mainLayout.addView(textView);

        editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mainLayout.addView(editText);

        sendButton = new Button(this);
        sendButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        sendButton.setText("Enviar");
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
        mainLayout.addView(sendButton);

        resultsButton = new Button(this);
        resultsButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        resultsButton.setText("Ir para resultados");
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResults();
            }
        });
        mainLayout.addView(resultsButton);

        setContentView(mainLayout);

        generateRandomNumber();
    }

    private void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(101);
    }

    private void sendData() {
        String input = editText.getText().toString();
        // Enviar dados ou realizar alguma ação com o dado fornecido pelo usuário

        // Exemplo de verificação se o número enviado é igual ao número gerado
        int guess = Integer.parseInt(input);
        String message;

        if (guess > randomNumber) {
            message = "O número é menor!";
            numberofattemps++;
        } else if (guess < randomNumber) {
            message = "O número é maior!";
            numberofattemps++;
        } else {
            message = "Parabéns! Você acertou!";
            generateRandomNumber();

        }

        textView.setText(message);
    }

    private void showResults() {
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("numberofattemps", numberofattemps);
        startActivity(intent);
    }
}
