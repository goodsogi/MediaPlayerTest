package com.example.androidcontrolvolumetest;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	private MediaPlayer mMusic1Player;
	private MediaPlayer mMusic2Player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);

		mMusic1Player = MediaPlayer.create(MainActivity.this, R.raw.music1);

		mMusic2Player = MediaPlayer.create(MainActivity.this, R.raw.music2);

	}

	/**
	 * Change music
	 * 
	 * @param v
	 */
	public void changeMusic(View v) {
		if (v.isSelected()) {
			v.setSelected(false);
			mMusic1Player.start();
			if (mMusic2Player.isPlaying())
				mMusic2Player.pause();
		} else {
			v.setSelected(true);
			mMusic2Player.start();
			if (mMusic1Player.isPlaying())
				mMusic1Player.pause();
		}

	}

}
