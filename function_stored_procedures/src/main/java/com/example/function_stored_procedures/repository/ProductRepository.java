package com.example.function_stored_procedures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.function_stored_procedures.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
    //to call stored procedure
    @Procedure(name = "updateStockProcedure")
    public void updateStockQuantity(int productId, int quantity);


    //to call funcion
    @Query(value = "SELECT get_total_price(:productId)",nativeQuery = true)
    public double getTotalPrice(int productId);
}
