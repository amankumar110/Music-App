package in.amankumar110.musicappwithlistview;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Song implements Parcelable {

    private String songName,singer;

    private int songResource;

    private int songAudioResource;

    public Song(String songName, String singer, int songResource, int songAudioResource) {
        this.songName = songName;
        this.singer = singer;
        this.songResource = songResource;
        this.songAudioResource = songAudioResource;
    }

    public Song() {

    }

    protected Song(Parcel in) {
        songName = in.readString();
        singer = in.readString();
        songResource = in.readInt();
        songAudioResource = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator() {

        @Override
        public Object createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSongAudioResource() {
        return songAudioResource;
    }

    public void setSongAudioResource(int songAudioResource) {
        this.songAudioResource = songAudioResource;
    }

    public int getSongResource() {
        return songResource;
    }

    public void setSongResource(int songResource) {
        this.songResource = songResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeString(songName);
        dest.writeString(singer);
        dest.writeInt(songResource);
        dest.writeInt(songAudioResource);
    }
}
