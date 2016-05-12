package si.ncode.common;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Tadej on 13.5.2016.
 */
public class MainPresenter
{
	Activity activity;

	//private SimpleDateFormat time_format = new SimpleDateFormat("HH:mm");

	private View left_side;
	private TextView left_score;
	private View right_side;
	private TextView right_score;
	private Button reset;
	//private TextView clock;

	private int current_left_score = 0;
	private int current_right_score = 0;

	public MainPresenter(Activity activity)
	{
		this.activity = activity;

		left_side = activity.findViewById(R.id.left_side);
		left_score = (TextView) activity.findViewById(R.id.left_score);
		right_side = activity.findViewById(R.id.right_side);
		right_score = (TextView) activity.findViewById(R.id.right_score);
		reset = (Button) activity.findViewById(R.id.reset);
		//clock = (TextView) activity.findViewById(R.id.clock);

		left_side.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				current_left_score++;
				refreshUi();
			}
		});
		left_side.setOnLongClickListener(new View.OnLongClickListener()
		{
			@Override
			public boolean onLongClick(View view)
			{
				current_left_score--;
				refreshUi();
				return true;
			}
		});
		right_side.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				current_right_score++;
				refreshUi();
			}
		});
		right_side.setOnLongClickListener(new View.OnLongClickListener()
		{
			@Override
			public boolean onLongClick(View view)
			{
				current_right_score--;
				refreshUi();
				return true;
			}
		});
		reset.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				current_left_score = 0;
				current_right_score = 0;
				refreshUi();
			}
		});

		refreshUi();
	}


	private void refreshUi()
	{
		left_score.setText(Integer.toString(current_left_score));
		right_score.setText(Integer.toString(current_right_score));

		if (current_left_score > current_right_score)
		{
			left_side.setBackgroundColor(activity.getResources().getColor(R.color.winning));
			right_side.setBackgroundColor(activity.getResources().getColor(R.color.losing));
		}
		else if (current_left_score < current_right_score)
		{
			left_side.setBackgroundColor(activity.getResources().getColor(R.color.losing));
			right_side.setBackgroundColor(activity.getResources().getColor(R.color.winning));
		}
		else
		{
			left_side.setBackgroundColor(activity.getResources().getColor(R.color.neutral));
			right_side.setBackgroundColor(activity.getResources().getColor(R.color.neutral));
		}

		//clock.setText(time_format.format(Calendar.getInstance().getTime()));
	}

}
