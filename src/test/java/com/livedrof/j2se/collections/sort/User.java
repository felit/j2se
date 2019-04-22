package com.livedrof.j2se.collections.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private Date date;
}
