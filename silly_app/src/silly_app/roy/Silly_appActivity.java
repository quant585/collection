package silly_app.roy;

import android.app.Activity;
//import android.app.AlertDialog;
import android.os.Bundle;
//import android.os.Handler;

import android.view.View;
//import android.view.View.OnClickListener;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
//import android.widget.SeekBar;

import silly_app.roy.Fortschritt;

public class Silly_appActivity extends Activity implements View.OnClickListener{
	
	Fortschritt oProgress;
	Button RaiseButton, LowerButton, ResetButton ;
	ProgressBar myBar, myCycle;
	//SeekBar mySeek; 
	//private Handler mHandler = new Handler() ;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        oProgress = new Fortschritt();
        myBar = (ProgressBar) findViewById(R.id.progressBar2);
        myCycle = (ProgressBar) findViewById(R.id.progressBar1);

        //myBar.setIndeterminate(true);
        //myBar.invalidate();
        //myBar.setSecondaryProgress(50);
        //myCycle.setIndeterminate(false);
        //myCycle.setProgress(34);
        //myCycle.invalidate();
        
        //mySeek = (SeekBar) findViewById(R.id.seekBar1);

        /*
        new Thread(new Runnable() {
        	int mProgressStatus = 0;
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus = oProgress.Get();

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            myCycle.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
        */

        LowerButton = (Button) findViewById(R.id.buttonlower);
        LowerButton.setOnClickListener(this);

        RaiseButton = (Button) findViewById(R.id.buttonraise);
        RaiseButton.setOnClickListener(this); 

        ResetButton = (Button) findViewById(R.id.ButtonReset);
        ResetButton.setOnClickListener(this); 
        /*
        mySeek.setOnSeekBarChangeListener(new  SeekBar.OnSeekBarChangeListener(){ 

    	   @Override 
    	   public void onProgressChanged(SeekBar mySeek, int progress, 
    	     boolean fromUser) { 
    	        // TODO Auto-generated method stub 
    	        //seekBarValue.setText(String.valueOf(progress)); 
    	    	myBar.setProgress(progress);
    			myBar.invalidate() ;
    	   } 

    	   @Override 
    	   public void onStartTrackingTouch(SeekBar mySeek) { 
    	    // TODO Auto-generated method stub 
    	   } 

    	   @Override 
    	   public void onStopTrackingTouch(SeekBar mySeek) { 
    	    // TODO Auto-generated method stub 
    	   } 
       });
       */         
}
    
    public void onClick(View v) {
    	//myBar.setIndeterminate(false);
    	switch (v.getId()){
    	case R.id.buttonlower:
    		LowerProgress();
    		break;
    	case R.id.buttonraise:
    		RaiseProgress();
    		break;
    	case R.id.ButtonReset:
    		ZeroProgress();
    		break;
    	}
    }
    
    public void RaiseProgress()
    {
    	int val;
    	int sec;
    	
    	val = oProgress.Get();
    	val = val+10;
    	oProgress.Set( val ) ;
    	val = oProgress.Get();
    	myBar.setProgress(val);
    	sec = myBar.getSecondaryProgress();
    	if (sec < val )
    		myBar.setSecondaryProgress( val );
		myBar.invalidate() ;
    }
    public void LowerProgress()
    {
    	int val;
    	
    	val = oProgress.Get();
    	val = val-10;
    	oProgress.Set( val ) ;
    	val = oProgress.Get();
    	myBar.setProgress(val);
		myBar.invalidate() ;
    }
    public void ZeroProgress()
    {
		oProgress.Set(0);
		myBar.setProgress(0);
		myBar.setSecondaryProgress(0);
		myBar.invalidate() ;
    	//myBar.setIndeterminate(true);
    }

}
