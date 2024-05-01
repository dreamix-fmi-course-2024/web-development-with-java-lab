package bg.fmi.web.lab.raceeventmanagement.repository;

import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.repository.sequence.RaceSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Component
//@Component("customName")
//@Repository("customName")
@Repository
public interface RacerRepository extends JpaRepository<Racer, Integer> {

}
