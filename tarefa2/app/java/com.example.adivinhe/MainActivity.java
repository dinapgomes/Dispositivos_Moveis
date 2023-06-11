package com.example.adivinhe;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int randomNumber;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextNumber);
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(101);
    }

    public void checkGuess(View view) {
        int guess = Integer.parseInt(editText.getText().toString());
        String message;

        if (guess > randomNumber) {
            message = "O número é menor!";
        } else if (guess < randomNumber) {
            message = "O número é maior!";
        } else {
            message = "Parabéns! Você acertou!";
            generateRandomNumber();
        }

        textView.setText(message);
    }
}