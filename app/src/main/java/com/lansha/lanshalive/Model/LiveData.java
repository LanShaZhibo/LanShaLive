package com.lansha.lanshalive.Model;

import java.util.List;

/**
 * Created by Wind on 2016/11/28 0028.
 */
public class LiveData {
    List<Lives> rooms;
    List<Banners> banners;

    public List<Banners> getBanners() {
        return banners;
    }

    public void setBanners(List<Banners> banners) {
        this.banners = banners;
    }

    public List<Lives> getRooms() {
        return rooms;
    }

    public void setRooms(List<Lives> rooms) {
        this.rooms = rooms;
    }
}
