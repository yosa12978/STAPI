package org.yosa.stapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yosa.stapi.domain.Character;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> fingByOrderByIdDesc();
}
