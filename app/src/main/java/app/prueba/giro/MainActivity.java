package app.prueba.giro;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity
{
    private TextSwitcher mSwitcher;
    private TextSwitcher mSwitcher2;

    ImageButton btnSmile;
    ImageButton btnRegular;
    ImageButton btnNegative;

    String textToShow[]= {"¿Cómo fue nuestra atención el día de hoy?", "¿Se sintió atendido con calidez , amabilidad y respeto ?", "¿Cómo evalúa la ayuda recibida ?"};
    String textToShow2[]= {"buena                 regular            mala", "si             mas o menos              no", "buena           regular           mala"};
    int messageCount=textToShow.length;
    int currentIndex=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // botones
        btnSmile=(ImageButton)findViewById(R.id.button_smile);
        btnRegular=(ImageButton)findViewById(R.id.button_regular);
        btnNegative=(ImageButton)findViewById(R.id.button_negative);
        mSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        mSwitcher2 = (TextSwitcher) findViewById(R.id.textSwitcher2);

        // textos pregguntas
        mSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView myText = new TextView(MainActivity.this);
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(22);
                myText.setTextColor(Color.WHITE);
                return myText;
            }
        });
        // textos respuestas
        mSwitcher2.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                TextView myText2 = new TextView(MainActivity.this);
                myText2.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
                myText2.setTextSize(30);
                myText2.setTextColor(Color.WHITE);
                return myText2;
            }
        });

        // tipo de anim
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // anim del textswithcher
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
        mSwitcher2.setInAnimation(in);
        mSwitcher2.setOutAnimation(out);

        // boton clickeado
        btnSmile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                currentIndex++;
                if(currentIndex==messageCount)
                    currentIndex=0;
                mSwitcher.setText(textToShow[currentIndex]);
                mSwitcher2.setText(textToShow2[currentIndex]);
            }
        });

        btnRegular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                currentIndex++;
                if(currentIndex==messageCount)
                    currentIndex=0;
                mSwitcher.setText(textToShow[currentIndex]);
                mSwitcher2.setText(textToShow2[currentIndex]);
            }
        });

        btnNegative.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                currentIndex++;
                if(currentIndex==messageCount)
                    currentIndex=0;
                mSwitcher.setText(textToShow[currentIndex]);
                mSwitcher2.setText(textToShow2[currentIndex]);
            }
        });
    }
}
