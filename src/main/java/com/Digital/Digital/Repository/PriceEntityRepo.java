package com.Digital.Digital.Repository;

import com.Digital.Digital.Entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceEntityRepo extends JpaRepository<PriceEntity, Long> {
}
