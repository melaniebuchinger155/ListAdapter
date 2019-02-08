package buchinger.melanie.listadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter<Person> {

private static final String TAG = "PersonListAdapter";
private Context mContext;
private int mResource;
private int lastPosition;

   private static class ViewHolder {
        TextView name;
        TextView birthday;
        TextView sex;
        ImageView img;
    }

    /**
     *
     * @param context
     * @param resource
     * @param objects
     */




public PersonListAdapter(Context context, int resource, ArrayList<Person> objects)
{
    super(context, resource, objects);
    mContext = context;
    mResource = resource;
}

@NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    //Setup Imageloader
    // Quelle: https://stacktips.com/tutorials/android/universal-image-loader-library-in-android ->
    //3. Library setup in your Application class
    setUpImageLoader();


    //gibt die Personeninformationen

    String name = getItem(position).getName();
    String birthday = getItem(position).getBirthday();
    String sex = getItem(position).getSex();
    String imgURL = getItem(position).getImgURL();




    //Animation erstellen
    final View result;

    ViewHolder holder;

    if (convertView == null)
    {
        LayoutInflater inflater = LayoutInflater.from( mContext );
        convertView = inflater.inflate( mResource, parent, false );

        holder = new ViewHolder();
        holder.name = (TextView) convertView.findViewById( R.id.textView1 );
        holder.birthday = (TextView) convertView.findViewById( R.id.textView2 );
        holder.sex = (TextView) convertView.findViewById( R.id.textView3 );
        holder.img = (ImageView) convertView.findViewById( R.id.image );

        result = convertView;
        convertView.setTag(holder);
    }
    else {
        holder = (ViewHolder) convertView.getTag();
        result = convertView;
    }



    Animation animation = AnimationUtils.loadAnimation(mContext,
            (position > lastPosition ) ? R.anim.load_down_amim : R.anim.load_up_amim);
    result.startAnimation( animation );
    lastPosition = position;

    // Quelle: https://stacktips.com/tutorials/android/universal-image-loader-library-in-android ->
    //4. Download and display bitmap on ImageView


    ImageLoader imageLoader = ImageLoader.getInstance();

    int defaultImage = mContext.getResources().getIdentifier("drawable/image_failed", null, mContext.getPackageName());

    DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
            .cacheOnDisc(true).resetViewBeforeLoading(true)
            .showImageForEmptyUri(defaultImage)
            .showImageOnFail(defaultImage)
            .showImageOnLoading(defaultImage).build();

    imageLoader.displayImage(imgURL, holder .img, options);


    holder.name.setText( name );
    holder.birthday.setText(birthday) ;
    holder.sex.setText(sex) ;



    return convertView;

}

    private void setUpImageLoader () {


        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(200)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }

}
