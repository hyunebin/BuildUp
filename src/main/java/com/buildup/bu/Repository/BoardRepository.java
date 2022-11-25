package com.buildup.bu.Repository;

import com.buildup.bu.Persist.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
