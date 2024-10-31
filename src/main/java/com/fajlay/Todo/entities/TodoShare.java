package com.fajlay.Todo.entities;

import com.fajlay.Todo.util.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo_share")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Todo todoId;
    private Role role;
    @Column(name = "shared_at")
    private LocalDateTime sharedAt;

}
