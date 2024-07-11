package com.northcoders.surfeillance.service.logic;

import com.northcoders.surfeillance.model.dto.ConditionsDTO;

import java.util.List;
import java.util.function.Supplier;

public class ConditionsSupplier {

    public static Supplier<List<ConditionsDTO>> conditions = () -> {
      return List.of(
              new ConditionsDTO(1, "Castle Haven Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(2, "Kirkandrews Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(3, "The Beach",  "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(4, "Ross Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(5, "Ringdoo Sands", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(6, "Roker Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(7, "Whitburn Sands", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(8, "Tynemouth Longsands", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(9, "Bamburgh Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(10, "Seaburn Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(11, "South Shields Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(12, "Whitley Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(13, "Blyth Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(14, "Druridge Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(15, "Newbiggin-by-the-sea", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(16, "Cresswell Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(17, "Alnmouth Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(18, "Warkworth Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(19, "Amble Links", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(20, "Boulmer Haven", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(21, "Beadnell Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(22, "Seahouses Beach", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(23, "Holy Island", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(24, "Embleton Bay", "", null,  0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2),
              new ConditionsDTO(25, "Low Newton by the Sea", "", null, 0.5, 5.2, "GMT", 2L, 2L, 2L, 1.5, 5.6, 1.0, null, 1.3, null, 3.2)
      );
    };
}
