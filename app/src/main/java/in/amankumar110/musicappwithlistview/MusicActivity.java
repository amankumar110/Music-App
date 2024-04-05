package in.amankumar110.musicappwithlistview;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {

    Song currentSong;
    ImageView songImage;

    Button play;
    TextView songName,singer;

    MediaPlayer audio;

    Integer lastPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_music);

        songImage = findViewById(R.id.songImageDisplay);
        songName = findViewById(R.id.songNameDisplay);
        singer = findViewById(R.id.singerDisplay);
        play = findViewById(R.id.btn_play);

        currentSong = getIntent().getParcelableExtra("currentSong");

        displaySongContents(currentSong);
        playSong(currentSong);

       play.setBackgroundTintList(null);

       play.setOnClickListener(playButtonClickEvent);
    }

    public void playSong(Song song) {
        audio = MediaPlayer.create(this,song.getSongAudioResource());
        audio.start();
    }

    public void displaySongContents(Song song) {
        songImage.setImageResource(song.getSongResource());
        singer.setText(song.getSinger());
        songName.setText(song.getSongName());
    }

    View.OnClickListener playButtonClickEvent = v -> {

        if(audio.isPlaying()) {

            v.setBackgroundResource(R.drawable.play);
            audio.pause();
            lastPosition = audio.getCurrentPosition();
        } else {

            v.setBackgroundResource(R.drawable.pause);
            audio.seekTo(lastPosition);
            audio.start();
        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        audio.stop();
        audio.release();
    }
}