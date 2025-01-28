package com.example.function_stored_procedures.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.*;


@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "updateStockProcedure",procedureName = "update_stock",
    parameters = {
      @StoredProcedureParameter(mode = ParameterMode.IN,name = "productId", type = Integer.class),
      @StoredProcedureParameter(mode = ParameterMode.IN,name = "quantity", type = Integer.class)
    }
  )
})

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @Column(name = "stockQuantity")
    private int stockQuantity;

}