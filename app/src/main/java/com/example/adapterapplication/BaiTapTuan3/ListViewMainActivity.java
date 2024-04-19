package com.example.adapterapplication.BaiTapTuan3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adapterapplication.R;

import java.util.ArrayList;

public class ListViewMainActivity extends AppCompatActivity {
    ArrayList<Info> dataModels = new ArrayList<>();
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.t3activity_list_view_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listview = (ListView) findViewById(R.id.listView);
        dataModels.add(new Info("Lap1","10tr", R.drawable.product1));
        dataModels.add(new Info("Lap2","20tr", R.drawable.product2));
        dataModels.add(new Info("Lap3","15tr", R.drawable.product3));
        dataModels.add(new Info("Lap4","25tr", R.drawable.product4));
        InfoAdapter adapter = new InfoAdapter(dataModels, this);
        listview.setAdapter(adapter);
    }
}