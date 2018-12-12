package com.pictools.constraint;

import java.util.List;

import static java.util.List.of;

public class Constraints {
    public static final String UNIQUE_STATUS_NAME = "UNIQUE_STATUS_NAME";

    public static List<String> all() {
        return of(UNIQUE_STATUS_NAME);
    }
}
