package si.ncode.scorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import si.ncode.common.MainPresenter;

public class MainActivity extends AppCompatActivity
{
	private MainPresenter main_presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		main_presenter = new MainPresenter(this);
	}
}
