package com.androidtutorialpoint;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

	static private final String DEVELOPER_KEY = "AIzaSyCIPao31XU-LD_pQXIF9afDlShEWdecq2U";
	static private final String VIDEO = "XpB-uFUfyLQ";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtubevideo);
	    youTubeView.initialize(DEVELOPER_KEY, this);
	  }

	@Override
	public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
		Toast.makeText(this, "Oh no! "+error.toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
		player.loadVideo(VIDEO);
	}


}
