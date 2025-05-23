package com.infosys.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String name;


}
