package kotireddy.onteddu.libraries;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    public final View view;
    public final TextView name;
    public final ImageView icon;


    public CustomViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        name = (TextView) view.findViewById(R.id.name);
        icon = (ImageView) view.findViewById(R.id.icon);
    }

}
