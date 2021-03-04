package com.istone.dialoglibrary.interfaces;

import com.istone.dialoglibrary.config.ChooseBean;
import com.istone.dialoglibrary.config.ConfigBean;
import ohos.app.Context;

import java.util.ArrayList;

/**
 * description assignable
 *
 * @author baihe
 * created 2021/2/22 11:53
 */
public interface Assignable {


    /**
     * @param context  context
     * @param title    title
     * @param msg      alert dialog message
     * @param listener alert dialog ok cancle button click listener
     * @return ConfigBean
     */
    ConfigBean assignMdAlert(Context context, CharSequence title, CharSequence msg, final MyDialogListener listener);

    /**
     * @param context  context
     * @param title    title
     * @param msg      alert dialog message
     * @param listener alert dialog ok cancle button click listener
     * @return ConfigBean
     */
    ConfigBean assignMdIOSAlert(Context context, CharSequence title, CharSequence msg, final MyDialogListener listener);

    /**
     * @param context  context
     * @param title    title
     * @param msg      alert dialog message
     * @param listener alert dialog ok cancle button click listener
     * @return ConfigBean
     */
    ConfigBean assignMdIOSAlertVertical(Context context, CharSequence title, CharSequence msg, final MyDialogListener listener);

    /**
     * @param context  context
     * @param title    title
     * @param list     list
     * @param listener 单选按钮 item ok cancle button click listener
     * @return ConfigBean
     */
    ConfigBean assignMdSingleChoose(Context context, CharSequence title, ArrayList<ChooseBean> list,
                                    MyItemDialogListener listener);

    /**
     * @param context  context
     * @param list     list
     * @param listener 单选按钮 item ok cancle button click listener
     * @return ConfigBean
     */
    ConfigBean assignMdIOSSingleChoose(Context context, ArrayList<ChooseBean> list,
                                    MyItemDialogListener listener);

    /**
     * @param context  context
     * @param list     list
     * @param listener 单选按钮 item ok cancle button click listener
     * @return ConfigBean
     */
    ConfigBean assignMdIOSSingleMenuChoose(Context context, ArrayList<ChooseBean> list,int x,int y, int menuWidth,int menuHeight,
                                       MyItemDialogListener listener);

    /**
     * @param context  context
     * @param list     list
     * @param listener 单选按钮 item ok cancle button click listener
     * @return ConfigBean
     */
    ConfigBean assignMdIOSBottomSingleChoose(Context context, ArrayList<ChooseBean> list,
                                             MyItemDialogListener listener);



    /**
     * @param context  context
     * @param list     list
     * @param listener 单选按钮 item ok cancle button click listener
     * @return ConfigBean
     */
    ConfigBean assignMdIOSList(Context context, ArrayList<ChooseBean> list,
                                             MyItemDialogListener listener);
    /**
     * @param context          context
     * @param title            title
     * @param list             list
     * @param checkboxListener item ok cancle 的clicl listener
     * @return ConfigBean
     */
    ConfigBean assignMdMultiChoose(Context context, CharSequence title, ArrayList<ChooseBean> list,
                                   final MyCheckBoxItemDialogListener checkboxListener);

    /**
     * @param context  context
     * @param title    title
     * @param hint1    TextFiled 的提示信息
     * @param listener ok  cancle click listener
     * @return ConfigBean
     */
    ConfigBean assignNormalInput(Context context, CharSequence title, CharSequence hint1,
                                 final MyDialogListener listener);


    ConfigBean assignTwoInput(Context context, CharSequence title, CharSequence hint1,CharSequence hint2,
                                 final MyDialogListener listener);

}
