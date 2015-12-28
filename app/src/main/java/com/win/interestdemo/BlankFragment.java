package com.win.interestdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private static final String TEXT = "text";

    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(String text) {
        Bundle args = new Bundle();

        BlankFragment fragment = new BlankFragment();
        args.putString(TEXT,text);
        fragment.setArguments(args);
        return fragment;
    }


    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    /**
     * 视图创建之后
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      TextView text  =(TextView)view.findViewById(R.id.pager_text);

        String s = getArguments().getString("text");
        text.setText(s);
    }
}
