package com.zoerAleksandr.lesson13;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project GeekBrainsLesson
 *
 * @Author Zoer Aleksandr
 * Created 17.04.2021 19:04
 */
public class Race {
    private ArrayList<Stage> stages;

    ArrayList<Stage> getStages() {
        return stages;
    }

    Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
