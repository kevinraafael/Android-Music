package com.example.basicmediaplayer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;



public class ThirdFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });

        // Passando as imagens para  uma lista
        int [] lista = new int []{ R.drawable.gunsandroses,R.drawable.oasis,R.drawable.pinkfloyd,
                R.drawable.blink,R.drawable.foofighters,R.drawable.rhcp,R.drawable.u2};

        GridView gv = (GridView) view.findViewById(R.id.grid01);
        gv.setAdapter(new Adaptador(getContext(),lista));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Toast toast = Toast.makeText(getContext(),"Álbum"+gv.getItemIdAtPosition(i),Toast.LENGTH_LONG);
                //toast.show();
                switch (i){
                    case 0:
                        Toast toast0 = Toast.makeText(getContext(),"Guns and Roses : Use your llusion 2",Toast.LENGTH_LONG);
                        toast0.show();
                        break;
                    case 1: Toast toast1 = Toast.makeText(getContext(),"(What's the Story) Morning Glory?",Toast.LENGTH_LONG);
                        toast1.show();
                        break;
                    case 2:Toast toast2 = Toast.makeText(getContext(),"Pink FLoyd: The dark side of the Moon",Toast.LENGTH_LONG);
                        toast2.show();
                        break;
                    case 3:Toast toast3 = Toast.makeText(getContext(),"Blink 182: Enema of the State",Toast.LENGTH_LONG);
                        toast3.show();
                        break;
                    case 4: Toast toast4 = Toast.makeText(getContext(),"Foo Fighters: The colour and the shape ",Toast.LENGTH_LONG);
                        toast4.show();
                        break;
                    case 5: Toast toast5 = Toast.makeText(getContext(),"Red Hot Chili Pepper: Californication ",Toast.LENGTH_LONG);
                        toast5.show();
                        break;
                    case 6: Toast toast6 = Toast.makeText(getContext(),"U2: The Joshua Tree ",Toast.LENGTH_LONG);
                        toast6.show();
                        break;
                    default:Toast defaultToast = Toast.makeText(getContext(),"Nenhum Álbum foi selecionado ",Toast.LENGTH_LONG);
                    defaultToast.show();
                    break;


                }
            }
        });
        // Antes precisamos carregar nossas imagens para o grid e isso será feito por meio da classe adaptador

        //(R.id.grid01)= setAdapter(new Adaptador(getContext()),lista);

//        view.findViewById(R.id.grid01).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }
}