package com.buildup.bu.Repository;

import com.buildup.bu.Persist.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
