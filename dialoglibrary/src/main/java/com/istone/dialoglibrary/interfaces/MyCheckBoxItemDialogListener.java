package com.istone.dialoglibrary.interfaces;

import ohos.agp.components.Checkbox;

/**
 * description  checkbox 的点击事件监听
 *
 * @author baihe
 * created 2021/2/24 17:14
 */
public interface MyCheckBoxItemDialogListener {

    /**
     * @param checkbox
     * @param position
     */
    public void onItemClick(Checkbox checkbox, int position);

    /**
     * md-positive button ,ios-first button
     */
    public void positiveButton();//

    /**
     * md-negative button,ios-second
     */
    public void negativeButton();//
}
