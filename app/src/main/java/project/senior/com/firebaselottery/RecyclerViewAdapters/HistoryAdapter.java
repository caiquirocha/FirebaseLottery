package project.senior.com.firebaselottery.RecyclerViewAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import project.senior.com.firebaselottery.DBHelper.DBAdapter;
import project.senior.com.firebaselottery.Models.HistoryModel;
import project.senior.com.firebaselottery.R;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {

    Context context;
    ArrayList<HistoryModel> listHistory;

    public HistoryAdapter(Context context, ArrayList<HistoryModel> listHistory){
        this.context = context;
        this.listHistory = listHistory;
    }

    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history_list, parent, false);
        HistoryHolder holder = new HistoryHolder(view);
        return holder;
//        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryHolder holder, int position) {
//        HistoryModel data = listHistory.get(position);

        holder.dateTextView.setText(listHistory.get(position).getSelected_date());
        holder.lotteryNumberTextView.setText(listHistory.get(position).getLottery_number());
        holder.resultTextView.setText(listHistory.get(position).getLottery_result());
    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        TextView dateTextView, lotteryNumberTextView, resultTextView;

        public HistoryHolder(View itemView){
            super(itemView);

            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            lotteryNumberTextView = (TextView) itemView.findViewById(R.id.lotteryNumberTextView);
            resultTextView = (TextView) itemView.findViewById(R.id.resultTextView);

        }
    }

    public void deleteHistory(int position){
        HistoryModel model = listHistory.get(position);
        int id = model.getId();

        DBAdapter db = new DBAdapter(context);
        db.openDB();
        if(db.deleteLottery(id)){
            listHistory.remove(position);
        } else {
            Toast.makeText(context,"Unable To Delete",Toast.LENGTH_SHORT).show();
        }
        db.closeDB();

        this.notifyItemRemoved(position);
    }
}
