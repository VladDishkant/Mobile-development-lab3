package ua.kpi.comsys.iv7312;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdapter extends ArrayAdapter<State> {

    private LayoutInflater inflater;
    private int layout;
    private List<State> states;

    public StateAdapter(Context context, int resource, List<State> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView posterView = (ImageView) view.findViewById(R.id.poster);
        TextView titleView = (TextView) view.findViewById(R.id.title);
        TextView yearView = (TextView) view.findViewById(R.id.year);
        TextView typeView = (TextView) view.findViewById(R.id.type);

        State state = states.get(position);

        posterView.setImageResource(state.getPoster());
        titleView.setText(state.getTitle());
        yearView.setText(state.getYear());
        typeView.setText(state.getType());

        return view;
    }
}