package com.example.sourabh.gridviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


//To create a custom ImageAdapter create a new class which must extends from BaseAdapter
//It must have all 5 following override methods and a default constructor
//In this example only focuused on getView() and getCount() method. others method are by default
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    //To refer to different Resource IDs create an array
    private Integer[] ImageResources = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_3,R.drawable.sample_6,
            R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6,R.drawable.sample_1,R.drawable.sample_0,
            R.drawable.sample_7, R.drawable.sample_0, R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3};


    ImageAdapter(Context c) {  //Constructor
        mContext = c;
    }

    @Override
    public int getItemViewType(int position) {  //Default
        return super.getItemViewType(position);
    }

    @Override
    public int getCount()
    {
        return ImageResources.length;  //Returns the length of the array
    }

    @Override
    public Object getItem(int position) {
        return null;
    } //Default

    @Override
    public long getItemId(int position) {
        return 0;
    }  //Default

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {  //Get a View that displays the data at the specified position in the data set
        //convertView: The old view to reuse, if possible
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

            /*  You can use this way or you can use Inflator way in which you will need to provide a separate xml layout resource file
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.layout,parent,false);
            imageView = (ImageView) view.findViewById(R.id.image);  */
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(ImageResources[position]);
        return imageView;
    }
}
