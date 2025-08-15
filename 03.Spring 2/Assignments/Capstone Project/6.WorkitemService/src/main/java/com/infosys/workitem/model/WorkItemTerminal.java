package com.infosys.workitem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ftr_workItem_Terminal")
public class WorkItemTerminal {
    @Id
    @Column(nullable = false)
    private String workItemId;

    @Column(nullable = false)
    private String terminalId;
}
