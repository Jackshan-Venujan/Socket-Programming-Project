package com.uor.eng;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import lombok.Getter;

/**
 * A chart to display selected metrics (latency, throughput, quality) over time.
 */
public class ChartDisplay {
  @Getter
  private final LineChart<Number, Number> chart;
  private final XYChart.Series<Number, Number> latencySeries;
  private final XYChart.Series<Number, Number> throughputSeries;
  private final XYChart.Series<Number, Number> qualitySeries;

  private int sampleCount = 0;
  private static final int MAX_DATA_POINTS = 50;

  public ChartDisplay() {
    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    xAxis.setLabel("Time (s)");
    yAxis.setLabel("Values");
    yAxis.setAutoRanging(true);

    chart = new LineChart<>(xAxis, yAxis);
    chart.setTitle("Network Metrics Over Time");
    chart.setCreateSymbols(false);
    chart.setAnimated(false);

    // Set a fixed height for the chart
    chart.setPrefHeight(300);

    latencySeries = new XYChart.Series<>();
    throughputSeries = new XYChart.Series<>();
    qualitySeries = new XYChart.Series<>();

    latencySeries.setName("Latency (ms)");
    throughputSeries.setName("Throughput (KB/s)");
    qualitySeries.setName("Quality Score (%)");

    chart.getData().addAll(latencySeries, throughputSeries, qualitySeries);

    chart.setStyle("-fx-background-color: #f5f5f5;");

    // Enable chart zooming and panning (simple example)
    chart.setOnScroll(event -> {
      event.consume();
      if (event.getDeltaY() > 0) {
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(yAxis.getLowerBound() * 0.9);
        yAxis.setUpperBound(yAxis.getUpperBound() * 0.9);
      } else {
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(yAxis.getLowerBound() * 1.1);
        yAxis.setUpperBound(yAxis.getUpperBound() * 1.1);
      }
    });
  }

  /**
   * Update the chart with fresh NetworkMetrics data.
   */
  public void update(NetworkMetrics metrics) {
    if (!metrics.isSuccessful()) {
      return; // Skip errors
    }

    sampleCount++;

    if (latencySeries.getData().size() > MAX_DATA_POINTS) {
      latencySeries.getData().remove(0);
      throughputSeries.getData().remove(0);
      qualitySeries.getData().remove(0);
    }

    latencySeries.getData().add(new XYChart.Data<>(sampleCount, metrics.getLatency()));
    // Convert throughput from B/s to KB/s
    throughputSeries.getData().add(new XYChart.Data<>(sampleCount, metrics.getThroughput() / 1024.0));
    qualitySeries.getData().add(new XYChart.Data<>(sampleCount, metrics.getConnectionQuality()));
  }
}
