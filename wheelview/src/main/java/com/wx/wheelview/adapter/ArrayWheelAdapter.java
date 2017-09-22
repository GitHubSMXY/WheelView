/*
 * Copyright (C) 2016 venshine.cn@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wx.wheelview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.wx.wheelview.common.WheelConstants;
import com.wx.wheelview.widget.WheelItem;

/**
 * 滚轮数组适配器
 *
 * @author venshine
 */
public class ArrayWheelAdapter<T> extends BaseWheelAdapter<T> {

    private Context mContext;
    private int itemHeight = WheelConstants.WHEEL_ITEM_HEIGHT;
    private int itemPanding = WheelConstants.WHEEL_ITEM_PADDING;

    public ArrayWheelAdapter(Context context) {
        mContext = context;
    }

    public ArrayWheelAdapter(Context context, int itemHeight,int panding) {
        this.itemHeight = itemHeight;
        this.itemPanding = panding;
        mContext = context;
    }

    @Override
    public View bindView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = new WheelItem(mContext,itemHeight,itemPanding);
        }

        WheelItem wheelItem = (WheelItem) convertView;
        T item = getItem(position);
        if (wheelItem instanceof CharSequence) {
            wheelItem.setText((CharSequence) item);
        } else {
            wheelItem.setText(item.toString());
        }
        return convertView;
    }

}
