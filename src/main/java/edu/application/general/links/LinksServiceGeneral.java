package edu.application.general.links;

import edu.application.general.common.ShortLink;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LinksServiceGeneral implements LinksService {

    private final Long SAVE_TIME_MS = 5000L;

    private final RedisTemplate<String, ShortLink> template;

    public LinksServiceGeneral(RedisTemplate<String, ShortLink> template) {
        this.template = template;
    }

    @Override
    public void save(ShortLink link) {
        template.opsForValue().set(link.getCode(), link, SAVE_TIME_MS, TimeUnit.MICROSECONDS);
    }

    @Override
    public void remove(String link) {
        template.delete(link);
    }

    @Override
    public ShortLink get(String code) {
        return template.opsForValue().get(code);
    }

    @Override
    public ShortLink randomPull() {
        String key = randomKey();
        if (key != null) {
            return get(key);
        }
        return null;
    }

    @Override
    public String randomKey() {
        return template.randomKey();
    }
}
