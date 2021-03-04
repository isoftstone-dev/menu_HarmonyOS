package com.istone.dialoglibrary.building;

import com.istone.dialoglibrary.LogUtils;
import com.istone.dialoglibrary.ResourceTable;
import com.istone.dialoglibrary.config.ChooseBean;
import com.istone.dialoglibrary.config.ConfigBean;
import com.istone.dialoglibrary.config.DefaultConfig;
import com.istone.dialoglibrary.providers.SingleChooseProviders;
import ohos.agp.components.Button;
import ohos.agp.components.Checkbox;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.ComponentState;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.ListContainer;
import ohos.agp.components.RadioButton;
import ohos.agp.components.RadioContainer;
import ohos.agp.components.Text;
import ohos.agp.components.TextField;
import ohos.agp.components.element.PixelMapElement;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.components.element.StateElement;
import ohos.agp.utils.Rect;
import ohos.agp.window.dialog.CommonDialog;
import ohos.global.resource.NotExistException;
import ohos.global.resource.Resource;
import ohos.media.player.Player;

import java.io.IOException;

/**
 * description dialogbuilder
 *
 * @author baihe
 * created 2021/2/25 16:02
 */
public class MyDialogBuilder {


    /**
     * 根据dialog类型，生成不同类型的dialog
     *
     * @param bean bean
     * @return configbean
     */
    public ConfigBean buildByType(ConfigBean bean) {

        switch (bean.type) {
            case DefaultConfig.ALERT_DIALOG:
                buildMdAlert(bean);

                break;
            case DefaultConfig.INPUT_DIALOG:
                buildMdInput(bean);

                break;
            case DefaultConfig.SINGLE_DIALOG:
                buildMdSingleChoose(bean);

                break;
            case DefaultConfig.MULTI_DIALOG:
                buildMdMultiChoose(bean);
                break;
            case DefaultConfig.IOS_ALERT_DIALOG:
                buildIOSAlert(bean);
                break;
            case DefaultConfig.IOS_VERTICAL_ALERT_DIALOG:
                buildIOSAlertVertical(bean);
                break;
            case DefaultConfig.TWO_INPUT_DIALOG:
                builtTwoInput(bean);
                break;
            case DefaultConfig.IOS_SINGLE_DIALOG:
                builtIosSingleChoose(bean);
                break;
            case DefaultConfig.IOS_BOTTOM_SINGLE_DIALOG:
            builtBottomIosSingleChoose(bean);
            break;

            case DefaultConfig.IOS_LIST_DIALOG:
                builtBottomIosList(bean);
                break;
            case DefaultConfig.SINGLE_MENU_DIALOG:
                builtIosSingleMenuChoose(bean);

                break;
            default:
                break;
        }
        return bean;
    }

    /**
     * 生成alert dialog
     *
     * @param bean bean
     * @return ConfigBean
     */
    protected ConfigBean buildMdAlert(final ConfigBean bean) {
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component = LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_alert_dialog_layout,
                null, false);
        commonDialog.setContentCustomComponent(component);
        commonDialog.setTransparent(true);
        Text titleTV = (Text) component.findComponentById(ResourceTable.Id_alert_dialog_title);
        titleTV.setText(bean.title.toString());
        Text messageTV = (Text) component.findComponentById(ResourceTable.Id_alert_dialog_message);
        messageTV.setText(bean.msg.toString());
        Button ok = (Button) component.findComponentById(ResourceTable.Id_alert_dialog_ok);
        ok.setClickedListener(component1 -> {
            bean.listener.positiveButton();
        });
        Button cancle = (Button) component.findComponentById(ResourceTable.Id_alert_dialog_cancle);
        cancle.setClickedListener(component1 -> {
            bean.listener.negativeButton();
        });
        bean.commonDialog = commonDialog;
        return bean;
    }

    protected ConfigBean buildIOSAlert(final ConfigBean bean) {
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_alert_dialog_layout_for_ios,
                null, false);
        commonDialog.setContentCustomComponent(component);
        commonDialog.setTransparent(true);
        Text titleTV = (Text) component.findComponentById(ResourceTable.Id_ios_alert_dialog_title);
        titleTV.setText(bean.title.toString());
        Text messageTV = (Text) component.findComponentById(ResourceTable.Id_ios_alert_dialog_message);
        messageTV.setText(bean.msg.toString());
        ShapeElement selectElement = new ShapeElement(bean.context, ResourceTable.Graphic_ios_button_background_select);
        ShapeElement emptyElement = new ShapeElement(bean.context,
                ResourceTable.Graphic_ios_button_background_unselect);

        StateElement okCheckElement = new StateElement();
        okCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_PRESSED}, selectElement);
        okCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);

        Button ok = (Button) component.findComponentById(ResourceTable.Id_ios_alert_dialog_ok);
        ok.setBackground(okCheckElement);
        ok.setClickedListener(component1 -> {
            bean.listener.positiveButton();
        });
        Button cancle = (Button) component.findComponentById(ResourceTable.Id_ios_alert_dialog_cancle);
        StateElement cancleCheckElement = new StateElement();
        cancleCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_PRESSED}, selectElement);
        cancleCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);
        cancle.setBackground(cancleCheckElement);
        cancle.setClickedListener(component1 -> {
            bean.listener.negativeButton();
        });
        Button thinkabout = (Button) component.findComponentById(ResourceTable.Id_ios_alert_dialog_thinkabout);
        StateElement thinkAboutCheckElement = new StateElement();
        thinkAboutCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_PRESSED}, selectElement);
        thinkAboutCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);
        thinkabout.setBackground(thinkAboutCheckElement);
        thinkabout.setClickedListener(component1 -> {
            commonDialog.hide();
        });


        bean.commonDialog = commonDialog;
        return bean;
    }

    protected ConfigBean buildIOSAlertVertical(final ConfigBean bean) {
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_alert_dialog_layout_for_ios_vertical,
                        null, false);
        commonDialog.setContentCustomComponent(component);
        commonDialog.setTransparent(true);
        Text titleTV = (Text) component.findComponentById(ResourceTable.Id_ios_vertical_alert_dialog_title);
        titleTV.setText(bean.title.toString());
        Text messageTV = (Text) component.findComponentById(ResourceTable.Id_ios_vertical_alert_dialog_message);
        messageTV.setText(bean.msg.toString());
        ShapeElement selectElement = new ShapeElement(bean.context, ResourceTable.Graphic_ios_button_background_select);
        ShapeElement emptyElement = new ShapeElement(bean.context,
                ResourceTable.Graphic_ios_button_background_unselect);

        StateElement okCheckElement = new StateElement();
        okCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_PRESSED}, selectElement);
        okCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);

        Button ok = (Button) component.findComponentById(ResourceTable.Id_ios_vertical_alert_dialog_ok);
        ok.setBackground(okCheckElement);
        ok.setClickedListener(component1 -> {
            bean.listener.positiveButton();
        });
        Button cancle = (Button) component.findComponentById(ResourceTable.Id_ios_vertical_alert_dialog_cancle);
        StateElement cancleCheckElement = new StateElement();
        cancleCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_PRESSED}, selectElement);
        cancleCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);
        cancle.setBackground(cancleCheckElement);
        cancle.setClickedListener(component1 -> {
            bean.listener.negativeButton();
        });
        Button thinkabout = (Button) component.findComponentById(ResourceTable.Id_ios_vertical_alert_dialog_thinkabout);
        StateElement thinkAboutCheckElement = new StateElement();
        thinkAboutCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_PRESSED}, selectElement);
        thinkAboutCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);
        thinkabout.setBackground(thinkAboutCheckElement);
        thinkabout.setClickedListener(component1 -> {
            commonDialog.hide();
        });


        bean.commonDialog = commonDialog;
        return bean;
    }

    /**
     * 生成input dialog
     *
     * @param bean bean
     * @return ConfigBean
     */
    protected ConfigBean buildMdInput(final ConfigBean bean) {

        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_input_dialog_layout, null,
                        false);
        commonDialog.setContentCustomComponent(component);
        commonDialog.setTransparent(true);
        Text titleTV = (Text) component.findComponentById(ResourceTable.Id_input_dialog_title);
        titleTV.setText(bean.title.toString());
        TextField messageTV = (TextField) component.findComponentById(ResourceTable.Id_input_dialog_text_field);


        messageTV.setHint(bean.hint1.toString());
        Button ok = (Button) component.findComponentById(ResourceTable.Id_input_dialog_ok2);
        ok.setClickedListener(component1 -> {
            bean.listener.positiveButton();
        });
        Button cancle = (Button) component.findComponentById(ResourceTable.Id_input_dialog_cancle);
        cancle.setClickedListener(component1 -> {
            bean.listener.negativeButton();
        });
        bean.commonDialog = commonDialog;
        return bean;
    }

    private ConfigBean builtTwoInput(final ConfigBean bean){
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_two_input_dialog_layout, null,
                        false);
        commonDialog.setContentCustomComponent(component);
        commonDialog.setTransparent(true);
        Text titleTV = (Text) component.findComponentById(ResourceTable.Id_two_input_dialog_title);
        titleTV.setText(bean.title.toString());
        TextField firstFiled = (TextField) component.findComponentById(ResourceTable.Id_two_input_dialog_text_field_one);
        TextField secondFiled = (TextField) component.findComponentById(ResourceTable.Id_two_input_dialog_text_field_two);

        firstFiled.setHint(bean.hint1.toString());
        secondFiled.setHint(bean.hint2.toString());
        ShapeElement selectElement = new ShapeElement(bean.context, ResourceTable.Graphic_ios_button_background_select);
        ShapeElement emptyElement = new ShapeElement(bean.context,
                ResourceTable.Graphic_ios_button_background_unselect);

        StateElement okCheckElement = new StateElement();
        okCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_PRESSED}, selectElement);
        okCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);
        Button ok = (Button) component.findComponentById(ResourceTable.Id_two_input_dialog_ok);
        ok.setBackground(okCheckElement);
        ok.setClickedListener(component1 -> {
            bean.listener.positiveButton();
        });
        StateElement cancleCheckElement = new StateElement();
        cancleCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_PRESSED}, selectElement);
        cancleCheckElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);
        Button cancle = (Button) component.findComponentById(ResourceTable.Id_two_input_dialog_cancle);
        cancle.setBackground(cancleCheckElement);
        cancle.setClickedListener(component1 -> {
            bean.listener.negativeButton();
        });
        bean.commonDialog = commonDialog;
        return bean;
    }

    /**
     * 生成单选dialog
     *
     * @param bean bean
     * @return ConfigBean
     */
    protected ConfigBean buildMdSingleChoose(final ConfigBean bean) {
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_single_choose_dialog_layout, null,
                        false);
        commonDialog.setTransparent(true);
        Text titleTv = (Text) component.findComponentById(ResourceTable.Id_single_dialog_title);
        titleTv.setText(bean.title.toString());
        RadioContainer radioContainer = (RadioContainer) component.findComponentById(ResourceTable.Id_radio_container);
        Resource selectResource = null;
        Resource emptyResource = null;
        try {
            selectResource = bean.context.getResourceManager().getResource(ResourceTable.Media_select);
            emptyResource = bean.context.getResourceManager().getResource(ResourceTable.Media_unselect);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotExistException e) {
            e.printStackTrace();
        }

        PixelMapElement selectElement = new PixelMapElement(selectResource);
        PixelMapElement emptyElement = new PixelMapElement(emptyResource);

        for (int i = 0; i < bean.chooseBeans.size(); i++) {
            ChooseBean chooseBean = bean.chooseBeans.get(i);
            RadioButton radioButton = new RadioButton(bean.context);
            radioButton.setWidth(ComponentContainer.LayoutConfig.MATCH_CONTENT);
            radioButton.setHeight(150);
            radioButton.setTextSize(50);
            radioButton.setText(chooseBean.getTxt().toString());
            radioButton.setButtonElement(null);
            if (chooseBean.isChoosen()) {
                radioButton.setSelected(true);
            } else {
                radioButton.setSelected(false);
            }
            StateElement checkElement = new StateElement();
            checkElement.addState(new int[]{ComponentState.COMPONENT_STATE_SELECTED}, selectElement);
            checkElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);
            radioButton.setAroundElements(checkElement, null, null, null);
            radioContainer.addComponent(radioButton);
        }
        radioContainer.setMarkChangedListener(new RadioContainer.CheckedStateChangedListener() {
            @Override
            public void onCheckedChanged(RadioContainer r, int i) {
                for (int j = 0; j < bean.chooseBeans.size(); j++) {
                    RadioButton radioButton1 = (RadioButton) r.getComponentAt(j);
                    if (j == i) {
                        radioButton1.setSelected(true);
                        bean.itemListener.onItemClick(bean.chooseBeans.get(i).getTxt(), i);
                    } else {
                        radioButton1.setSelected(false);
                    }
                }
            }
        });

        Button ok = (Button) component.findComponentById(ResourceTable.Id_single_dialog_ok);
        ok.setClickedListener(component1 -> {
            bean.itemListener.positiveButton();
        });
        Button cancle = (Button) component.findComponentById(ResourceTable.Id_single_dialog_cancle);
        cancle.setClickedListener(component1 -> {
            bean.itemListener.negativeButton();
        });

        component.invalidate();
        commonDialog.setContentCustomComponent(component);
        bean.commonDialog = commonDialog;


        return bean;
    }

    protected ConfigBean builtIosSingleChoose(final ConfigBean bean){
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_ios_single_choose_layout, null,
                        false);
        ListContainer listContainer = (ListContainer) component.findComponentById(ResourceTable.Id_ios_single_choose_list);
        SingleChooseProviders singleChooseProviders = new SingleChooseProviders(bean.context,bean.chooseBeans);
        listContainer.setItemProvider(singleChooseProviders);
        commonDialog.setTransparent(true);
        commonDialog.setContentCustomComponent(component);
        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                bean.selectItem = bean.chooseBeans.get(i).toString();
                bean.itemListener.positiveButton();
            }
        });
        bean.commonDialog = commonDialog;
        return bean;
    }

    protected ConfigBean builtIosSingleMenuChoose(final ConfigBean bean){
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_single_menu_choose_layout, null,
                        false);
        ListContainer listContainer = (ListContainer) component.findComponentById(ResourceTable.Id_menu_list);
        SingleChooseProviders singleChooseProviders = new SingleChooseProviders(bean.context,bean.chooseBeans);
        listContainer.setItemProvider(singleChooseProviders);

        commonDialog.setTransparent(false);
        commonDialog.setContentCustomComponent(component);
        commonDialog.setSize(bean.menuWidth,bean.menuHeight);
        commonDialog.setOffset(bean.x,bean.y);
        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                bean.selectItem = bean.chooseBeans.get(i).toString();
                bean.itemListener.positiveButton();
            }
        });
        bean.commonDialog = commonDialog;
        return bean;
    }


    protected ConfigBean builtBottomIosSingleChoose(final ConfigBean bean){
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_ios_single_choose_layout, null,
                        false);
        ListContainer listContainer = (ListContainer) component.findComponentById(ResourceTable.Id_ios_single_choose_list);
        Text text = (Text) component.findComponentById(ResourceTable.Id_ios_bottom_single_choose_text);
        text.setVisibility(Component.VISIBLE);
        SingleChooseProviders singleChooseProviders = new SingleChooseProviders(bean.context,bean.chooseBeans);
        listContainer.setItemProvider(singleChooseProviders);
        commonDialog.setTransparent(true);
        commonDialog.setContentCustomComponent(component);
        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                bean.selectItem = bean.chooseBeans.get(i).toString();
                bean.itemListener.positiveButton();
            }
        });
        text.setClickedListener(component1 -> {
            commonDialog.hide();
        });
        bean.commonDialog = commonDialog;
        return bean;
    }




    protected ConfigBean builtBottomIosList(final ConfigBean bean){
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_ios_list_single_choose_layout, null,
                        false);
        ListContainer listContainer = (ListContainer) component.findComponentById(ResourceTable.Id_ios_list);
        Text text = (Text) component.findComponentById(ResourceTable.Id_ios_list_text);
        text.setVisibility(Component.VISIBLE);
        SingleChooseProviders singleChooseProviders = new SingleChooseProviders(bean.context,bean.chooseBeans);
        listContainer.setItemProvider(singleChooseProviders);
        commonDialog.setTransparent(true);
        commonDialog.setContentCustomComponent(component);
        listContainer.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                bean.selectItem = bean.chooseBeans.get(i).toString();
                bean.itemListener.positiveButton();
            }
        });
        text.setClickedListener(component1 -> {
            commonDialog.hide();
        });
        bean.commonDialog = commonDialog;
        return bean;
    }

    /**
     * 生成多选dialog
     *
     * @param bean bean
     * @return ConfigBean
     */
    protected ConfigBean buildMdMultiChoose(final ConfigBean bean) {
        CommonDialog commonDialog = new CommonDialog(bean.context);
        Component component =
                LayoutScatter.getInstance(bean.context).parse(ResourceTable.Layout_multi_choose_dialog_layout, null,
                        false);

        commonDialog.setTransparent(true);
        DirectionalLayout layout = (DirectionalLayout) component.findComponentById(ResourceTable.Id_checkbox_layout);
        Resource selectResource = null;
        Resource emptyResource = null;
        try {
            selectResource = bean.context.getResourceManager().getResource(ResourceTable.Media_checkbox_select);
            emptyResource = bean.context.getResourceManager().getResource(ResourceTable.Media_checkbox_unselect);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotExistException e) {
            e.printStackTrace();
        }

        PixelMapElement selectElement = new PixelMapElement(selectResource);
        PixelMapElement emptyElement = new PixelMapElement(emptyResource);

        for (int i = 0; i < bean.chooseBeans.size(); i++) {
            ChooseBean chooseBean = bean.chooseBeans.get(i);
            Checkbox checkbox = new Checkbox(bean.context);
            checkbox.setWidth(ComponentContainer.LayoutConfig.MATCH_CONTENT);
            checkbox.setHeight(150);
            checkbox.setTextSize(50);
            checkbox.setText(chooseBean.getTxt().toString());

            if (chooseBean.isChoosen()) {
                checkbox.setChecked(true);

            } else {
                checkbox.setChecked(false);
            }

            checkbox.setButtonElement(null);
            checkbox.setTag(i);

            StateElement checkElement = new StateElement();
            checkElement.addState(new int[]{ComponentState.COMPONENT_STATE_CHECKED}, selectElement);
            checkElement.addState(new int[]{ComponentState.COMPONENT_STATE_EMPTY}, emptyElement);
            checkbox.setAroundElements(checkElement, null, null, null);
            checkbox.setCheckedStateChangedListener((absButton, state) -> {
                absButton.setChecked(state);

                absButton.setAroundElements(checkElement, null, null, null);
                bean.checkBoxItemDialogListener.onItemClick((Checkbox) absButton, (int) absButton.getTag());
            });

            layout.addComponent(checkbox);
        }

        Button ok = (Button) component.findComponentById(ResourceTable.Id_multi_dialog_ok);
        ok.setClickedListener(component1 -> {
            bean.checkBoxItemDialogListener.positiveButton();
        });
        Button cancle = (Button) component.findComponentById(ResourceTable.Id_multi_dialog_cancle);
        cancle.setClickedListener(component1 -> {
            bean.checkBoxItemDialogListener.negativeButton();
        });
        component.invalidate();
        commonDialog.setContentCustomComponent(component);
        bean.commonDialog = commonDialog;
        return bean;
    }
}
