package com.designpattern.外观模式;

/**
 * @ClassName HomeThreaterFacade
 * @Description
 * @Author wzj
 * @Date 2020/8/7 11:38
 **/

public class HomeThreaterFacade {

  // 定义各个子系统对象
  private TheaterLight theaterLight;
  private PopCorn popCorn;
  private Stereo stereo;
  private Projector projector;
  private Screen screen;
  private DVDPlayer dvdPlayer;

  public HomeThreaterFacade() {
      this.theaterLight = TheaterLight.getInstance();
      this.popCorn = PopCorn.getInstance();
      this.stereo = Stereo.getInstance();
      this.projector = Projector.getInstance();
      this.screen = Screen.getInstance();
      this.dvdPlayer = DVDPlayer.getInstance();
  }

  public void ready() {
      popCorn.on();
      popCorn.pop();
      screen.down();
      projector.on();
      stereo.on();
      dvdPlayer.on();
      theaterLight.dim();
  }

    public void play() {
        dvdPlayer.play();
    }

    public void pause() {
        dvdPlayer.pause();
    }

    public void end() {
        popCorn.off();
        theaterLight.bright();
        screen.up();
        projector.off();
        stereo.off();
        dvdPlayer.off();

    }

}
