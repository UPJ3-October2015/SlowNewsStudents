package com.slownews.service.Habrahabr;

import java.io.IOException;
import java.util.List;

/**
 * Created by ���� on 08.01.2016.
 */
public interface HabrahabrNews {
    List<com.slownews.model.Habrahabr.HabrahabrNews> getHabrahabrNews() throws IOException;
}
