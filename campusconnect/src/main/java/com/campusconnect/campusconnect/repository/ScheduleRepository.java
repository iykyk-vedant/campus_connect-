package com.campusconnect.campusconnect.repository;

import com.campusconnect.campusconnect.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
