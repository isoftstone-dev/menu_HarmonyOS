package com.istone.dialoglibrary.config;


/**
 * description ChooseBean
 *
 * @author baihe
 * created 2021/2/25 9:43
 */
public class ChooseBean {
    /**
     * txt
     */
    private CharSequence txt;
    /**
     * choosen
     */
    private boolean choosen;

    public CharSequence getTxt() {
        return txt;
    }

    public void setTxt(CharSequence txt) {
        this.txt = txt;
    }

    public boolean isChoosen() {
        return choosen;
    }

    public void setChoosen(boolean choosen) {
        this.choosen = choosen;
    }
}
