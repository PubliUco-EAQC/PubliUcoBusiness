package co.edu.uco.publiuco.business.business;


import co.edu.uco.publiuco.business.domain.PersonaDomain;

import java.util.List;
import java.util.UUID;

public interface PersonaBusiness {
    void register(PersonaDomain domain);

    List<PersonaDomain> list(PersonaDomain domain);

    void modify(PersonaDomain domain);

    void drop(UUID domain);
}
