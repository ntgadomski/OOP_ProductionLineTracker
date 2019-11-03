package productionlinetracker;

/** Interface implemented by other classes for media methods @Author: Nickolas Gadomski */
public interface ScreenSpec {
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
