package com.mskprojects.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    private String name;
    private String showType;
    private Date startTime;
    private Date endTime;
    private Screen screen;
    @ManyToOne
    private Movie movie;
    @OneToMany
    private List<ShowSeat> showSeatList;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // creates mapping table for Screen to Feature (ENUM)
    private List<Feature> featureList;
}
