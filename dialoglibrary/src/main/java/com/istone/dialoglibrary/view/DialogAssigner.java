package com.istone.dialoglibrary.view;

import com.istone.dialoglibrary.interfaces.Assignable;
import com.istone.dialoglibrary.config.ChooseBean;
import com.istone.dialoglibrary.config.ConfigBean;
import com.istone.dialoglibrary.config.DefaultConfig;
import com.istone.dialoglibrary.interfaces.MyCheckBoxItemDialogListener;
import com.istone.dialoglibrary.interfaces.MyDialogListener;
import com.istone.dialoglibrary.interfaces.MyItemDialogListener;
import ohos.app.Context;
import java.util.ArrayList;

/**
 * description DialogAssigner
 *
 * @author baihe
 * created 2021/2/25 9:56
 */
public class DialogAssigner implements Assignable {


    /**
     *
     */
    private static DialogAssigner instance;

    /**
     *
     */
    private DialogAssigner() {

    }

    /**
     *
     */
    public static DialogAssigner getInstance() {
        if (instance == null) {
            instance = new DialogAssigner();
        }
        return instance;
    }


    @Override
    public ConfigBean assignMdAlert(Context context, CharSequence title, CharSequence msg, MyDialogListener listener) {

        ConfigBean bean = new ConfigBean();
        bean.context = context;

        bean.msg = msg;
        bean.title = title;
        bean.listener = listener;
        bean.type = DefaultConfig.ALERT_DIALOG;
        bean.buildByType(bean);
        return bean;
    }

    @Override
    public ConfigBean assignMdIOSAlert(Context context, CharSequence title, CharSequence msg, MyDialogListener listener) {

        ConfigBean bean = new ConfigBean();
        bean.context = context;

        bean.msg = msg;
        bean.title = title;
        bean.listener = listener;
        bean.type = DefaultConfig.IOS_ALERT_DIALOG;
        bean.buildByType(bean);
        return bean;
    }

    @Override
    public ConfigBean assignMdIOSAlertVertical(Context context, CharSequence title, CharSequence msg, MyDialogListener listener) {

        ConfigBean bean = new ConfigBean();
        bean.context = context;

        bean.msg = msg;
        bean.title = title;
        bean.listener = listener;
        bean.type = DefaultConfig.IOS_VERTICAL_ALERT_DIALOG;
        bean.buildByType(bean);
        return bean;
    }

    @Override
    public ConfigBean assignNormalInput(Context context, CharSequence title, CharSequence hint1,
                                        MyDialogListener listener) {
        ConfigBean bean = new ConfigBean();
        bean.context = context;
        bean.listener = listener;
        bean.title = title;
        bean.hint1 = hint1;
        bean.type = DefaultConfig.INPUT_DIALOG;
        bean.buildByType(bean);
        return bean;
    }

    @Override
    public ConfigBean assignTwoInput(Context context, CharSequence title, CharSequence hint1,CharSequence hint2,
                                        MyDialogListener listener) {
        ConfigBean bean = new ConfigBean();
        bean.context = context;
        bean.listener = listener;
        bean.title = title;
        bean.hint1 = hint1;
        bean.hint2 = hint2;
        bean.type = DefaultConfig.TWO_INPUT_DIALOG;
        bean.buildByType(bean);
        return bean;
    }

    @Override
    public ConfigBean assignMdSingleChoose(Context context, CharSequence title, ArrayList<ChooseBean> list,
                                           MyItemDialogListener listener) {
        ConfigBean bean = new ConfigBean();
        bean.context = context;
        bean.title = title;
        bean.itemListener = listener;
        bean.type = DefaultConfig.SINGLE_DIALOG;
        bean.chooseBeans.addAll(list);
        bean.buildByType(bean);
        return bean;
    }

    @Override
    public ConfigBean assignMdIOSSingleMenuChoose(Context context, ArrayList<ChooseBean> list, int x, int y, int menuWidth,int menuHeight,
                                                  MyItemDialogListener listener) {

        ConfigBean bean = new ConfigBean();
        bean.context = context;
        bean.itemListener = listener;
        bean.type = DefaultConfig.SINGLE_MENU_DIALOG;
        bean.chooseBeans.addAll(list);
        bean.x = x;
        bean.y = y;
        bean.menuWidth = menuWidth;
        bean.menuHeight = menuHeight;
        bean.buildByType(bean);
        return bean;
    }


    @Override
    public ConfigBean assignMdIOSSingleChoose(Context context, ArrayList<ChooseBean> list,

                                           MyItemDialogListener listener) {
        ConfigBean bean = new ConfigBean();
        bean.context = context;
        bean.itemListener = listener;
        bean.type = DefaultConfig.IOS_SINGLE_DIALOG;
        bean.chooseBeans.addAll(list);
        bean.buildByType(bean);
        return bean;
    }


    @Override
    public ConfigBean assignMdIOSBottomSingleChoose(Context context, ArrayList<ChooseBean> list,
                                              MyItemDialogListener listener) {
        ConfigBean bean = new ConfigBean();
        bean.context = context;
        bean.itemListener = listener;
        bean.type = DefaultConfig.IOS_BOTTOM_SINGLE_DIALOG;
        bean.chooseBeans.addAll(list);
        bean.buildByType(bean);
        return bean;
    }

    @Override
    public ConfigBean assignMdIOSList(Context context, ArrayList<ChooseBean> list,
                                                    MyItemDialogListener listener) {
        ConfigBean bean = new ConfigBean();
        bean.context = context;
        bean.itemListener = listener;
        bean.type = DefaultConfig.IOS_LIST_DIALOG;
        bean.chooseBeans.addAll(list);
        bean.buildByType(bean);
        return bean;
    }

    @Override
    public ConfigBean assignMdMultiChoose(Context context, CharSequence title, ArrayList<ChooseBean> list,
                                          MyCheckBoxItemDialogListener checkboxListener) {
        ConfigBean bean = new ConfigBean();
        bean.context = context;
        bean.msg = title;
        bean.title = title;
        bean.checkBoxItemDialogListener = checkboxListener;
        bean.type = DefaultConfig.MULTI_DIALOG;
        bean.chooseBeans.addAll(list);
        bean.buildByType(bean);

        return bean;
    }

}
