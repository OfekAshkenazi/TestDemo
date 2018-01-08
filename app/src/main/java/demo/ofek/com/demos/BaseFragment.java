package demo.ofek.com.demos;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.ofek.com.demos.Entities.User;
import demo.ofek.com.demos.Entries.Entries;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class BaseFragment extends Fragment {
    SharedPreferences preferences;
    TextView userTV;
    public BaseFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        preferences = context.getSharedPreferences(Entries.PREF_FILE_TAG,Context.MODE_PRIVATE);
    }
    public void saveUser(User user){
        preferences.edit().putString(Entries.PREF_CURRENT_USER_TAG,user.toString()).commit();
        userTV.setText(user.toString());
    }

    public void showUser(){
        String temp=preferences.getString(Entries.PREF_CURRENT_USER_TAG,"null");
        if (!temp.equals("null")){
            String[] arr=temp.split(", ");
            String textToShow="";
            for (String text:arr){
                textToShow=textToShow+text+"\n";
            }
            userTV.setText(textToShow);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userTV=view.findViewById(R.id.userTV);
    }
    // TODO: Rename method, update argument and hook method into UI event


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
