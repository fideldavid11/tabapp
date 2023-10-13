package com.example.tabapp;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private VideoView videoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);

        videoView = rootView.findViewById(R.id.videoView);
        TextView textView1 = rootView.findViewById(R.id.TextView1);


        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.programacion_movil;
        Uri videoUri = Uri.parse(videoPath);
        videoView.setVideoURI(videoUri);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);


        textView1.setText("Información de la aplicación: ¡Bienvenido a nuestra app! Aquí encontrarás...");


        videoView.start();

        return rootView;
    }
}