package com.businesscard.ws.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor //constructor kısmında parametre verebilmemizi sağlyor
public class GenericResponse {
    private String message;
}
