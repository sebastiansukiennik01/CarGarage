package com.example.application;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface KlientRepository extends JpaRepository<Klient, String> {

}

@Component
@RequiredArgsConstructor
class SqlServerDemo{
    private final KlientRepository klientRepository;
    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        klientRepository.findAll().forEach(System.out::println);
    }
}
