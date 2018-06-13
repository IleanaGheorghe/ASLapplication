package ro.ase.eu.aslapplication.intrebariQuiz;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;

import ro.ase.eu.aslapplication.R;

/**
 * Created by Ileana Gheorghe on 6/10/2018.
 */

public class WebViewAdapter extends BaseAdapter {

    private String[] url;
    Context context;

   public  WebViewAdapter(Context context,String[] url){
        this.context=context;
        this.url=url;
    }
    @Override
    public int getCount() {
        return url.length;
    }

    @Override
    public Object getItem(int position) {
        return url[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView=convertView;

        if(gridView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             gridView=inflater.inflate(R.layout.layout_quiz,null);
        }

        WebView webView=(WebView)gridView.findViewById(R.id.wv1);
        webView.setBackgroundColor(Color.WHITE);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.loadUrl(url[position]);
      return gridView;
   }
}
