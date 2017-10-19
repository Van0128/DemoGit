package com.example.anhchan.taskone.RecycleView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anhchan.taskone.Object.DataRecyclerView;
import com.example.anhchan.taskone.R;
import com.example.anhchan.taskone.RecycleViewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.textSelectHandleWindowStyle;
import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class RecycleViewActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private EditText edtMain;
    private Button btnRemove;
    private List<DataRecyclerView> listData = new ArrayList<DataRecyclerView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        edtMain = (EditText) findViewById(R.id.edtMain);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager); // Setting the LayoutManager.
        recyclerViewAdapter = new RecyclerViewAdapter(listData);
        recyclerView.setAdapter(recyclerViewAdapter); // Setting the adapter.
        btnRemove.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String textAdd  = edtMain.getText().toString();
        if(textAdd == ""){
            Toast.makeText(this, "Erorr Input", Toast.LENGTH_LONG).show();
        }else {
            DataRecyclerView dataRecyclerViewToAdd = new DataRecyclerView(textAdd);
            recyclerViewAdapter.AddItem(listData.size(), dataRecyclerViewToAdd);
            edtMain.setText("");
        }
    }
}
