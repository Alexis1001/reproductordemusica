package app.reproductordemusica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button stop,play,siguiente,atras;
    MediaPlayer mp3[]=new MediaPlayer[4];
    TextView texto;
    int item=0;
    ImageView imagen;
    ArrayList<String> autores=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.atras=(Button)findViewById(R.id.button_back);
        this.play=(Button)findViewById(R.id.button_play);
        this.stop=(Button)findViewById(R.id.button_pause);
        this.siguiente=(Button) findViewById(R.id.button_next);
        this.texto=(TextView)findViewById(R.id.TextView);
        mp3[0]=MediaPlayer.create(MainActivity.this,R.raw.song1);
        mp3[1]=MediaPlayer.create(MainActivity.this,R.raw.song2);
        mp3[2]=MediaPlayer.create(MainActivity.this,R.raw.song3);
        mp3[3]=MediaPlayer.create(MainActivity.this,R.raw.song4);

       autores.add("autor 1");
       autores.add("autor 2");
       autores.add("autor 3");
       autores.add("autor 4");




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("");
                Toast mensaje=Toast.makeText(getApplicationContext(),"reproduciendo",Toast.LENGTH_SHORT);
                mensaje.show();
                mp3[item].start();
                texto.setText(autores.get(item).toUpperCase());
                //texto.setText(null);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp3[item].isPlaying()){
                    texto.setText("");
                    Toast mensaje=Toast.makeText(getApplicationContext(),"pausado",Toast.LENGTH_SHORT);
                    mensaje.show();
                    mp3[item].pause();
                    texto.setText(autores.get(item).toUpperCase());
                }
                else {
                    texto.setText("");
                    Toast mensaje = Toast.makeText(getApplicationContext(), "pausado", Toast.LENGTH_SHORT);
                    mensaje.show();
                    mp3[item].pause();
                    texto.setText(autores.get(item).toUpperCase());
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(item>0){
                 if(mp3[item].isPlaying()){
                     texto.setText("");
                     Toast mensaje=Toast.makeText(getApplicationContext(),"atras",Toast.LENGTH_SHORT);
                     mensaje.show();
                     mp3[item].stop();
                     mp3[0]=MediaPlayer.create(MainActivity.this,R.raw.song1);
                     mp3[1]=MediaPlayer.create(MainActivity.this,R.raw.song2);
                     mp3[2]=MediaPlayer.create(MainActivity.this,R.raw.song3);
                     mp3[3]=MediaPlayer.create(MainActivity.this,R.raw.song4);

                     item--;
                     mp3[item].start();
                     texto.setText(autores.get(item).toUpperCase());
                 }
                 else{
                     texto.setText("");
                     Toast mensaje=Toast.makeText(getApplicationContext(),"atras",Toast.LENGTH_SHORT);
                     mensaje.show();
                     item--;
                     mp3[item].start();
                     texto.setText(autores.get(item).toUpperCase());
                 }

              }
              else{
                  Toast mensaje=Toast.makeText(getApplicationContext(),"no pista anterior",Toast.LENGTH_SHORT);
                  mensaje.show();
              }

            }
        });

        siguiente.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(item<mp3.length-1){
                    if(mp3[item].isPlaying()){
                        texto.setText("");
                        Toast mensaje=Toast.makeText(getApplicationContext(),"siguiente",Toast.LENGTH_SHORT);
                        mensaje.show();
                        mp3[item].stop();
                        item++;
                        mp3[item].start();
                        texto.setText(autores.get(item).toUpperCase());

                       /* if(item==0){
                           imagen.setImageResource(R.drawable.atras);
                        }
                        if(item==1){
                            imagen.setImageResource(R.drawable.rock2);
                        }
                        if(item==2){
                            imagen.setImageResource(R.drawable.rock3);
                        }
                        if(item==3){
                            imagen.setImageResource(R.drawable.rock4);
                        }*/
                     }
                    else{
                        texto.setText("");
                        item++;
                        mp3[item].start();
                        texto.setText(autores.get(item).toUpperCase());
                        /*if(item==0){
                            imagen.setImageResource(R.drawable.rock1);
                        }
                        if(item==1){
                            imagen.setImageResource(R.drawable.rock2);
                        }
                        if(item==2){
                            imagen.setImageResource(R.drawable.rock3);
                        }
                        if(item==3){
                            imagen.setImageResource(R.drawable.rock4);
                        }*/
                    }

                 }

                else{

                    Toast mensaje=Toast.makeText(getApplicationContext(),"no pista siguinte",Toast.LENGTH_SHORT);
                    mensaje.show();

                }

            }

        });



    }


}
