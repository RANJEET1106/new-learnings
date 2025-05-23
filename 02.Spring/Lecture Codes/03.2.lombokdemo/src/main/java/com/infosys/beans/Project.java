package com.infosys.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data //generate getter,setter , equals(), hashcode(), toString(), @RequiredArgsConstructor
public class Project {

    private String projectName;
    private String projectTeamName;
}
