package com.istone.dialoglibrary.view;

import com.istone.dialoglibrary.config.ChooseBean;
import com.istone.dialoglibrary.config.ConfigBean;
import com.istone.dialoglibrary.interfaces.MyCheckBoxItemDialogListener;
import com.istone.dialoglibrary.interfaces.MyDialogListener;
import com.istone.dialoglibrary.interfaces.MyItemDialogListener;
import ohos.app.Context;

import java.util.ArrayList;

/**
 * description styledialog
 *
 * @author baihe
 * created 2021/2/25 8:23
 */
public class StyledDialog {

    /**
     * @param context  context
     * @param title    对话框的title
     * @param msg      对话框的提示信息
     * @param listener 对话框 ok 和 cancle 的点击监听事件
     * @return configbean
     */
    public static ConfigBean buildMdAlert(Context context, CharSequence title, CharSequence msg,
                                          MyDialogListener listener) {
        return DialogAssigner.getInstance().assignMdAlert(context, title, msg, listener);
    }

    /**
     * @param context  context
     * @param title    对话框的title
     * @param msg      对话框的提示信息
     * @param listener 对话框 ok 和 cancle 的点击监听事件
     * @return configbean
     */
    public static ConfigBean buildMdIOSAlert(Context context, CharSequence title, CharSequence msg,
                                             MyDialogListener listener) {
        return DialogAssigner.getInstance().assignMdIOSAlert(context, title, msg, listener);
    }

    /**
     * @param context  context
     * @param title    对话框的title
     * @param msg      对话框的提示信息
     * @param listener 对话框 ok 和 cancle 的点击监听事件
     * @return configbean
     */
    public static ConfigBean buildMdIOSAlertVertical(Context context, CharSequence title, CharSequence msg,
                                                     MyDialogListener listener) {
        return DialogAssigner.getInstance().assignMdIOSAlertVertical(context, title, msg, listener);
    }

    /**
     * @param context  context
     * @param title    对话框的title
     * @param list     list
     * @param listener 单项的item 和ok cancle 的点击事件的监听
     * @return configbean
     */
    public static ConfigBean buildMdSingleChoose(Context context, CharSequence title, ArrayList<ChooseBean> list,
                                                 MyItemDialogListener listener) {
        return DialogAssigner.getInstance().assignMdSingleChoose(context, title, list, listener);
    }


    public static ConfigBean buildMdSingleMenuChoose(Context context , ArrayList<ChooseBean> list,
                                                     int x, int y, int menuWidth,int menuHeight,MyItemDialogListener listener) {
        return DialogAssigner.getInstance().assignMdIOSSingleMenuChoose(context, list, x, y,menuWidth,menuHeight, listener);
    }


    /**
     * @param context  context
     * @param list     list
     * @param listener 单项的item 和ok cancle 的点击事件的监听
     * @return configbean
     */
    public static ConfigBean buildMdIOSSingleChoose(Context context, ArrayList<ChooseBean> list,
                                                    MyItemDialogListener listener) {
        return DialogAssigner.getInstance().assignMdIOSSingleChoose(context, list, listener);
    }

    /**
     * @param context  context
     * @param list     list
     * @param listener list  item 的点击事件
     * @return
     */
    public static ConfigBean buildMdIOSList(Context context, ArrayList<ChooseBean> list,
                                            MyItemDialogListener listener) {
        return DialogAssigner.getInstance().assignMdIOSList(context, list, listener);
    }

    /**
     * @param context  context
     * @param list     list
     * @param listener 单项的item 和ok cancle 的点击事件的监听
     * @return configbean
     */
    public static ConfigBean buildMdIOSBottomSingleChoose(Context context, ArrayList<ChooseBean> list,
                                                          MyItemDialogListener listener) {
        return DialogAssigner.getInstance().assignMdIOSBottomSingleChoose(context, list, listener);
    }

    /**
     * @param context     context
     * @param title       对话框的title
     * @param list        list
     * @param btnListener ok cancle 的点击监听事件
     * @return configbean
     */
    public static ConfigBean buildMdMultiChoose(Context context, CharSequence title, ArrayList<ChooseBean> list,
                                                MyCheckBoxItemDialogListener btnListener) {
        return DialogAssigner.getInstance().assignMdMultiChoose(context, title, list, btnListener);
    }

    /**
     * @param context  context
     * @param title    对话框的title
     * @param hint1    输入框的hint 文字提示信息
     * @param listener ok cancle 的点击监听事件
     * @return configbean
     */
    public static ConfigBean buildNormalInput(Context context, CharSequence title, CharSequence hint1,
                                              MyDialogListener listener) {
        return DialogAssigner.getInstance().assignNormalInput(context, title, hint1, listener);
    }


    /**
     * @param context  context
     * @param title    对话框title
     * @param hint1    第一个输入框的提示信息
     * @param hint2    第二个输入框的提示信息
     * @param listener ok cancle 的点击监听事件
     * @return ConfigBean
     */
    public static ConfigBean buildTwoInput(Context context, CharSequence title, CharSequence hint1, CharSequence hint2,
                                           MyDialogListener listener) {
        return DialogAssigner.getInstance().assignTwoInput(context, title, hint1, hint2, listener);
    }


}
