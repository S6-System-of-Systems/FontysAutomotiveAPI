package com.fontys_automotive.api.inzet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InzetRepository extends JpaRepository<Inzet, Long> {

}
