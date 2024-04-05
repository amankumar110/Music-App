package in.amankumar110.musicappwithlistview;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionService;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    ListView songsList;

    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songsList = findViewById(R.id.songs);

        songs = new ArrayList<>();
        songs.add(new Song("Paiso Aa","Mazhar Chandio",R.drawable.song1,R.raw.song1));
        songs.add(new Song("Hum sindh mein rehne wale sindhi","Mumtaz molai",R.drawable.song2,R.raw.song2));
        songs.add(new Song("Meri Cute Jaana!","Asghar Khoso",R.drawable.song3,R.raw.song3));
        songs.add(new Song("Hal Mujhnja Ker Puchando","Saif Samejo",R.drawable.song4,R.raw.song4));

        SongsAdapter adapter= new SongsAdapter(this,R.layout.list_item,songs);

        songsList.setAdapter(adapter);

        songsList.setOnItemClickListener((parent, view, position, id) -> {

        Song currentSong = songs.get(position);

        Intent intent = new Intent(this,MusicActivity.class);
        intent.putExtra("currentSong",currentSong);
        startActivity(intent);

        });
    }












}