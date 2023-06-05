import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         generateRandomNumber();
    }
//
    private void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(101);
    }

    public void checkGuess(View view) {
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
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

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }
}