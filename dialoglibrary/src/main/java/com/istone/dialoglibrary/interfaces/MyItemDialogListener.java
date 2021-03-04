package com.istone.dialoglibrary.interfaces;

/**
*description MyItemDialogListener
*@author baihe
*created 2021/2/25 9:43
*
*/
public interface  MyItemDialogListener {

    /**
     * IosSingleChoose,BottomItemDialog的点击条目回调
     * @param text text
     * @param position position
     */
    public  void onItemClick(CharSequence text, int position);

    /**
     * md-positive button ,ios-first button
     */
    public void positiveButton();//

    /**
     * md-negative button,ios-second
     */
    public  void negativeButton();//
}
