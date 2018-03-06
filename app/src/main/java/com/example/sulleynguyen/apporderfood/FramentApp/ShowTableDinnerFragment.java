package com.example.sulleynguyen.apporderfood.FramentApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sulleynguyen.apporderfood.AddTableDinnerActivity;
import com.example.sulleynguyen.apporderfood.CustomAdapter.AdapterShowTableDinner;
import com.example.sulleynguyen.apporderfood.DAO.TableDinnerDAO;
import com.example.sulleynguyen.apporderfood.DTO.TableDinnerDTO;
import com.example.sulleynguyen.apporderfood.R;

import java.util.List;

/**
 * Created by sulleynguyen on 3/1/18.
 */

public class ShowTableDinnerFragment extends Fragment {

    public static int REQUEST_CODE_ADD = 111;
    GridView gvShowTableDinner;
    List<TableDinnerDTO> tableDinnerDTOList;
    TableDinnerDAO tableDinnerDAO;

    AdapterShowTableDinner adapterShowTableDinner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_showtabledinner,container,false);
        setHasOptionsMenu(true);

        gvShowTableDinner  =view.findViewById(R.id.gvShowTableDinner);
        tableDinnerDAO = new TableDinnerDAO(getActivity());
        tableDinnerDTOList = tableDinnerDAO.getAllTableDinner();

        showListTableDinner();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem itAddTableDinner = menu.add(1, R.id.itemAddTableDinner,1, R.string.AddTableDinner);
        itAddTableDinner.setIcon(R.drawable.thembanan);
        itAddTableDinner.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.itemAddTableDinner:
                Intent intentAddTableDinner = new Intent(getActivity(), AddTableDinnerActivity.class);
                //startActivity(intentAddTableDinner);
                //su dung startactivityforresult thay cho startactiviy
                startActivityForResult(intentAddTableDinner,REQUEST_CODE_ADD);
                ;break;
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_ADD){
            if(resultCode== Activity.RESULT_OK){
                Intent intent = data;
                boolean check = intent.getBooleanExtra("resultAdd",false);

                if(check){
                    showListTableDinner();
                    Toast.makeText(getActivity(),getResources().getString(R.string.AddSuccessfull),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getActivity(),getResources().getString(R.string.AddFail),Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void showListTableDinner(){
        tableDinnerDTOList = tableDinnerDAO.getAllTableDinner();
        adapterShowTableDinner = new AdapterShowTableDinner(getActivity(),R.layout.custom_layout_showtabledinner,tableDinnerDTOList);
        gvShowTableDinner.setAdapter(adapterShowTableDinner);
        adapterShowTableDinner.notifyDataSetChanged();
    }
}
