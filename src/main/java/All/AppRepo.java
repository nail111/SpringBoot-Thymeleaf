package All;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepo extends JpaRepository<Users,Long> {
}
