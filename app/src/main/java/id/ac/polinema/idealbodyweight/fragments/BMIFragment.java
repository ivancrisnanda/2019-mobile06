package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BodyMassIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BMIFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BMIFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BMIFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi,container, false);
        final EditText massText = view.findViewById(R.id.input_mass);
        final EditText heightText = view.findViewById(R.id.input_height);

        Button calculateButton = view.findViewById(R.id.btn_calculateBMI);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mListener != null) {
                    String massString = massText.getText().toString();
                    String heightString = heightText.getText().toString();
                    if (!TextUtils.isEmpty(massString) && !TextUtils.isEmpty(heightString)) {
                        float mass = Float.parseFloat(massString);
                        float height = Float.parseFloat(heightString);
                        BodyMassIndex bmi = new BodyMassIndex(mass, height/100);
                        mListener.onCalculateBMIClicked(bmi.BMIRange());
                    } else {
                        Toast.makeText(getActivity(), "Please Fill the form", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCalculateBMIClicked(String result);
    }
}
