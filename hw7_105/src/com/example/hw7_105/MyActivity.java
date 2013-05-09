package com.example.hw7_105;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MyActivity extends Activity {

    Fragment1 frag1;
    Fragment2 frag2;
    FragmentTransaction fTrans;
    CheckBox chbStack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        frag1 = new Fragment1();
        frag2 = new Fragment2();

        chbStack = (CheckBox)findViewById(R.id.chbStack);
    }

    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnAdd:
                fTrans.add(R.id.frgmCont, frag1);
                break;
            case R.id.btnRemove:
                fTrans.remove(frag1);
                break;
            case R.id.btnReplace:
                fTrans.replace(R.id.frgmCont, frag2);
            default:
                break;
        }
        if (chbStack.isChecked()) fTrans.addToBackStack(null);
        fTrans.commit();
    }
}