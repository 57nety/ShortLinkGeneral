package edu.application.general.links;

import edu.application.general.common.ShortLink;

public interface LinksService {

    void save(ShortLink link);

    void remove(String link);

    ShortLink get(String code);

    ShortLink randomPull();

    String randomKey();
}
