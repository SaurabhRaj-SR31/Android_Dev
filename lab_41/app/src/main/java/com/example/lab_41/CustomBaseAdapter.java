package com.example.lab_41;


import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.lab_41.R;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    String versionand[];
    int images[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx,String []versions, int []icons){
        this.context=ctx;
        this.versionand=versions;
        this.images=icons;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return versionand.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView txtView=(TextView)convertView.findViewById(R.id.textView);
        ImageView vericon=(ImageView)convertView.findViewById(R.id.imgIcon);
        txtView.setText(versionand[position]);
        vericon.setImageResource(images[position]);
        return convertView;
    }
}
