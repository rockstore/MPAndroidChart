package com.rock.examples;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.xxmassdeveloper.mpchartexample.R;

import java.util.ArrayList;

/**
 * simple example for LineChart
 * */
public class DemoSimpleLineChartActivity extends FragmentActivity {
    private LineChart mSimpleLineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_simple_line_chart);
        mSimpleLineChart = findViewById(R.id.simple_demo_line_chart);
        initLineChart();
    }
    /**
     *
     * */
    private void initLineChart() {
        mSimpleLineChart.setDrawBorders(true);
        // init a line
        ArrayList<Integer> dataList = new ArrayList<>();
        ArrayList<Entry> entryList = new ArrayList<>();
        for (int i = 0 ; i < 30 ; i++) {
            dataList.add(i);
        }
        for (int i = 0 ; i < dataList.size() ; i++) {
            entryList.add(new Entry(i, dataList.get(i)));
        }
        // LineDataSet represents a line on the chart
        LineDataSet dataSet = new LineDataSet(entryList, "test");
        dataSet.setColor(getResources().getColor(android.R.color.holo_red_dark));
        dataSet.setLineWidth(2f);
        dataSet.setDrawCircleHole(false);
        // dataSet.setDrawCircles(false);
        LineData lineData = new LineData(dataSet);
        lineData.setDrawValues(false);

        // set xAxis
        XAxis xAxis = mSimpleLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // 坐标之间的最小间隔
        xAxis.setGranularity(2f);
        xAxis.setAxisMaximum(0f);
        xAxis.setAxisMaximum(entryList.size());
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int tmp = (int) value;
                return tmp + " hehe";
            }
        });


        // set yAxis
        YAxis yAxis = mSimpleLineChart.getAxisLeft();
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);


        // set Legend
        Legend legend = mSimpleLineChart.getLegend();
//        legend.setEnabled(true);

        // set marker

        mSimpleLineChart.setData(lineData);


    }
}
