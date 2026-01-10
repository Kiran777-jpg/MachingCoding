package parkinglot.repositories;

import parkinglot.models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    private HashMap<Long, Gate> gates = new HashMap<>();

    public Optional<Gate> findByGateId(Long Id) {
        return Optional.of(gates.get(Id));
    }
}
