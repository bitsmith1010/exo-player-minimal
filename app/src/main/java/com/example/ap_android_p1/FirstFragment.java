package com.example.ap_android_p1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class FirstFragment extends Fragment {

    private SimpleExoPlayer player;
    private StyledPlayerView playerView1;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        initializePlayer();
        playerView1 = view.findViewById(R.id.exo_player_view1);
        playerView1.setPlayer(player);

    }
    public void initializePlayer()
    {
        player = new SimpleExoPlayer.Builder(getContext()).build();

        // Build the media item.
        MediaItem mediaItem = MediaItem.fromUri(
                "https://bitmovin-amer-public.s3.amazonaws.com/internal/dani/live_encoding_1/manifest_vod.mpd");
        // Set the media item to be played.
        player.setMediaItem(mediaItem);
        // Prepare the player.
        player.prepare();
        // Start the playback.
        player.play();
    }

}