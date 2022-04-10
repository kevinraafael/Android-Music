package com.example.basicmediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    private Spinner spinner;
    private MediaPlayer mPlayer;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sons, android.R.layout.simple_spinner_item);

        View view =  inflater.inflate(R.layout.fragment_second, container, false);
        spinner = view.findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // Quando o item do spinner tiver selecionado
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(mPlayer!=null){
                    mPlayer.release();
                }
                switch (i){
                    case 1:
                        mPlayer = MediaPlayer.create(getContext(),R.raw.slash);
                        break;
                    case 2:
                        mPlayer = MediaPlayer.create(getContext(),R.raw.wonderwall);
                        break;
                    case 3:
                        mPlayer = MediaPlayer.create(getContext(),R.raw.time);
                        break;
                    case 4:
                        mPlayer = MediaPlayer.create(getContext(),R.raw.blink);
                        break;
                    case 5:
                        mPlayer = MediaPlayer.create(getContext(),R.raw.best);
                        break;
                    case 6:
                        mPlayer = MediaPlayer.create(getContext(),R.raw.californacation);
                        break;
                    case 7:
                        mPlayer = MediaPlayer.create(getContext(),R.raw.ultraviolet);
                        break;

                }
                if(mPlayer!=null){
                    mPlayer.start();
                    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.release();
                        }
                    }); // quando ele terminar de tocar interromper o media player
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return  view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast toast = Toast.makeText(getContext(),"Terceiro Fragmento",Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.TOP|Gravity.LEFT, 0 ,0);
//                toast.show();
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}