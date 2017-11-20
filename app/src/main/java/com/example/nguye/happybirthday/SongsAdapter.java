package com.example.nguye.happybirthday;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nguye on 20-Nov-17.
 */

public class SongsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Song> songs;

    public SongsAdapter(Context context, ArrayList<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int i) {
        return songs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView;
        if(view == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            rowView = inflater.inflate(R.layout.listview_item, viewGroup, false);
            ViewHolder holder = new ViewHolder();
            holder.imgSongIcon = rowView.findViewById(R.id.img_song_icon);
            holder.txtSongName = rowView.findViewById(R.id.txt_song_name);
            holder.txtSongLength = rowView.findViewById(R.id.txt_song_length);
            rowView.setTag(holder);
        } else {
            rowView = view;
        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        //holder.imgSongIcon.setImageResource();
        holder.txtSongName.setText(songs.get(i).getName());
        holder.txtSongLength.setText(songs.get(i).getLength() + " s");
        return rowView;
    }
    class ViewHolder{
        ImageView imgSongIcon;
        TextView txtSongName;
        TextView txtSongLength;
    }
}
