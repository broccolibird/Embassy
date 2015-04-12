package com.uncorkedstudios.findmyembassy;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kat on 4/12/15.
 */
public class InfoAdapter extends BaseAdapter {

    public List<Info> infos;

    public InfoAdapter(List<Info> infos) {
        this.infos = infos;
    }

    @Override
    public int getCount() {
        return infos.size();
    }

    @Override
    public Object getItem(int position) {
        return infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = parent.inflate(parent.getContext(), R.layout.row_info, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.populate(infos.get(position));

        return convertView;
    }

    public class ViewHolder {

        public TextView nameTV;

        public TextView addressTV;

        public TextView phonenumberTV;

        public ViewHolder(View v) {
            this.nameTV = (TextView) v.findViewById(R.id.name);
            this.addressTV = (TextView) v.findViewById(R.id.address);
            this.phonenumberTV = (TextView) v.findViewById(R.id.phonenumber);
        }

        public void populate(Info info) {
            nameTV.setText(info.getName());
            addressTV.setText(info.getAddress());
            phonenumberTV.setText(info.getPhoneNumber());
        }
    }
}
