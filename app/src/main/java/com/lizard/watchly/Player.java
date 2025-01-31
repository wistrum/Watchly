package com.lizard.watchly;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class Player extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        playerView = findViewById(R.id.player_view);

        // Initialize ExoPlayer
        exoPlayer = new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(exoPlayer);

        // Set the video URL from Amazon S3 bucket
        String videoUrl = "https://watchly.s3.ap-south-1.amazonaws.com/Y2Mate.is+-+Cows+Funny+Cute+Video+%F0%9F%94%B4+Cute+and+Funny+Cow+sound+Videos+Compilation+Part+6-JU06zey_tj0-144p-1657009417722.mp4";
        Uri videoUri = Uri.parse(videoUrl);

        // Create a MediaItem and set the video URI
        MediaItem mediaItem = MediaItem.fromUri(videoUri);
        exoPlayer.setMediaItem(mediaItem);

        // Prepare and start the ExoPlayer
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release the ExoPlayer when the activity is destroyed
        exoPlayer.release();
    }
}
