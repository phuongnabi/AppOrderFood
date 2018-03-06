package com.example.sulleynguyen.apporderfood.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sulleynguyen.apporderfood.DTO.TableDinnerDTO;
import com.example.sulleynguyen.apporderfood.R;

import java.util.List;

/**
 * Created by sulleynguyen on 3/6/18.
 */

public class AdapterShowTableDinner extends BaseAdapter  implements View.OnClickListener {
    Context context;
    int layout;
    List<TableDinnerDTO> tableDinnerDTOList;
    ViewHolderTableDinner viewHolderTableDinner;

    public AdapterShowTableDinner(Context context, int layout, List<TableDinnerDTO> tableDinnerDTOList){
        this.context = context;
        this.layout = layout;
        this.tableDinnerDTOList = tableDinnerDTOList;
    }

    @Override
    public int getCount() {
        return tableDinnerDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return tableDinnerDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tableDinnerDTOList.get(position).getTableCode()  ;
    }

    public class ViewHolderTableDinner{
        ImageView imTableDinner, imOder, imPayment, imHide, imButton;
        TextView txtTableDinnerName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_layout_showtabledinner,parent,false);

            viewHolderTableDinner = new ViewHolderTableDinner();
            viewHolderTableDinner.imTableDinner = view.findViewById(R.id.imTableDinner);
            viewHolderTableDinner.imPayment = view.findViewById(R.id.imPayment);
            viewHolderTableDinner.imOder = view.findViewById(R.id.imOrder);
            viewHolderTableDinner.imHide = view.findViewById(R.id.imHide);
            viewHolderTableDinner.txtTableDinnerName = view.findViewById(R.id.txtTableDinnerName);

            view.setTag(viewHolderTableDinner);

        }else{
            viewHolderTableDinner = (ViewHolderTableDinner) view.getTag();

        }

        TableDinnerDTO tableDinnerDTO = tableDinnerDTOList.get(position);
        viewHolderTableDinner.txtTableDinnerName.setText(tableDinnerDTO.getTableName());

        viewHolderTableDinner.imTableDinner.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        viewHolderTableDinner = (ViewHolderTableDinner) ((View)v.getParent()).getTag();
        switch (id){
            case R.id.imTableDinner:
                viewHolderTableDinner.imPayment.setVisibility(View.VISIBLE);
                ;break;
        }
    }
}
