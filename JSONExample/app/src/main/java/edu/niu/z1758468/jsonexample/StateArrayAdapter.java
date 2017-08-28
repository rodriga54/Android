package edu.niu.z1758468.jsonexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by aberodriguez on 5/3/16.
 */
public class StateArrayAdapter extends ArrayAdapter<State>
{
    public StateArrayAdapter(Context context, List<State> resource) {
       super(context, -1, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        State state = getItem(position);
        //return super.get(index);

        ViewHolder viewHolder;

        //
        if (convertView ==null)
        {
           viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            viewHolder.stateTV = (TextView)convertView.findViewById(R.id.stateTextView);
            viewHolder.numberTV = (TextView)convertView.findViewById(R.id.numberTextView);

            convertView.setTag(viewHolder);
        }
        // Re-use a View
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.stateTV.setText("State: " + state.stateAbbr);
        viewHolder.numberTV.setText("Number: " + state.stateNumber);

        return convertView;

        //return super.getView(position, convertView, parent);
    }// End of getView

    private static class ViewHolder
    {
        TextView stateTV, numberTV;
    }// End of ViewHolder
}// end StateArrayAdapter
