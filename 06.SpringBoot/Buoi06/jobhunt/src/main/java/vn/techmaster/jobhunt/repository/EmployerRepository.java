package vn.techmaster.jobhunt.repository;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import vn.techmaster.jobhunt.model.Employer;

@Repository
public class EmployerRepository {
    private ConcurrentHashMap<String, Employer> employers = new ConcurrentHashMap<>();

    public EmployerRepository() {
    }

    public Employer add(Employer employer) {
        String id = UUID.randomUUID().toString();
        employer.setId(id);
        employers.put(id, employer);
        return employer;
    }

    public Collection<Employer> getAll() {
        return employers.values();
    }

    public Employer findById(String id) {
        return employers.get(id);
    }

    @PostConstruct
    public void addSomeData() {
        this.add(Employer.builder().name("FPT").website("https://fpt.com.vn").email("hr@fpt.com.vn")
                .logo_path("FPT-transparent.png").build());
        this.add(Employer.builder().name("CMC").website("https://cmc.com.vn").email("hr@cmc.com.vn")
                .logo_path("cmc.svg").build());
        this.add(Employer.builder().name("Amazon").website("https://amazon.com").email("hr@amazon.com")
                .logo_path("amazon.png").build());
        this.add(Employer.builder().name("Google").website("https://google.com").email("hr@google.com")
                .logo_path("google.png").build());
    }
}
