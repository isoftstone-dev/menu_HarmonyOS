package com.istone.dialoglibrary.config;

import com.istone.dialoglibrary.building.MyDialogBuilder;
import com.istone.dialoglibrary.interfaces.MyCheckBoxItemDialogListener;
import com.istone.dialoglibrary.interfaces.MyDialogListener;
import com.istone.dialoglibrary.interfaces.MyItemDialogListener;
import com.istone.dialoglibrary.interfaces.Styleable;
import ohos.agp.window.dialog.CommonDialog;
import ohos.app.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * description configbean
 *
 * @author baihe
 * created 2021/2/25 9:40
 */
public class ConfigBean extends MyDialogBuilder implements Styleable {
    /**
     * type
     */
    public int type;
    /**
     * context
     */
    public Context context;
    /**
     * msg
     */
    public CharSequence msg;
    /**
     * title
     */
    public CharSequence title;
    /**
     * listener
     */
    public MyDialogListener listener;
    /**
     * itemListener
     */
    public MyItemDialogListener itemListener;

    /**
     * dialog 的x坐标
     */
    public int x;
    /**
     * dialog 的y坐标
     */
    public int y;

    public int menuWidth;
    public int menuHeight;

    public String getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(String selectItem) {
        this.selectItem = selectItem;
    }

    public String selectItem;
    /**
     * checkBoxItemDialogListener
     */
    public MyCheckBoxItemDialogListener checkBoxItemDialogListener;
    /**
     * words
     */
    public CharSequence[] words;
    /**
     * hint1
     */
    public CharSequence hint1;
    /**
     * hint2
     */
    public CharSequence hint2;


    /**
     * @return inputText1
     */
    public CharSequence getInputText1() {
        return inputText1;
    }

    /**
     * @param inputText1 inputText1
     */
    public void setInputText1(CharSequence inputText1) {
        this.inputText1 = inputText1;
    }

    /**
     * inputText1
     */
    public CharSequence inputText1;

    public CharSequence getInputText2() {
        return inputText2;
    }

    public void setInputText2(CharSequence inputText2) {
        this.inputText2 = inputText2;
    }

    /**
     * inputText2
     */
    public CharSequence inputText2;
    /**
     * defaultChosen
     */
    public int defaultChosen;//
    /**
     * chooseBeans
     */
    public List<ChooseBean> chooseBeans = new ArrayList<>();
    /**
     * checkedItems
     */
    public boolean[] checkedItems;

    public CommonDialog commonDialog;

    public ConfigBean(){

    }

    @Override
    public CommonDialog show() {
        return null;
    }
}
