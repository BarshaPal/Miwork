package com.example.miwork;

public class Word {
private String mMiWTranslation;
private String mDefaultTranslation;
private int mImage=IMAGE_PROVIDED;
    private static final int IMAGE_PROVIDED=-1;
private int mfirstint;
private int msecondint;
private int musicid;

 public Word(String MiWTranslation,String DefaultTranslation,int Image,int music)
 {
     mMiWTranslation=MiWTranslation;
     mDefaultTranslation=DefaultTranslation;
     mImage=Image;
     musicid=music;
 }
    public Word(String MiWTranslation,String DefaultTranslation,int music)
    {
        mMiWTranslation=MiWTranslation;
        mDefaultTranslation=DefaultTranslation;
        musicid=music;

    }
    public Word(int firstint,int secondint,int Image)
    {
        mImage=Image;
        mfirstint=firstint;
        msecondint=secondint;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }
    public String getmMiWTranslation()
    {
        return  mMiWTranslation;
    }
    public int getImage()
    {
        return  mImage;
    }
    public int getmusic(){
     return musicid;
    }
    public boolean hasimage()
    {
        return mImage!=IMAGE_PROVIDED;
    }


}
