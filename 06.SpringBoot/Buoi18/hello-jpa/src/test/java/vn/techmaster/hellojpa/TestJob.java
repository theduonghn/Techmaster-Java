package vn.techmaster.hellojpa;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import vn.techmaster.hellojpa.model.Job;

@DataJpaTest
class TestJob {
    @Autowired
    private EntityManager entityManager;

    @Test
    void addJob() {
        Job job = Job.builder()
                .title("Java developer")
                .description("Kinh nghiệm 12 tháng")
                .build();

        entityManager.persist(job);
        assertThat(job.getId()).isNotNull();
        assertThat(job.getId().toString()).hasSizeGreaterThan(10);
    }
}
