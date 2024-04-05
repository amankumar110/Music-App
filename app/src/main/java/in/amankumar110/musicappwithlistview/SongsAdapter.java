 package in.amankumar110.musicappwithlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongsAdapter extends ArrayAdapter<Song> {

    private Context context;
    private ArrayList<Song> songs;

    public SongsAdapter(@NonNull Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.songName = convertView.findViewById(R.id.songName);
            holder.singer = convertView.findViewById(R.id.singer);
            holder.imageResource = convertView.findViewById(R.id.songImage);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song currentSong = songs.get(position);
        holder.songName.setText(currentSong.getSongName());
        holder.singer.setText(currentSong.getSinger());
        holder.imageResource.setImageResource(currentSong.getSongResource());

        return convertView;
    }

    static class ViewHolder {
        TextView songName, singer;
        ImageView imageResource;
    }
}
