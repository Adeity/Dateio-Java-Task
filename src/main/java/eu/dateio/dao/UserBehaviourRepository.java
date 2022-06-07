package eu.dateio.dao;

import eu.dateio.model.UserBehaviour;
import eu.dateio.model.UserBehaviourId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBehaviourRepository extends JpaRepository<UserBehaviour, UserBehaviourId> {
}
