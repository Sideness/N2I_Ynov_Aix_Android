package com.company.n2i.refugees;

import android.app.Application;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.Locale;

/**
 * Created by julien on 01/12/16.
 */

public class TextToSpeechHelper implements OnInitListener {

    private static TextToSpeech mTts;
    private String text;
    private static final TextToSpeechHelper instance = new TextToSpeechHelper();

    public static TextToSpeechHelper getInstance(){
        return instance;
    }


    public void say(String text, Context context){

        if(mTts == null){
            this.text = text;
            mTts = new TextToSpeech(context, (OnInitListener) instance);

        }
        else{
            mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }


    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            mTts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void stopTTS(){
        if(mTts != null){
            mTts.shutdown();
            mTts.stop();
            mTts = null;
        }
    }

}
