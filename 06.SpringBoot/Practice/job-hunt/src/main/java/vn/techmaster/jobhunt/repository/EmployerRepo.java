package vn.techmaster.jobhunt.repository;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import vn.techmaster.jobhunt.model.Employer;

@Repository
public class EmployerRepo {
    private ConcurrentHashMap<String, Employer> employers = new ConcurrentHashMap<>();

    public EmployerRepo() {

    }

    // Cần sinh UUID ở đây
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

    public void updateLogo(String id, String logo_path) {
        var emp = employers.get(id);
        emp.setLogo_path(logo_path);
        employers.put(id, emp);
    }

    public Employer deleteById(String id) {
        return employers.remove(id);
    }

    @PostConstruct
    public void addSomeData() {
        this.add(Employer.builder()
                .name("FPT")
                .logo_path("fpt.png")
                .website("https://fpt.com.vn")
                .email("hr@fpt.com.vn").build());
        this.add(Employer.builder()
                .name("CMC")
                .logo_path("cmc.png")
                .website("https://cmc.com.vn")
                .email("hr@cmc.com.vn").build());
    }
}
