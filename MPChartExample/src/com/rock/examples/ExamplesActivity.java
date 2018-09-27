
package com.rock.examples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xxmassdeveloper.mpchartexample.R;
/**
 * try to use MPAndroidChart
 * */
public class ExamplesActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples);
        findViewById(R.id.simple_line_chart).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simple_line_chart:
                startActivity(new Intent(this, DemoSimpleLineChartActivity.class));
                break;
        }
    }
}
