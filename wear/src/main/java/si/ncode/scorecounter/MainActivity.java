package si.ncode.scorecounter;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import si.ncode.common.MainPresenter;

public class MainActivity extends WearableActivity
{
	private MainPresenter main_presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setAmbientEnabled();

		main_presenter = new MainPresenter(this);
	}

	@Override
	public void onEnterAmbient(Bundle ambientDetails)
	{
		super.onEnterAmbient(ambientDetails);
		updateDisplay();
	}

	@Override
	public void onUpdateAmbient()
	{
		super.onUpdateAmbient();
		updateDisplay();
	}

	@Override
	public void onExitAmbient()
	{
		updateDisplay();
		super.onExitAmbient();
	}

	private void updateDisplay()
	{
		if (isAmbient())
		{
			//mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
		}
		else
		{
			//mContainerView.setBackground(null);
		}
	}
}
