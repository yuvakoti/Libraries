package kotireddy.onteddu.libraries;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Adapter extends RecyclerView.Adapter<CustomViewHolder> {

    DataModel[] dataModels;
    Context context;
    private static final String TAG = Adapter.class.getSimpleName();

    public Adapter(DataModel[] dataModels, Context context) {
        this.dataModels = dataModels;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if (!ObjectUtil.objectNotNull(holder)) {
            return;
        }
        final DataModel dataModel = dataModels[position];
        holder.name.setText(dataModel.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: ");
                Intent intent = new Intent(context,MapsActivity.class);
                intent.putExtra("lat",dataModel.getLocation().getLatitude());
                intent.putExtra("long",dataModel.getLocation().getLongitude());
                intent.putExtra("address",dataModel.getAddress()
                +"\n"+dataModel.getHoursOfOperation()+"\n"+dataModel.getCity()+"\n"+dataModel.getZip());
                intent.putExtra("name",dataModel.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModels.length;
    }
}
