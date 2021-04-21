package extrafieldlogin.services;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class LoginAttemptService {

	private final int MAX_ATTEMPT = 3;
	private LoadingCache<String, Integer> attemptCache;

	public LoginAttemptService() {
			super();
			attemptCache = CacheBuilder
			.newBuilder()
			.expireAfterWrite(MAX_ATTEMPT, TimeUnit.DAYS)
			.build(new CacheLoader<String, Integer>(){
					public Integer load(String key) throws Exception {
						return 0;
					};
				}
			);
		}
	
	public void loadSuccess(String ip) {
		attemptCache.invalidate(ip);
	}
	
	public void loadFailure(String ip) {
		int count = 0;
		try {
			count = attemptCache.get(ip);
		}catch(ExecutionException e) {
			count =0;
		}
		count++;
		attemptCache.put(ip, count);
	}
	
	public Boolean isBlocked(String ip) {
		try {
			return attemptCache.get(ip) >= MAX_ATTEMPT;
		}catch(ExecutionException w) {
			return false;
		}
	}
	
}

