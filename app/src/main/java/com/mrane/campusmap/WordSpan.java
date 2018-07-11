package com.mrane.campusmap;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class WordSpan extends ClickableSpan 
{

    private int id;
    private TextPaint textpaint;
    public boolean shouldHilightWord = false;

    @Override
    public void updateDrawState(TextPaint ds) {
        textpaint = ds;
        ds.setColor(ds.linkColor);
        if(shouldHilightWord){
            textpaint.bgColor = Color.GRAY;         
            textpaint.setARGB(255, 255, 255, 255);

        }
        //Remove default underline associated with spans
        ds.setUnderlineText(false);

    }

    @Override
    public void onClick(View widget) {

        // TODO Auto-generated method stub

    }


}