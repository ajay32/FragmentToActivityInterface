package ajaymehta.communicationwithinterface;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFruitsItemSelected {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();

        setFragment(firstFragment);
    }


    public void setFragment(Fragment frag) {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.container) == null) {
            fm.beginTransaction().add(R.id.container, frag).commit();
        }
    }

    @Override
    public void onFruitsItemPicked(int position , List fruitList) {

        Toast.makeText(this, "This is position no "+position ,Toast.LENGTH_SHORT).show();
    }
}