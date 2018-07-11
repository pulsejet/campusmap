package com.mrane.campusmap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.preference.PreferenceManager;

public class SettingsManager implements OnSharedPreferenceChangeListener{
	private SharedPreferences sharedPrefs;
	private String muteKey;
	private String residencesKey;
	private String lastUpdatedKey;

	public SettingsManager(Context context){
		sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		sharedPrefs.registerOnSharedPreferenceChangeListener(this);
		Resources res = context.getResources();
		muteKey = res.getString(R.string.setting_mute_key);
		residencesKey = res.getString(R.string.setting_residences_key);
		lastUpdatedKey = res.getString(R.string.settings_last_updated_key);
	}
	
	public boolean isMuted(){
		return sharedPrefs.getBoolean(muteKey, false);
	}
	
	public boolean showResidences(){
		return sharedPrefs.getBoolean(residencesKey, true);
	}

    public long getLastUpdatedOn() {
		return sharedPrefs.getLong(lastUpdatedKey, 0);
	}

	public void setLastUpdatedOn(long lastUpdatedOn) {
		sharedPrefs.edit().putLong(lastUpdatedKey, lastUpdatedOn).commit();
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

	}

	
}
