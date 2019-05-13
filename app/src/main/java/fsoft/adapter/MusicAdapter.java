package fsoft.adapter;

import  android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fsoft.karaoke.KaraokeActivity;
import fsoft.karaoke.R;
import fsoft.model.Music;

//import static fsoft.karaoke.MainActivity.database;

public class MusicAdapter extends ArrayAdapter<Music> {
    Context context;
    int resource;
    ArrayList<Music> objects;

    ArrayList<Music> filList;


    public MusicAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Music> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.filList = objects;
    }
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.resource,null);
        // Lay Controls
        TextView txtTen = convertView.findViewById(R.id.txtTen);
        TextView txtMa = convertView.findViewById(R.id.txtMa);
        TextView txtCaSi = convertView.findViewById(R.id.txtCaSi);
        TextView txtLoi = convertView.findViewById(R.id.txtLoi);
        final ImageView btnLike = convertView.findViewById(R.id.btnLike);

        // Set gia tri cho Controls
        final Music music = objects.get(position);

        txtTen.setText(music.getTen().toString());
        txtMa.setText(music.getMa().toString());
        txtCaSi.setText(music.getCaSi().toString());
        txtLoi.setText(music.getLoiBH().toString());

        if(music.isThich())
        {
            btnLike.setImageResource(R.drawable.ic_favorite);
        }
        else
            btnLike.setImageResource(R.drawable.ic_unfavorite);

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(music.isThich())
                {
                    objects.get(position).setThich(false);// huy bai hat thich
                    btnLike.setImageResource(R.drawable.ic_unfavorite);
                    Toast.makeText(context, R.string.remove_list +objects.get(position).getTen(), Toast.LENGTH_SHORT).show();
                    ContentValues row = new ContentValues();
                    row.put("YEUTHICH",0);
                    KaraokeActivity.database.update("ArirangSongList",row,"MABH=?", new String[]{music.getMa()});
                }
                else
                {
                    objects.get(position).setThich(true); // thich bai hat
                    btnLike.setImageResource(R.drawable.ic_favorite);
                    Toast.makeText(context, R.string.add_list +objects.get(position).getTen(), Toast.LENGTH_SHORT).show();
                    ContentValues row = new ContentValues();
                    row.put("YEUTHICH",1);
                    KaraokeActivity.database.update("ArirangSongList",row,"MABH=?", new String[]{music.getMa()});
                }
            }
        });

        return convertView;
    }

}
