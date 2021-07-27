package sg.edu.rp.c346.id20023837.demotodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import sg.edu.rp.c346.id20023837.demotodolist.R;
import sg.edu.rp.c346.id20023837.demotodolist.ToDoItem;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> versionList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<ToDoItem> objects) {

        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvVersion = rowView.findViewById(R.id.textViewDate);

        ToDoItem currentVersion = versionList.get(position);

        if (currentVersion.getDate().get(Calendar.YEAR) == 2021) {
            tvVersion.setTextColor(Color.RED);

        }

        tvName.setText(currentVersion.getTitle());
        tvVersion.setText(currentVersion.toString());

        return rowView;
    }
}
