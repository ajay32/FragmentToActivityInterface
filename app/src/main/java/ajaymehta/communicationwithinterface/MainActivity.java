package ajaymehta.communicationwithinterface;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;


// Reason why we need to use Interface to Communicate with from Fragment to Activity ....when we can do this stuff....with the help of Bundle, making it all static etc etc
// here is the reason...to elemenate the problem to referesh ...suppose the task is to change text in fragment..n what we change in edit text in fragment shoud change the title of an Activity..(we do using textWatcher)
// if we change edit text in fragment n send it to activity...it will not update at an instant..we have to referesh...
//so interface communication will help...this is just a thinking...still need to implement that...go implement n let me know..



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