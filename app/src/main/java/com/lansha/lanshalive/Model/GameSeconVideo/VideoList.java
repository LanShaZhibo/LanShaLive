package com.lansha.lanshalive.Model.GameSeconVideo;

/**
 * Created by Wind on 2016/11/30 0030.
 */
public class VideoList {
    private String nickname;
    private String videoName;
    private String videoTimeStr;
    private String coverAddress;
    private String clickNumber;
    private String videoAddress;

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoTimeStr() {
        return videoTimeStr;
    }

    public void setVideoTimeStr(String videoTimeStr) {
        this.videoTimeStr = videoTimeStr;
    }

    public String getCoverAddress() {
        return coverAddress;
    }

    public void setCoverAddress(String coverAddress) {
        this.coverAddress = coverAddress;
    }

    public String getClickNumber() {
        return clickNumber;
    }

    public void setClickNumber(String clickNumber) {
        this.clickNumber = clickNumber;
    }
}
