package net.leolink.android.simpleinfinitecarousel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyFragment extends Fragment
{
	private static int position = 0;
	public static Fragment newInstance(MainActivity context, int pos)
	{
		position = pos;
		return Fragment.instantiate(context, MyFragment.class.getName());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		if (container == null)
		{
			return null;
		}
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.mf, container, false);

		ImageView image = (ImageView) layout.findViewById(R.id.image);
		image.setImageResource(R.drawable.cat);
		
		LinearLayout root = (LinearLayout) layout.findViewById(R.id.root);

		return layout;
	}
}