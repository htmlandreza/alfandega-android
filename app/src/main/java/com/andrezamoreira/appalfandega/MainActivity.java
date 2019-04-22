package com.andrezamoreira.appalfandega;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    ImageView imagem;
    TextView texto;

    Animation show;
    Animation hidden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicialização
        imagem = findViewById(R.id.setaImageView);
        texto = findViewById(R.id.textoTextView);

        // indica texto da TextView
        texto.setText("Toque na tela");
        imagem.setVisibility(View.INVISIBLE);


        // animação
        show = new AlphaAnimation(0,1);
        hidden = new AlphaAnimation(1,0);

        // tempo para animação - em milisegundos
        hidden.setDuration(500);
        show.setDuration(500);

        // eventos da animação - SHOW
        show.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // eventos da animação - DIDDEN
        hidden.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.INVISIBLE);
                texto.setText("Toque na tela");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    // ao clicar na tela
    public void clicouTela(View view){
        // aleatório - esquerda
        if (Math.random() < 0.5){
            // indica texto da TextView
            texto.setText("Siga para Esquerda");
            // altera o lado da seta
            imagem.setScaleX(   1f);
        }
        // direita
        else {
            texto.setText("Siga para Direita");
            imagem.setScaleX(-1f);
        }

        imagem.startAnimation(show);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                imagem.startAnimation(hidden);
            }
        }, 2000);
}


}
