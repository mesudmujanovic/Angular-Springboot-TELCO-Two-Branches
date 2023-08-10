package com.Digital.Digital.Repository.CalculatorRepository;

import com.Digital.Digital.Entity.CalculatorDiscountTariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorDiscountRepo extends JpaRepository<CalculatorDiscountTariff, Long> {
}
