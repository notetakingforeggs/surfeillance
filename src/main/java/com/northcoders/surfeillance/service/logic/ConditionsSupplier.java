package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.dto.ConditionsDTO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

public class ConditionsSupplier {



    public static Supplier<List<ConditionsDTO>> conditions = () -> {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        Date sixHoursLater = calendar.getTime();
      return List.of(
              new ConditionsDTO(1, "Castle Haven Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.1, sixHoursLater, 3.1),
              new ConditionsDTO(2, "Kirkandrews Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.1, sixHoursLater, 3.2),
              new ConditionsDTO(3, "The Beach",  "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.2, sixHoursLater, 3.4),
              new ConditionsDTO(4, "Ross Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.3, sixHoursLater, 3.2),
              new ConditionsDTO(5, "Ringdoo Sands", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.3, sixHoursLater, 3.2),
              new ConditionsDTO(6, "Roker Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.8, sixHoursLater, 2.9),
              new ConditionsDTO(7, "Whitburn Sands", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.8, sixHoursLater, 3.2),
              new ConditionsDTO(8, "Tynemouth Longsands", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.6, sixHoursLater, 3.2),
              new ConditionsDTO(9, "Bamburgh Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.4, sixHoursLater, 3.2),
              new ConditionsDTO(10, "Seaburn Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.2, sixHoursLater, 3.0),
              new ConditionsDTO(11, "South Shields Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.7, sixHoursLater, 3.2),
              new ConditionsDTO(12, "Whitley Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.5, sixHoursLater, 3.1),
              new ConditionsDTO(13, "Blyth Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.3, sixHoursLater, 3.3),
              new ConditionsDTO(14, "Druridge Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.3, sixHoursLater, 3.4),
              new ConditionsDTO(15, "Newbiggin-by-the-sea", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.3, sixHoursLater, 3.2),
              new ConditionsDTO(16, "Cresswell Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.3, sixHoursLater, 3.5),
              new ConditionsDTO(17, "Alnmouth Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.3, sixHoursLater, 3.2),
              new ConditionsDTO(18, "Warkworth Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.6, sixHoursLater, 3.6),
              new ConditionsDTO(19, "Amble Links", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.1, sixHoursLater, 2.4),
              new ConditionsDTO(20, "Boulmer Haven", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.6, sixHoursLater, 3.2),
              new ConditionsDTO(21, "Beadnell Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.4, sixHoursLater, 3.1),
              new ConditionsDTO(22, "Seahouses Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 0.9, sixHoursLater, 3.2),
              new ConditionsDTO(23, "Holy Island", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.0, sixHoursLater, 3.7),
              new ConditionsDTO(24, "Embleton Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.0, sixHoursLater, 3.2),
              new ConditionsDTO(25, "Low Newton by the Sea", "", null, 0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, new Date(), 1.1, sixHoursLater, 3.2)
      );
    };
}
