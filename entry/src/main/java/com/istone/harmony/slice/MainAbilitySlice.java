package com.istone.harmony.slice;

import com.istone.dialoglibrary.config.ChooseBean;
import com.istone.harmony.ResourceTable;
import com.istone.dialoglibrary.config.ConfigBean;
import com.istone.dialoglibrary.interfaces.MyCheckBoxItemDialogListener;
import com.istone.dialoglibrary.interfaces.MyDialogListener;
import com.istone.dialoglibrary.interfaces.MyItemDialogListener;
import com.istone.dialoglibrary.view.StyledDialog;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Checkbox;
import ohos.agp.window.dialog.ToastDialog;

import java.util.ArrayList;

/**
 * description mainabilityslice
 *
 * @author baihe
 * created 2021/2/25 10:19
 */
public class MainAbilitySlice extends AbilitySlice {
    /**
     * configbean
     */
    ConfigBean configBean = null;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        String[] per = {"ohos.permission.WRITE_SETTINGS", "ohos.permission.MODIFY_AUDIO_SETTINGS",
                "ohos.permission.MODIFY_SETTINGS", "ohos.permission.MANAGE_SECURE_SETTINGS", "android.permission" +
                ".WRITE_SETTINGS"};
        requestPermissionsFromUser(per, 0);
        initView();


    }


    private void initView() {
        Button alertButton = (Button) findComponentById(ResourceTable.Id_alert_button);
        Button inputButton = (Button) findComponentById(ResourceTable.Id_input_button);
        Button singleButton = (Button) findComponentById(ResourceTable.Id_single_button);
        Button multiButton = (Button) findComponentById(ResourceTable.Id_multi_button);
        Button iosAlertButton = (Button) findComponentById(ResourceTable.Id_ios_alert_button);
        Button iosVerticalAlertButton = (Button) findComponentById(ResourceTable.Id_ios_alert_button_vertical);
        Button twoInputButton = (Button) findComponentById(ResourceTable.Id_two_input_button);
        Button iosSingleChooseButton = (Button) findComponentById(ResourceTable.Id_ios_single_choose_button);
        Button iosBottomSingleChooseButton =
                (Button) findComponentById(ResourceTable.Id_ios_bottom_single_choose_button);
        Button iosBottomListButton = (Button) findComponentById(ResourceTable.Id_ios_bottom_list_button);
        Button menuSingleButton = (Button) findComponentById(ResourceTable.Id_menu_single_button);
        alertButton.setClickedListener(component -> {
            configBean = StyledDialog.buildMdAlert(getContext(), "提示", "确定退出？", new MyDialogListener() {
                @Override
                public void positiveButton() {
//                    configBean.commonDialog.hide();
//                    configBean.commonDialog = null;

                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });


            configBean.commonDialog.show();
        });


        iosAlertButton.setClickedListener(component -> {
            configBean = StyledDialog.buildMdIOSAlert(getContext(), "提示", "确定退出？", new MyDialogListener() {
                @Override
                public void positiveButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;

                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });


            configBean.commonDialog.show();
        });

        iosVerticalAlertButton.setClickedListener(component -> {
            configBean = StyledDialog.buildMdIOSAlertVertical(getContext(), "提示", "确定退出？", new MyDialogListener() {
                @Override
                public void positiveButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;

                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });


            configBean.commonDialog.show();
        });

        inputButton.setClickedListener(component -> {
            configBean = StyledDialog.buildNormalInput(getContext(), "请输入您的昵称", "长度0-20", new MyDialogListener() {

                @Override
                public void positiveButton() {
                    //可对输入内容进行校验
                    configBean.getInputText1();
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });
            configBean.commonDialog.show();

        });

        twoInputButton.setClickedListener(component -> {
            configBean = StyledDialog.buildTwoInput(getContext(), "登录", "请输入用户名", "请输入密码", new MyDialogListener() {

                @Override
                public void positiveButton() {
                    //可对输入内容进行校验
                    configBean.getInputText1();
                    configBean.getInputText2();
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });
            configBean.commonDialog.show();

        });

        singleButton.setClickedListener(component -> {
            CharSequence[] words = {"身份证", "手机", "钥匙", "钱包"};
            boolean[] selectItems = {true, false, false, false};

            ArrayList<ChooseBean> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                ChooseBean chooseBean = new ChooseBean();
                chooseBean.setTxt(words[i]);
                chooseBean.setChoosen(selectItems[i]);
                list.add(chooseBean);
            }
            configBean = StyledDialog.buildMdSingleChoose(getContext(), "单选", list, new MyItemDialogListener() {
                @Override
                public void onItemClick(CharSequence text, int position) {
                    configBean.commonDialog.hide();
                }

                @Override
                public void positiveButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;

                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });
            configBean.commonDialog.show();
        });


        iosSingleChooseButton.setClickedListener(component -> {
            CharSequence[] words = {"身份证", "手机", "钥匙", "钱包"};
            boolean[] selectItems = {true, false, false, false};

            ArrayList<ChooseBean> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                ChooseBean chooseBean = new ChooseBean();
                chooseBean.setTxt(words[i]);
                chooseBean.setChoosen(selectItems[i]);
                list.add(chooseBean);
            }
            configBean = StyledDialog.buildMdIOSSingleChoose(getContext(), list, new MyItemDialogListener() {
                @Override
                public void onItemClick(CharSequence text, int position) {
                    new ToastDialog(getContext()).setText(text.toString()).show();

                }

                @Override
                public void positiveButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;

                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });
            configBean.commonDialog.show();
        });

        menuSingleButton.setClickedListener(component -> {
            CharSequence[] words = {"身份证", "手机", "钥匙", "钱包"};
            boolean[] selectItems = {true, false, false, false};

            ArrayList<ChooseBean> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                ChooseBean chooseBean = new ChooseBean();
                chooseBean.setTxt(words[i]);
                chooseBean.setChoosen(selectItems[i]);
                list.add(chooseBean);
            }

            configBean = StyledDialog.buildMdSingleMenuChoose(getContext(), list, 100, 100, 400,650,new MyItemDialogListener() {
                @Override
                public void onItemClick(CharSequence text, int position) {
//                    new ToastDialog(getContext()).setText(text.toString()).show();

                }

                @Override
                public void positiveButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;

                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });
            configBean.commonDialog.show();
        });

        iosBottomSingleChooseButton.setClickedListener(component -> {
            CharSequence[] words = {"身份证", "手机", "钥匙", "钱包"};
            boolean[] selectItems = {true, false, false, false};

            ArrayList<ChooseBean> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                ChooseBean chooseBean = new ChooseBean();
                chooseBean.setTxt(words[i]);
                chooseBean.setChoosen(selectItems[i]);
                list.add(chooseBean);
            }
            configBean = StyledDialog.buildMdIOSBottomSingleChoose(getContext(), list, new MyItemDialogListener() {
                @Override
                public void onItemClick(CharSequence text, int position) {
                    new ToastDialog(getContext()).setText(text.toString()).show();

                }

                @Override
                public void positiveButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;

                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });
            configBean.commonDialog.show();
        });

        iosBottomListButton.setClickedListener(component -> {
            CharSequence[] words = {"身份证", "手机", "钥匙", "钱包"};
            boolean[] selectItems = {true, false, false, false};

            ArrayList<ChooseBean> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                ChooseBean chooseBean = new ChooseBean();
                chooseBean.setTxt(words[i]);
                chooseBean.setChoosen(selectItems[i]);
                list.add(chooseBean);
            }
            configBean = StyledDialog.buildMdIOSList(getContext(), list, new MyItemDialogListener() {
                @Override
                public void onItemClick(CharSequence text, int position) {
                    new ToastDialog(getContext()).setText(text.toString()).show();

                }

                @Override
                public void positiveButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;

                }

                @Override
                public void negativeButton() {
                    configBean.commonDialog.hide();
                    configBean.commonDialog = null;
                }
            });
            configBean.commonDialog.show();
        });


        multiButton.setClickedListener(component -> {
            CharSequence[] words = {"A.apple", "B.bananer", "C.pear", "D.milk"};
            boolean[] checkedItems = {false, false, false, false};

            ArrayList<ChooseBean> list = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                ChooseBean chooseBean = new ChooseBean();
                chooseBean.setTxt(words[i]);
                chooseBean.setChoosen(checkedItems[i]);
                list.add(chooseBean);
            }
            configBean = StyledDialog.buildMdMultiChoose(getContext(), "多选", list,
                    new MyCheckBoxItemDialogListener() {
                        @Override
                        public void onItemClick(Checkbox checkbox, int position) {
                            checkedItems[position] = checkbox.isChecked();
                        }

                        @Override
                        public void positiveButton() {
                            configBean.commonDialog.hide();
                            configBean.commonDialog = null;

                        }

                        @Override
                        public void negativeButton() {
                            configBean.commonDialog.hide();
                            configBean.commonDialog = null;
                        }
                    });
            configBean.commonDialog.show();

        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
