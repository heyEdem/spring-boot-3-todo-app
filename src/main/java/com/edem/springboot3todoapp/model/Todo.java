package com.edem.springboot3todoapp.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "todo_item")
public class Todo implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String description;

    private Boolean isComplete;

    private Instant createdAt;

    private Instant updatedAt;


    @Override
    public String toString( ){
        return String.format("Todo{id=%d, description='%s',isComplete='%s', createdAt='%s' , updatedAt='%s'}",
                id,description,isComplete,createdAt,updatedAt);

    }

}
