package com.example.adivinhacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Recuperar o número de tentativas do Intent
        int numberOfAttempts = getIntent().getIntExtra("numberofattemps", 0);

        // Criar um layout para exibir o número de tentativas
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setPadding(16, 16, 16, 16);

        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setText("Número de tentativas para acertar: " + numberOfAttempts);
        mainLayout.addView(textView);

        homeButton = new Button(this);
        homeButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        homeButton.setText("Voltar para a Home Page");
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHome();
            }
        });
        mainLayout.addView(homeButton);

        setContentView(mainLayout);
    }

    private void goHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("reset", true);
        startActivity(intent);
    }
}
