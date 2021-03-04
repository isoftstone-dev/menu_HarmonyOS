package com.istone.dialoglibrary.providers;

import com.istone.dialoglibrary.ResourceTable;
import com.istone.dialoglibrary.config.ChooseBean;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.RecycleItemProvider;
import ohos.agp.components.Text;
import ohos.app.Context;

import java.util.ArrayList;
import java.util.List;

public class SingleChooseProviders extends RecycleItemProvider {
    private List<ChooseBean> list;
    private Context context;

    public SingleChooseProviders(Context context, List<ChooseBean> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        Component cpt = null;
        Text item = null;
        if (component == null) {
            cpt = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_ios_single_choose_item, null, false);

            item  = (Text) cpt.findComponentById(ResourceTable.Id_ios_single_choose_list_item_tv);
            cpt.setTag(item);
        } else {
            item =  (Text)cpt.getTag();
        }

        ChooseBean chooseBean = list.get(i);
        item.setText(chooseBean.getTxt().toString());
        return cpt;
    }
}
