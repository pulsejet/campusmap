package com.mrane.navigation;

import com.mrane.campusmap.R;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import com.mrane.campusmap.MapActivity;
import com.mrane.navigation.SlidingUpPanelLayout.PanelSlideListener;

public class CardSlideListener implements PanelSlideListener,
		ValueAnimator.AnimatorUpdateListener {
	private MapActivity mainActivity;
	private SlidingUpPanelLayout slidingLayout;
	private EndDetectScrollView scrollView;
	private ValueAnimator animator;

	private static final long TIME_ANIMATION_SHOW = 250;

	public CardSlideListener(MapActivity mainActivity) {
		this.mainActivity = mainActivity;
		slidingLayout = mainActivity.getSlidingLayout();
		scrollView = (EndDetectScrollView) mainActivity
				.findViewById(R.id.new_expanded_place_card_scroll);

		animator = new ValueAnimator();
		animator.addUpdateListener(this);
		Interpolator i = new Interpolator() {
	        public float getInterpolation(float t) {
	            t -= 1.0f;
	            return t * t * t * t * t + 1.0f;
	        }
	    };
		animator.setInterpolator(i);
	}

	@Override
	public void onPanelSlide(View panel, float slideOffset) {
//		setActionBarTranslation(slidingLayout.getCurrentParalaxOffset());
//		if(slideOffset >= slidingLayout.getAnchorPoint()){
//			mainActivity.getSupportActionBar().hide();
//		}
//		else{
//			mainActivity.getSupportActionBar().show();
//		}
	}

	@Override
	public void onPanelCollapsed(View panel) {
	}

	@Override
	public void onPanelExpanded(View panel) {
		scrollView.requestDisallowInterceptTouchEvent(false);
		scrollView.setScrollingEnabled(true);

    }

	@Override
	public void onPanelAnchored(View panel) {
		scrollView.requestDisallowInterceptTouchEvent(true);
		scrollView.setScrollingEnabled(false);
    }

	@Override
	public void onPanelHidden(View panel) {
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB) 
	public void setActionBarTranslation(float y) {
		// Figure out the actionbar height
		int actionBarHeight = mainActivity.getSupportActionBar().getHeight();
		// A hack to add the translation to the action bar
		ViewGroup content = ((ViewGroup) mainActivity.findViewById(
				android.R.id.content).getParent());
		int children = content.getChildCount();
		for (int i = 0; i < children; i++) {
			View child = content.getChildAt(i);
			if (child.getId() != android.R.id.content) {
				if (y <= -actionBarHeight) {
					child.setVisibility(View.GONE);
				} else {
					child.setVisibility(View.VISIBLE);
					child.setTranslationY(y);
				}
			}
		}
	}

	public void dismissCard() {
		animator.cancel();
		int initialPanelHeight = slidingLayout.getPanelHeight();
		int finalPanelHeight = 0;
		animator.setIntValues(initialPanelHeight, finalPanelHeight);
		animator.setDuration(TIME_ANIMATION_SHOW);
		animator.start();
	}

	public void showCard() {
		animator.cancel();
		int initialPanelHeight = slidingLayout.getPanelHeight();
		int finalPanelHeight = mainActivity.getResources()
				.getDimensionPixelSize(R.dimen.hidden_card_height);
		animator.setIntValues(initialPanelHeight, finalPanelHeight);
		animator.setDuration(TIME_ANIMATION_SHOW);
		animator.start();
	}

	@Override
	public void onAnimationUpdate(ValueAnimator animator) {
		int panelHeight = (Integer) animator.getAnimatedValue();
		slidingLayout.setPanelHeight(panelHeight);
	}

}
