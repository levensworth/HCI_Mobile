package com.bassanidevelopment.santiago.hci_movil;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.bassanidevelopment.santiago.hci_movil.API.DevicesAPI;
import com.bassanidevelopment.santiago.hci_movil.API.SingletonAPI;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.home);
                    return true;
                case R.id.navigation_rooms:
                    mTextMessage.setText(R.string.rooms);
                    return true;
                case R.id.navigation_routines:
                    mTextMessage.setText(R.string.routines);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.upper_toolbar);
        myToolbar.inflateMenu(R.menu.toolbar_menu);
        myToolbar.setNavigationIcon(R.drawable.ic_back);
        myToolbar.setTitle(R.string.home);
        testAPI();

    }


    public void testAPI(){
        SingletonAPI api = SingletonAPI.getInstance(this);
        DevicesAPI.getAllDevices(this);
    }
}
