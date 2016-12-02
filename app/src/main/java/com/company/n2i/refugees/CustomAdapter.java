package com.company.n2i.refugees;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by julien on 02/12/16.
 */

public class CustomAdapter extends ArrayAdapter<Topic> {

    private Activity activity;
    private ArrayList<Topic> _lTopic;
    private static LayoutInflater inflater = null;

    public CustomAdapter(Activity activity, int textViewResourceId, ArrayList<Topic> _lTopic) {
        super(activity, textViewResourceId, _lTopic);
        try {
            this.activity = activity;
            this._lTopic = _lTopic;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {

        }
    }

    public int getCount() {
        return _lTopic.size();
    }

    public Topic getItem(Topic position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView title;
        public TextView description;
        public ImageView imageCategorie;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.adapter_information_layout, null);
                holder = new ViewHolder();

                holder.title = (TextView) vi.findViewById(R.id.tvAdapterTitle);
                holder.description = (TextView) vi.findViewById(R.id.tvAdapterDescription);
                holder.imageCategorie = (ImageView) vi.findViewById(R.id.imAdapterLeft);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

            holder.title.setText(_lTopic.get(position).getTitre());
            holder.description.setText(_lTopic.get(position).getContenu());

            if(_lTopic.get(position).getCategorieFrench() == ""){
                holder.imageCategorie.setImageResource(R.drawable.ic_bed);
            }else if(_lTopic.get(position).getCategorieFrench().startsWith("Nou")){
                holder.imageCategorie.setImageResource(R.drawable.ic_food);
            }else if(_lTopic.get(position).getCategorieFrench().startsWith("Vêt")){
                holder.imageCategorie.setImageResource(R.drawable.ic_cloths);
            }else if(_lTopic.get(position).getCategorieFrench() == ""){
                holder.imageCategorie.setImageResource(R.drawable.ic_obamacare);
            }else if(_lTopic.get(position).getCategorieFrench() == ""){
                holder.imageCategorie.setImageResource(R.drawable.ic_wifi);
            }

        } catch (Exception e) {


        }
        return vi;
    }

}
