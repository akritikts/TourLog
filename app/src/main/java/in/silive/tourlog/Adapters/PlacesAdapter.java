package in.silive.tourlog.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import in.silive.tourlog.R;

/**
 * Created by akriti on 3/3/17.
 */

public class PlacesAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    Context context;
    String list_of_tourist_spots[];
    public class ViewHolder{
        TextView name_of_place;
        CheckBox box_for_place;
    }

    public PlacesAdapter(Context context, String[] list_of_tourist_spots) {
        this.context = context;
        this.list_of_tourist_spots = list_of_tourist_spots;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater.inflate(R.layout.places_adapter,null);
        ViewHolder holder = new ViewHolder();
        holder.name_of_place = (TextView)view.findViewById(R.id.name_of_place);
        holder.box_for_place = (CheckBox)view.findViewById(R.id.box_for_place);
        holder.name_of_place.setText(list_of_tourist_spots[i]);
        return null;
    }
}
