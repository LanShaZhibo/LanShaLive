package com.lansha.lanshalive.Model;

import java.util.List;

/**
 * Created by my on 2016/11/28.
 */
public class ListViewModel {
    private String name;
    private List<RecommendModel> rooms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecommendModel> getRooms() {
        return rooms;
    }

    public void setRooms(List<RecommendModel> rooms) {
        this.rooms = rooms;
    }
}
