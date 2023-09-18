package com.creative.demo.repositories;

import com.creative.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {

}
