package pokecrater1.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnKeyListener;

import java.util.Random;

public class Hangman extends AppCompatActivity {
    String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String[] movieList = new String[20];
    String word = movieList(movieList);
    String underScores = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        Button b = (Button) this.findViewById(R.id.button1);
        b.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TextView resp = (TextView) findViewById(R.id.response);
                EditText input = (EditText) findViewById(R.id.textView);
                String guess = input.getText().toString();
                abc = changeABC(guess, abc);
                resp.setText(abc);
                // changes the word into underscores
                underScores = underScores(word, underScores);
                TextView phrase = (TextView) findViewById(R.id.phraseid);
                phrase.setText(underScores);
            }
        });
    }

    public static String underScores(String word, String underScores) {
        underScores = "";
        for (int index = 0; index < word.length() - 1; index++) {
            underScores += "_ ";
        }
        underScores += "_";
        return underScores;
    }

    public static String movieList(String[] movieList) {
        movieList[0] = "The Godfather";
        movieList[1] = "The Shawshank Redemption";
        movieList[2] = "Spirited Away";
        movieList[3] = "Raging Bull";
        movieList[4] = "Casablanca";
        movieList[5] = "Citizen Kane";
        movieList[6] = "The Wizard of Oz";
        movieList[7] = "Forrest Gump";
        movieList[8] = "Gladiator";
        movieList[9] = "Titanc";
        movieList[10] = "Saving Private Ryan";
        movieList[11] = "Unforgiven";
        movieList[12] = "Raiders of the Lost Ark";
        movieList[13] = "Jaws";
        movieList[14] = "Jurassic Park";
        movieList[15] = "Rush Hour";
        movieList[16] = "Good Will Hunting";
        movieList[17] = "Grave of the Fireflies";
        movieList[18] = "Howl's Moving Castle";
        movieList[19] = "My Neighbor Totoro";
        Random r = new Random();
        int choose = r.nextInt(20);
        return movieList[choose];

    }

    // changes the abc string based off of the guess
    public static String changeABC(String guess, String abc) {
        String beginning = abc.substring(0, abc.indexOf(guess));
        String end = "";

        if (!guess.equals("Z")) {
            end = abc.substring(abc.indexOf(guess) + 1);
        } else {
            beginning = abc.substring(0, abc.indexOf(guess));
        }
        return beginning + end;
    }


}
