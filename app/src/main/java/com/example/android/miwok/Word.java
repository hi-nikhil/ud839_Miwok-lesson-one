package com.example.android.miwok;

public class Word {
    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image Resourse Id for the word */
    private int mImageResourceId=No_Image;

    private static  final  int No_Image=-1;

    /** Audio resource Id for the word*/

    private  int mAudioResourceId;


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation ,int audioResourceId ) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId=audioResourceId;
    }


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     *
     * @param imageResourceId is the image id  of the word
     */
    public Word(String defaultTranslation, String miwokTranslation,int imageResourceId,int audioResourceId ) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId=imageResourceId;
        mAudioResourceId=audioResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Returns the resource id  of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns there is image or not.
     *
     */
    public  boolean hasImage(){
        return mImageResourceId!=No_Image;
    }


    /**
            * Returns Id of Audio.
            *
            */
    public int getmAudioResourceId(){
        return  mAudioResourceId;
    }

}
